package com.aim2code.aopDemo.Aspect;

import com.aim2code.aopDemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Aspect
@Component
@Order(1)
public class MyDemoLoginAspect {

    //this is where we add all of our related advices for logging

    //add a new advice for @AfterReturning on the findAccounts()

    @Around("execution(* com.aim2code.aopDemo.service.*.*(..))")
    public Object aroundGetFortune(ProceedingJoinPoint pjp) throws Throwable{

        //print out the method we are advising on
        String signature = pjp.getSignature().toShortString();
        System.out.println("Executing the @Around Advice on the method : "+signature);
        //get begin timeStamp
        long start = System.nanoTime();
        System.out.println("Start Time : "+start);
        //now, lets execute the method
        Object result = null;
        try{
            result = pjp.proceed();
        } catch (Exception e) {

            System.out.println("Exception Message: "+e.getMessage());
            result = "Major Accident! But no worries as we have nothing to lose";
        }

        //get the end timestamp
        long end = System.nanoTime();
        System.out.println("End Time : "+end);
        //compute the duration and display it
        long time = end - start;
        System.out.println("Duration for execution : "+time + " Nano seconds");

        return result;
    }

    @AfterReturning(
            pointcut = "execution(* com.aim2code.aopDemo.DAO.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterreturningFindAccounts(JoinPoint joinPoint, List<Account> result) {
        //print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====> Execution @AfterReturning on method: "+method);

        //print out the result of the method call
        System.out.println("\n====>result Before modifing the DATA: "+result);

        //Let's post process it before the data is sent to main application
        //so i am converting the name/account name into upperCase
        convertAccountNameToUpperCase(result);

        System.out.println("\n====>result After the modifing the DATA: "+result);
    }


    private void convertAccountNameToUpperCase(List<Account> result) {

        for (Account account : result) {
            String accountNameUpper =  account.getAccountName().toUpperCase();
            account.setAccountName(accountNameUpper);
        }
    }

    @AfterThrowing(
            pointcut = "execution(* com.aim2code.aopDemo.DAO.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccounts(JoinPoint joinPoint, Throwable theExc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====> Execution @AfterThrowing on method: "+method);

        System.out.println("The Exception is : "+theExc);
    }

    @After("execution(* com.aim2code.aopDemo.DAO.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccounts(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====> Execution @After Advice on method: "+method);

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
