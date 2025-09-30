package com.aim2code.SpringCoreDemo.coach;

import org.springframework.stereotype.Component;

public class swimCoach implements Coach{
	
	public swimCoach() {
		System.out.println("In Constructor : "+getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Swimming is Fun, when you know to Swim,\n HaHa !...";
	}

}
