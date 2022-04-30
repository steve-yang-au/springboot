package com.steve.boot.launch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ImportResource(locations = "classpath:beans.xml")
@MapperScan(basePackages = {"com.steve.boot.launch.mapper"})
@EnableJpaAuditing
@ServletComponentScan
public class BootLaunchApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootLaunchApplication.class, args);
    }

}
