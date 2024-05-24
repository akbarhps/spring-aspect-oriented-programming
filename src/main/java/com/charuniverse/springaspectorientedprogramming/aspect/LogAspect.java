package com.charuniverse.springaspectorientedprogramming.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("target(com.charuniverse.springaspectorientedprogramming.service.HelloService)")
    public void helloServiceMethod() {
    }

    @Before("helloServiceMethod()")
    public void beforeHelloServiceMethod(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        log.info("Before {}.{}()", className, methodName);
    }

    @Before("helloServiceMethod()")
    public void beforeHelloServiceMethod2() {
        log.info("Before HelloService method Again");
    }
}
