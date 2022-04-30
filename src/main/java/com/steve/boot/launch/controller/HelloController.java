package com.steve.boot.launch.controller;

import com.steve.boot.launch.config.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class HelloController {

    @Resource
    private ApplicationContext applicationContext;
    @RequestMapping("/hello")
    @ResponseBody
    String hello(HttpServletRequest request, HttpSession session){
        applicationContext.publishEvent(new MyEvent("event testing"));
        return "Hello";
    }
}
