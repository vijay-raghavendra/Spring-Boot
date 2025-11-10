package com.aim2code.aopDemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {
    @Override
    public String getFortune()  {

        //simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //return a fortune
        return "Expect heavy traffic for today";
    }

    @Override
    public String getFortune(Boolean exceptionFlag) {
        if(exceptionFlag){
            throw new RuntimeException("Major Accident take diversion");
        }
        return getFortune();
    }
}
