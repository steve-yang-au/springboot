package com.steve.boot.lauch;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.steve.boot.lauch.model.LombokPOJO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootLauchApplication {

    public static void main(String[] args) {
        LombokPOJO lombokPOJO = LombokPOJO.builder().name("Steve").age(22).build();
        System.out.println(lombokPOJO);
        SpringApplication.run(BootLauchApplication.class, args);
    }

}
