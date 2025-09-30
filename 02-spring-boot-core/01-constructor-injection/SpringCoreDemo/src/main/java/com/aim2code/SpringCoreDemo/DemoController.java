package com.aim2code.SpringCoreDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	private Coach newCoach;
	
	@Autowired
	public DemoController(Coach coach)
	{
		newCoach=coach;
	}

	@GetMapping("/dailyWorkout")
	public String getDailyWorkout() {
		return newCoach.getDailyWorkOut();
	}
}
