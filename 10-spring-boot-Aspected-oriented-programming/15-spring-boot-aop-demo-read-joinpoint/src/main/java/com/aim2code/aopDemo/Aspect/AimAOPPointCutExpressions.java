package com.aim2code.aopDemo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect //this is optional when no advices are used in the class
@Component
public class AimAOPPointCutExpressions {

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
}
