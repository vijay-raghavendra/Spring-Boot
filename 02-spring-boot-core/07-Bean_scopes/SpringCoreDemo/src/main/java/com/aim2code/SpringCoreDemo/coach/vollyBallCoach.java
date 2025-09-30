package com.aim2code.SpringCoreDemo.coach;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class vollyBallCoach implements Coach{

	public vollyBallCoach() {
		System.out.println("In Constructor :"+getClass().getSimpleName());
	}
	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Practice till you become idol of vollyBall game in india.";
	}

}
