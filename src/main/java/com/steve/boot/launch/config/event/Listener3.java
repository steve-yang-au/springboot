package com.steve.boot.launch.config.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

@Slf4j
public class Listener3 implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        log.info(String.format("%s listened an event: %s.",
                Listener3.class.getName(),
                event.getSource()));
    }
}
