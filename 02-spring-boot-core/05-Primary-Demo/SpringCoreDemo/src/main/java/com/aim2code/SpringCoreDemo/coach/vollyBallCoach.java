package com.aim2code.SpringCoreDemo.coach;

import org.springframework.stereotype.Component;

@Component
public class vollyBallCoach implements Coach{

	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Practice till you become idol of vollyBall game in india.";
	}

}
