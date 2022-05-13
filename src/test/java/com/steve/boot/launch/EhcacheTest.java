package com.steve.boot.launch;

import com.steve.boot.launch.ehCache.ClassB;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class EhcacheTest {
    @Resource
    ClassB classB;

    @Test
    public void methodA()  {
        System.out.println(classB.methodA1("hello, Ehcache..."));
    }
}
