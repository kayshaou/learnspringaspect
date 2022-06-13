package com.example.learnspringaspect.aspect;

import com.example.learnspringaspect.Account;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
@Slf4j
@Order(1)
public class LoggingAspectChild {

    @Around("execution(* com.example.learnspringaspect.service.TrafficFortuneService.getFortune(..))")
    public Object around(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        log.info(" method is {}",method);

        long begin = System.currentTimeMillis();
        log.info(" start {}",begin);

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception ex) {
            log.info("@Aspect about to throw {}", ex.getMessage());
            throw ex;
        }


        long end = System.currentTimeMillis();
        log.info(" end {}",end);
        log.info(" duration {}", (end-begin)/1000.0+" secs ");
        return result;
    }

    @AfterThrowing(pointcut = "execution(* com.example.learnspringaspect.dao.*.*())",
            throwing="theExec")
    public void afterThrowing(JoinPoint jp, Throwable theExec){
        log.error("@AfterThrowing {}",theExec.getMessage());
    }

    // run before afterThrow
    @After("execution(* com.example.learnspringaspect.dao.*.findAccounts())")
    public void after(JoinPoint jp){
        log.info("@after will run {}",jp.getSignature());

    }

    @Before("com.example.learnspringaspect.aspect.LoggingAspect.exceptGetterSetter()")
    public void exceptGetterSetter(JoinPoint jp){
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        log.info("Method called: {}", methodSignature.getMethod());
        Arrays.stream(jp.getArgs()).filter(o -> o instanceof Account)
                .map(o -> {
                    Account a = (Account) o;
                    return a.getServiceCode();
                }).forEach(System.out::println);
    }

    @AfterReturning(
            pointcut = "execution(* com.example.learnspringaspect.dao.*.findAccounts())",
            returning = "resultYayBaby")
    public void afterReturningFindAccountsAdvice(JoinPoint jp, List<Account> resultYayBaby){
        String method = jp.getSignature().toShortString();
        log.info("@AfterReturning method {}", method);

        resultYayBaby.stream().forEach(f -> {
                f.setName(f.getName().toUpperCase());
        });
    }

}

