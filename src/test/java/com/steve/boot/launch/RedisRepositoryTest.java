package com.steve.boot.launch;

import com.steve.boot.launch.dao.redis.PersonRepository;
import com.steve.boot.launch.model.Address;
import com.steve.boot.launch.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Optional;

@SpringBootTest
public class RedisRepositoryTest {

    @Resource
    PersonRepository personRepository;

    @Test
    public void test(){

        Person rand = new Person("zimug", "汉神");
        rand.setAddress(new Address("杭州", "中国"));
        personRepository.save(rand);  //存

        Optional<Person> op = personRepository.findById(rand.getId()); //取
        Person p2 = op.get();

        System.out.println(personRepository.count()); //统计Person的数量
        //personRepository.delete(rand);  //删除person对象rand

    }

}