package com.aim2code.aopDemo;

import com.aim2code.aopDemo.DAO.AccountDAO;
import com.aim2code.aopDemo.DAO.MemberShipDAO;
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
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MemberShipDAO memberShipDAO) {
        return runner ->{

            demoTheAfterReturningAdvice(accountDAO);
        };
    }

    private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {

        List<Account> accounts = accountDAO.findAccounts();

        System.out.println("---------------------------");
        System.out.println("Main Program: demoTheAfterReturningAdvice");
        System.out.println("---------------------------");

        System.out.println("Accounts: " + accounts);
    }




}
