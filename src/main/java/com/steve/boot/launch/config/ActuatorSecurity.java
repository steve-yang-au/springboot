package com.steve.boot.launch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ActuatorSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and()
                .authorizeRequests()
                //有ACTUATOR_ADMIN角色标识的用户才能访问
                .antMatchers("/actuator/*").hasRole("ACTUATOR_ADMIN")
                //必须登录认证才能访问
                .antMatchers("/actuator/*").authenticated();
    }
}