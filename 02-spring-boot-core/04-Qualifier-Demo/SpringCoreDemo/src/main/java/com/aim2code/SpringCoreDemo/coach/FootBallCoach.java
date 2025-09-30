package com.aim2code.SpringCoreDemo.coach;

import org.springframework.stereotype.Component;

@Component
public class FootBallCoach implements Coach {

	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Practice till you become sunil Chetri";
	}

}
