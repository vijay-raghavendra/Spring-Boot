package com.luv2code.springboot.thymeleafdemo.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLogingAspect {

    //setup Logger
    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    public void controllerPointCut() {}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    public void daoPointCut() {}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    public void servicePointCut() {}

    @Pointcut("controllerPointCut() || daoPointCut() || servicePointCut()")
    public void allInOnePointCut() {}

    //Add Before Advice
    @Before("allInOnePointCut()")
    public void beforeAllInOnePointCut(JoinPoint joinPoint) {

        //display the method we are calling
        String Method =  joinPoint.getSignature().toShortString();
        logger.info("In @Before : Calling Method: " + Method);

        //display the arguments to the method
        //get the arguments
        Object[] args = joinPoint.getArgs();

        //loop through and display the args
        for(Object arg : args){
            logger.info("In arg : " + arg);
        }

    }

    @AfterReturning(
            pointcut = "allInOnePointCut()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {

        //display the method we are calling
        String Method =  joinPoint.getSignature().toShortString();
        logger.info("In @AfterReturing : Calling Method: " + Method);

        //display the data that is returned
        logger.info("In result : " + result);
    }
}
