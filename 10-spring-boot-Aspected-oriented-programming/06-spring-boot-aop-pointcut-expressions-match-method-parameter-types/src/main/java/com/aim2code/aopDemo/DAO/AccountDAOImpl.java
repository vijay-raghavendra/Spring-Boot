package com.aim2code.aopDemo.DAO;

import com.aim2code.aopDemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void AddAccount(Account account) {
        System.out.println(getClass()+": Doing my DB work: ADDING AN ACCOUNT");
    }
}
