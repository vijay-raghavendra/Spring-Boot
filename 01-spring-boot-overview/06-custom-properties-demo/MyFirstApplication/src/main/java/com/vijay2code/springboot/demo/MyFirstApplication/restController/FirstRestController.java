package com.vijay2code.springboot.demo.MyFirstApplication.restController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {
	
	//defining the @Value 
	@Value("${captain.name}")
	private String CaptName;
	
	@Value("${team.name}")
	private String TeamsName;
	
	//exposing new end point to access the above values
	@GetMapping("/CrickInfo")
	public String Squard() {
		return "Team Name:"+TeamsName+", Captain Name: "+CaptName;
	}
	
	// Expose "/" That return "Hello World"
	@GetMapping("/")
	public String sayHello() {
		return "Hi Vijay keep going nice mava nice !";
	}
	
	@GetMapping("/Fetch_workData")
	public String newWork() {
		return "Lots of work to Do";
	}

}
