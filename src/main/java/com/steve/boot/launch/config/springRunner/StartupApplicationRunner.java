package com.steve.boot.launch.config.springRunner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class StartupApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        log.info("ApplicationRunner got parameter names: {}", args.getOptionNames() );
        log.info("ApplicationRunner got parameter values: {}", args.getOptionValues("age"));
        log.info("ApplicationRunner got parameter {}", Arrays.toString(args.getSourceArgs()));

    }
}
