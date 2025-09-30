package com.aim2code.SpringCoreDemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aim2code.SpringCoreDemo.coach.Coach;

@RestController
public class DemoController {
	
	private Coach newCoach;
	
	private Coach anotherCoach;
	
	
	  @Autowired 
	  public DemoController(@Qualifier("vollyBallCoach") Coach coach,
			  				@Qualifier("vollyBallCoach") Coach theAnotherCoach) { 
		  System.out.println("In Constructor :"+getClass().getSimpleName());
		  newCoach=coach;
		  anotherCoach=theAnotherCoach;
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
	
	@GetMapping("/Check")
	public String check() {
		return "Comparing Beans newCoach == anotherCoach:-" + (newCoach==anotherCoach);
	}
	
}
