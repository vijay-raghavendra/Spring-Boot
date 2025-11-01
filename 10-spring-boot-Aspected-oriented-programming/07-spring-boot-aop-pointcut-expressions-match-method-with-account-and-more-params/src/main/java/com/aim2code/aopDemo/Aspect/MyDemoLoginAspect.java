package com.aim2code.aopDemo.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoginAspect {

    //this is where we add all of our related advices for logging

    //lets start with an @Before advice
    @Before("execution(* Add*(com.aim2code.aopDemo.Account, ..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n====> Executing @Before Advice on method()");

    }

}
