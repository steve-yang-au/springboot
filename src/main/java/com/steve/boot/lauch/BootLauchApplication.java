package com.steve.boot.lauch;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.steve.boot.lauch.model.LombokPOJO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class BootLauchApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootLauchApplication.class, args);
    }

}
