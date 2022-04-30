package com.steve.boot.launch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class InterceptorsRegistration implements WebMvcConfigurer {
    @Resource
    CustomHandlerInterceptor customHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //the registration order is the execution order
        registry.addInterceptor(customHandlerInterceptor)
                .addPathPatterns("/thymeleaf/*");
        /**
         * the interceptor have to point to a specific controller like we have done above
         * if setting like this down bellow, the interceptor is not going to work effectively:
         *
         * registry.addInterceptor(customHandlerInterceptor).addPathPatterns("/*");
         *
         *
         */
    }
}
