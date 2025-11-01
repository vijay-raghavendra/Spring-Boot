package com.aim2code.aopDemo.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoginAspect {

    //Create a point cut declaration
    @Pointcut("execution(* com.aim2code.aopDemo.DAO.*.*(..))")
    public void forDAOPackage(){}

    //this is where we add all of our related advices for logging

    //lets start with an @Before advice
    @Before("forDAOPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n====> Executing @Before Advice on method()");

    }

}
