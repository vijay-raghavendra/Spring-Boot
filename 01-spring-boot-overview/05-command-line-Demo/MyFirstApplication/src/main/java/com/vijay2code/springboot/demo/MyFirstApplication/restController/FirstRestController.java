package com.vijay2code.springboot.demo.MyFirstApplication.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {
	
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
