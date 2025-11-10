package com.aim2code.aopDemo;

import com.aim2code.aopDemo.DAO.AccountDAO;
import com.aim2code.aopDemo.DAO.MemberShipDAO;
import com.aim2code.aopDemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MemberShipDAO memberShipDAO,
                                               TrafficFortuneService trafficFortuneService) {
        return runner ->{

            demoTheAroundAdviceHandleException(trafficFortuneService);
        };
    }

    private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
        System.out.println("\n Main Program : The Around Advice from demoTheAroundAdviceHandleException");
        System.out.println("Calling GetFortune");
        Boolean exceptionFlag = true;
        String data = trafficFortuneService.getFortune(exceptionFlag);
        System.out.println("The Fortune is : "+data);
    }



}
