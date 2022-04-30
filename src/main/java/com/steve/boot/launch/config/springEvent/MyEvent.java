package com.steve.boot.launch.config.springEvent;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {
    public MyEvent(Object source){
        super(source);
    }
}
