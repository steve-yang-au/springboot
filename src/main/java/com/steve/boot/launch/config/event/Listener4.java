package com.steve.boot.launch.config.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Listener4 {

    @EventListener
    public void onApplicationEvent(MyEvent event) {
        log.info(String.format("%s listened an event: %s.",
                Listener4.class.getName(),
                event.getSource()));
    }
}
