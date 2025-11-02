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

    //create a pointcut for getter methods
    @Pointcut("execution(* com.aim2code.aopDemo.DAO.*.get*(..))")
    public void getter(){}

    //create a pointcut for setter methods
    @Pointcut("execution(* com.aim2code.aopDemo.DAO.*.set*(..))")
    public void setter(){}

    //create a pointcut : include package ... exclude getter/setter
    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void forDAOPackageNoSetterGetter(){}

    //this is where we add all of our related advices for logging

    //lets start with an @Before advice
    @Before("forDAOPackageNoSetterGetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n====> Executing @Before Advice from AccountAdvice on method()");

    }

    //lets start with an @Before advice
    @Before("forDAOPackageNoSetterGetter()")
    public void performSomeAnalytics() {
        System.out.println("====> Executing @Before Advice from performAnalytics on method()\n");

    }

}
