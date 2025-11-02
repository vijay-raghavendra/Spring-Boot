package com.aim2code.aopDemo.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoginAspect {

    //this is where we add all of our related advices for logging

    //lets start with an @Before advice
    @Before("com.aim2code.aopDemo.Aspect.AimAOPPointCutExpressions.forDAOPackageNoSetterGetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n====> Executing @Before Advice from AccountAdvice on method()");

    }





}
