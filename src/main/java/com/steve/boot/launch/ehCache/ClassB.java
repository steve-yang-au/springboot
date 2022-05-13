package com.steve.boot.launch.ehCache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class ClassB   {

    public static final String USER_DETAIL = "user_detail";

    @Cacheable(value = USER_DETAIL,key = "#username")
    public String methodA1(String username) {
        return username + "value";
    }
}