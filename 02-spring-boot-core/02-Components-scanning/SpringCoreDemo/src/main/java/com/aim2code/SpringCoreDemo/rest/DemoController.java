package com.aim2code.SpringCoreDemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aim2code.util.CricketCoach;

@RestController
public class DemoController {
	
	private CricketCoach newCoach;
	
	@Autowired
	public DemoController(CricketCoach coach)
	{
		newCoach=coach;
	}

	@GetMapping("/dailyWorkout")
	public String getDailyWorkout() {
		return newCoach.getDailyWorkOut();
	}
}
