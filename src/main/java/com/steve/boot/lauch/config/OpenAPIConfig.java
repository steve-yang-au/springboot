package com.steve.boot.lauch.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public GroupedOpenApi restApi(){
        return GroupedOpenApi.builder()
                .group("restful-api")
                .pathsToMatch("/restful/**")
                .build();
    }

    @Bean
    public GroupedOpenApi helloApi(){
       return GroupedOpenApi.builder()
                .group("hello")
                .pathsToMatch("/hello/**")
                .build();
    }
}
