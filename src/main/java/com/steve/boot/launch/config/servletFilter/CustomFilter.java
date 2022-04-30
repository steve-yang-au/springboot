package com.steve.boot.launch.config.servletFilter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
//@WebFilter(filterName = "CustomFilter", urlPatterns = {"/thymeleaf/*"})
public class CustomFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        log.info("==========================before request");
        filterChain.doFilter(servletRequest,servletResponse);
        log.info("==========================after request");

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("==========================filter is created");

    }

    @Override
    public void destroy() {
        log.info("==========================filter is destroyed");
    }
}
