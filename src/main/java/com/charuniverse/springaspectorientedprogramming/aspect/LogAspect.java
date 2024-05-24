package com.charuniverse.springaspectorientedprogramming.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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

    @Around("helloServiceMethod()")
    public Object aroundHelloServiceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        try {
            log.info("Around Before {}.{}()", className, methodName);
            return joinPoint.proceed(joinPoint.getArgs());
        } catch (Throwable throwable) {
            log.error("Around Error {}.{}()", className, methodName);
            throw throwable;
        } finally {
            log.info("Around Finally {}.{}()", className, methodName);
        }
    }

    @Pointcut("execution(* com.charuniverse.springaspectorientedprogramming.service.HelloService.*(java.lang.String))")
    public void pointcutHelloServiceStringParam() {
    }

    @Before("pointcutHelloServiceStringParam()")
    public void beforeHelloServiceStringParam(JoinPoint joinPoint) {
        String value = (String) joinPoint.getArgs()[0];
        log.info("Execute method with parameter: {}", value);
    }

    @Pointcut("execution(* com.charuniverse.springaspectorientedprogramming.service.*.*(..))")
    public void pointcutServicePackage() {
    }

    @Pointcut("bean(*Service)")
    public void pointcutServiceBean() {
    }

    @Pointcut("execution(public * *(..))")
    public void pointcutPublicMethod() {
    }

    @Pointcut("pointcutServicePackage() && pointcutServiceBean() && pointcutPublicMethod()")
    public void pointcutMethodForService() {
    }

    @Before("pointcutMethodForService()")
    public void logAllServiceMethod() {
        log.info("Log for all service methods");
    }
}
