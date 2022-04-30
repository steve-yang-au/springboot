package com.steve.boot.launch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    String hello(HttpServletRequest request, HttpSession session){
        request.setAttribute("a","a");
        request.getAttribute("a");
        request.removeAttribute("a");

        ServletContext context = request.getServletContext();
        session.setAttribute("a","a");
        session.invalidate();

        context.setAttribute("a","a");
        context.removeAttribute("a");
        context.setAttribute("a","b");
        return "Hello";
    }
}
