package com.aim2code.aopDemo;

import com.aim2code.aopDemo.DAO.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO) {
        return runner ->{
            demoTheBeforeAdvice(accountDAO);
        };
    }

    private void demoTheBeforeAdvice(AccountDAO accountDAO) {
        //call the business method
        accountDAO.AddAccount();

        // Do it again
        System.out.println("\n lets Call it again! \n");

        //call the business method
        accountDAO.AddAccount();

    }


}
