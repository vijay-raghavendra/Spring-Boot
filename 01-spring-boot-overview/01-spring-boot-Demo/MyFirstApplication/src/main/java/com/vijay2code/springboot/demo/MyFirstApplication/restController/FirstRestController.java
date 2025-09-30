package com.vijay2code.springboot.demo.MyFirstApplication.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {
	
	// Expose "/" That return "Hello World"
	@GetMapping("/")
	public String sayHello() {
		return "Hi Vijay keep going";
	}
	
	@GetMapping("/hello")
	public String sayHi() {
		return "Hi Vijay keep going lots of work to do";
	}
	

}
