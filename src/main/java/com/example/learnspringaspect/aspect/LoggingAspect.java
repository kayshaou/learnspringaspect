package com.example.learnspringaspect.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect

@Component
@Slf4j
public class LoggingAspect {
    // any return type, from dao package, any method name, any number of arguments
    @Pointcut("execution(* com.example.learnspringaspect.dao.*.*(..))")
    private void forBefore() {
    }

    @Pointcut("execution(* com.example.learnspringaspect.dao.*.get*(..))")
    private void getter(){

    }

    @Pointcut("execution(* com.example.learnspringaspect.dao.*.set*(..))")
    private void setter(){

    }

    @Pointcut("forBefore() && (getter() || setter())")
    public void onlyGetterSetter() {

    }

    @Pointcut("forBefore() && !(getter() || setter())")
    public void exceptGetterSetter() {
        log.info("@Before 2 - Advice on Account ");
    }




}
