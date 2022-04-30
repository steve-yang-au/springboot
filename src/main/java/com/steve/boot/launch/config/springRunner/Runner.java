package com.steve.boot.launch.config.springRunner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class Runner {

    @Bean
    public CommandLineRunner runner2(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("runner2");
            }
        };
    }
    @Bean
    public CommandLineRunner runner1(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("runner1");
            }
        };
    }
    @Bean
    public ApplicationRunner runner3(){
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                System.out.println("runner3");
            }
        };
    }
}
