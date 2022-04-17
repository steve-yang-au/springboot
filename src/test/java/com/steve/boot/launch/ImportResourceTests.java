package com.steve.boot.launch;

import com.steve.boot.launch.model.Family;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ImportResourceTests {

    @Resource
    private ConfigurableApplicationContext ioc;

    @Test
    public void testImport(){
        boolean isImport = ioc.containsBean("testBeanService");
        System.out.println(isImport);
    }


}
