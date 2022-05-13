package com.steve.boot.launch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.steve.boot.launch.model.Address;
import com.steve.boot.launch.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.Jackson2HashMapper;

import javax.annotation.Resource;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Redis3Test{

    @Resource
    private RedisTemplate<String, Person> redisTemplate;

    private final HashMapper<Object, String, Object> jackson2HashMapper = new Jackson2HashMapper(false);

    @Test
    public void testHashPutAll(){
        HashOperations<String, String,Object> jacksonHashOperations = redisTemplate.opsForHash();
        Person person = new Person("kobe","bryant");
        person.setId("kobe");
        person.setAddress(new Address("洛杉矶","美国"));

        //将对象以hash的形式放入redis数据库
        Map<String,Object> mappedHash = jackson2HashMapper.toHash(person);
        jacksonHashOperations.putAll("player:" + person.getId(), mappedHash);

        //将对象从数据库取出来
        Map<String,Object> loadedHash = jacksonHashOperations.entries("player:" + person.getId());
        Object map = jackson2HashMapper.fromHash(loadedHash);
        Person getBack = new ObjectMapper().convertValue(map,Person.class);

        //Junit5,验证放进去的和取出来的数据一致
        assertEquals(person.getFirstname(),getBack.getFirstname());
    }
}
