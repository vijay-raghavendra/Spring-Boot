package com.aim2code.SpringCoreDemo.coach;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class CricketCoach implements Coach {

	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Practice till you become Virat Kohli";
	}

}
