package com.aim2code.aopDemo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudLogSyncAspect {

    //lets start with an @Before advice
    @Before("com.aim2code.aopDemo.Aspect.AimAOPPointCutExpressions.forDAOPackageNoSetterGetter()")
    public void logToCloudeSync() {
        System.out.println("====> Executing @Before Advice from CloudCluster on method()");

    }
}
