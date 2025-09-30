package com.aim2code.SpringCoreDemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aim2code.SpringCoreDemo.coach.Coach;

@RestController
public class DemoController {
	
	private Coach newCoach;
	
	
	  @Autowired public DemoController(@Qualifier("vollyBallCoach") Coach coach) { 
		  newCoach=coach;
		  }
	 
	/*
	 * @Autowired public void setCoach(Coach theCoach) { newCoach=theCoach;
	 * 
	 * }
	 */
	
	@GetMapping("/dailyWorkout")
	public String getDailyWorkout() {
		return newCoach.getDailyWorkOut();
	}
}
