package com.steve.boot.launch;

import com.steve.boot.launch.model.Family;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ValuebindTests {

    @Resource
    Family family;

    @Test
    public void valueBindTest(){
        System.out.println(family);
    }


}
