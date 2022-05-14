package com.steve.boot.launch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class SessionController {

    @RequestMapping(value="/uid",method = RequestMethod.GET)
    @ResponseBody
    public String uid(HttpSession session) {
        return "sessionId:" + session.getId();
    }

}