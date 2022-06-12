package com.example.learnspringaspect.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect

@Component
@Slf4j
public class LoggingAspect {
    // any return type, from dao package, any method name, any number of arguments
    @Before("execution(* com.example.learnspringaspect.dao.*.*(..))")

    public void beforeAddAccountAdvice() {
        log.info("@Before Advice on Account ");
    }


}
