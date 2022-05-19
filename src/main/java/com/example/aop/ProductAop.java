package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
// @Configuration
public class ProductAop {
    private final Logger log = LoggerFactory.getLogger(ProductAop.class);

    @Before(value = "execution(* com.example.controller.*.*(..))")
    public void BeforeRunning(JoinPoint joinPoint) {
        log.info("Executing {}", joinPoint);
    }

    @After(value = "execution(* com.example.controller.*.*(..))")
    public void AfterRunning(JoinPoint joinPoint) {
        log.info("Completed {}", joinPoint);
    }

    @Around(value = "execution(* com.example.controller.*.*(..))")
    public Object Timetracker(ProceedingJoinPoint proceedingJoinPoint) {
        long startTime = System.currentTimeMillis();
        Object obj = null;
        try {
            obj = proceedingJoinPoint.proceed();
            long timeTaken = System.currentTimeMillis() - startTime;
            log.info("Time Taken by {} is {}", proceedingJoinPoint, timeTaken);
        } catch (Throwable e) {
            log.error("Exception has Occurred");
            e.printStackTrace();
        }

        return obj;
    }
}
