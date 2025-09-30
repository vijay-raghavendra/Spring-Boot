package com.aim2code.SpringCoreDemo.coach;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class FootBallCoach implements Coach {

	public FootBallCoach() {
		System.out.println("In Constructor :"+getClass().getSimpleName());
	}
	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Practice till you become sunil Chetri";
	}

}
