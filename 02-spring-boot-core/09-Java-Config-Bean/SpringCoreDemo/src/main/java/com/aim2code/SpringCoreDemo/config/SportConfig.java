package com.aim2code.SpringCoreDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.aim2code.SpringCoreDemo.coach.*;

@Configuration
public class SportConfig {
	
	@Bean("Marine")
	public Coach swimCoach() {
		return new swimCoach();
	}

}
