package com.aim2code.SpringCoreDemo.coach;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class vollyBallCoach implements Coach{

	public vollyBallCoach() {
		System.out.println("In Constructor :"+getClass().getSimpleName());
	}
	
	//Define our Init Method
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println("in doMyStartUpStuff(): "+getClass().getSimpleName());
	}
	
	//Define Our Destroy Method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("in doMyCleanUpStuff(): "+getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Practice till you become idol of vollyBall game in india.";
	}

}
