package com.aim2code.SpringCoreDemo.coach;

import org.springframework.stereotype.Component;

@Component
public class basketBallCoach implements Coach{

	public basketBallCoach()
	{
		System.out.println("In Constructor :"+getClass().getSimpleName());
	}
	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Practice till you become idol of basketball game in india.";
	}

}
