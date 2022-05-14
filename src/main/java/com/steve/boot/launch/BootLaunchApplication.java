package com.steve.boot.launch;

import com.steve.boot.launch.config.springEvent.Listener1;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.session.MapSession;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@ImportResource(locations = "classpath:otherConfig/beans.xml")
@MapperScan(basePackages = {"com.steve.boot.launch.dao.mapper"})
@EnableJpaAuditing
@ServletComponentScan
@EnableCaching
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 10)
public class BootLaunchApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BootLaunchApplication.class, args);
        context.addApplicationListener(new Listener1());
    }

}
