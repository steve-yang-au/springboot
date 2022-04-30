package com.steve.boot.launch.exception;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ModelViewAspect {

    @Pointcut("@annotation(com.steve.boot.launch.exception.ModelView)")
    public void pointcut(){}

    @AfterThrowing(pointcut = "pointcut()", throwing = "cause")
    public void afterThrowing(Throwable cause){
       throw  ModelViewException.transfer(cause);
    }
}
