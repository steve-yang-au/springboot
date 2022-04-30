package com.steve.boot.launch.config.servletFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterRegistration {
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CustomFilter());
        registrationBean.setName("customFilter");
        registrationBean.addUrlPatterns("/thymeleaf/*");
        registrationBean.setOrder(10);
        return registrationBean;
    }
}
