package com.aim2code.SpringCoreDemo.coach;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
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
