package com.steve.boot.launch;

import com.steve.boot.launch.config.springEvent.Listener1;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ImportResource(locations = "classpath:otherConfig/beans.xml")
@MapperScan(basePackages = {"com.steve.boot.launch.mapper"})
@EnableJpaAuditing
@ServletComponentScan
public class BootLaunchApplication {
    public static void main(String[] args) {
        //下面语句使得Log4j2日志输出使用异步处理，减小输出日志对性能的影响
        System.setProperty("Log4jContextSelector",
                "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        ConfigurableApplicationContext context = SpringApplication.run(BootLaunchApplication.class, args);
        context.addApplicationListener(new Listener1());
    }

}
