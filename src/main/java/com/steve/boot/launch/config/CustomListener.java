package com.steve.boot.launch.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Slf4j
//@WebListener
public class CustomListener implements ServletContextListener,
                                       ServletRequestListener,
                                       HttpSessionListener,
                                    ServletContextAttributeListener,
                                    ServletRequestAttributeListener,
                                    HttpSessionAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        log.info("==========================attribute added in servlet context.");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        log.info("==========================attribute removed in servlet context.");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        log.info("==========================attribute replaced in servlet context.");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("==========================servlet context is initialized.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("==========================servlet context is destroyed.");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        log.info("==========================attribute added in request.");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        log.info("==========================attribute removed in request.");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        log.info("==========================attribute replaced in request.");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("==========================request is destroyed.");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("==========================request is initialized.");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        log.info("==========================attribute added in session.");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        log.info("==========================attribute removed in session.");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        log.info("==========================attribute replaced in session.");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("==========================session is initialized.");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("==========================session is destroyed.");
    }
}
