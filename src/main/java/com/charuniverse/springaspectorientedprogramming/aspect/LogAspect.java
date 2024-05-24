package com.charuniverse.springaspectorientedprogramming.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Pointcut("target(com.charuniverse.springaspectorientedprogramming.service.HelloService)")
    public void helloServiceMethod() {
    }

}
