package com.steve.boot.launch.config.springEvent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Listener2 implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        log.info(String.format("%s listened an event: %s.",
                Listener2.class.getName(),
                event.getSource()));
    }
}
