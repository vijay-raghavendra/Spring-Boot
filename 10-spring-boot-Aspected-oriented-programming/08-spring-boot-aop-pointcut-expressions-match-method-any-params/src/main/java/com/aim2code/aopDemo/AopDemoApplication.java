package com.aim2code.aopDemo;

import com.aim2code.aopDemo.DAO.AccountDAO;
import com.aim2code.aopDemo.DAO.MemberShipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MemberShipDAO memberShipDAO) {
        return runner ->{
            demoTheBeforeAdvice(accountDAO,memberShipDAO);
        };
    }

    private void demoTheBeforeAdvice(AccountDAO accountDAO, MemberShipDAO memberShipDAO) {
        //call the business method
        Account account = new Account();
        accountDAO.AddAccount(account,true);

        //call the membership business method
        memberShipDAO.AddMember();

       /* // Do it again
        System.out.println("\n lets Call it again! ");

        //call the business method
        accountDAO.AddAccount();*/

    }


}
