package com.steve.boot.launch.config.springRunner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class Runner {

    @Bean
    public CommandLineRunner runner2(){
        return args -> log.info("runner2 running");
    }
    @Bean
    public CommandLineRunner runner1(){
        return args -> log.info("runner1 running");
    }
    @Bean
    public ApplicationRunner runner3(){
        return args -> log.info("runner3 running");
    }
}
