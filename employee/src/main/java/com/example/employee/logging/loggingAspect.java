package com.example.employee.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class loggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(loggingAspect.class);

    @Before("execution(* com.example.employee.*..*(..)) && args(..)")
    public void before(JoinPoint joinPoint) {
        LOGGER.info("Invoked: " + joinPoint.getSignature().getName() + " ()");
        System.out.println(Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(* com.example.employee.*..*(..))")
    public void after(JoinPoint joinPoint) {
        LOGGER.info("Exit: " + joinPoint.getSignature().getName() + " ()");
    }


}
