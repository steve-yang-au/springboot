package com.steve.boot.launch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ImportResource(locations = "classpath:beans.xml")
public class BootLaunchApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootLaunchApplication.class, args);
    }

}
