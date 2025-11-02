package com.aim2code.aopDemo.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoginAspect {

    //this is where we add all of our related advices for logging

    //lets start with an @Before advice
    @Before("com.aim2code.aopDemo.Aspect.AimAOPPointCutExpressions.forDAOPackageNoSetterGetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n====> Executing @Before Advice from AccountAdvice on method()");

        //Get the method Signature and Print the output
        MethodSignature  signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method(): "+signature);
  
        //Get the method Arguments and Print the same
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.print("arg: "+arg+", ");
        }

    }





}
