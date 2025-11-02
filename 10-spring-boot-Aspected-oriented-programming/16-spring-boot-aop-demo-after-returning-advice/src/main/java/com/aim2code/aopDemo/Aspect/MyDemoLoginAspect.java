package com.aim2code.aopDemo.Aspect;

import com.aim2code.aopDemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class MyDemoLoginAspect {

    //this is where we add all of our related advices for logging

    //add a new advice for @AfterReturning on the findAccounts()

    @AfterReturning(
            pointcut = "execution(* com.aim2code.aopDemo.DAO.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterreturningFindAccounts(JoinPoint joinPoint, List<Account> result) {
        //print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====> Execution @AfterReturning on method: "+method);

        //print out the result of the method call
        System.out.println("\n====>result is: "+result);
    }

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
