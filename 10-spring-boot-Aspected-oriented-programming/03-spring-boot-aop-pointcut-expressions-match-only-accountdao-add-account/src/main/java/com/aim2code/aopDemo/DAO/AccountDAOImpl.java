package com.aim2code.aopDemo.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @Override
    public void AddAccount() {
        System.out.println(getClass()+": Doing my DB work: ADDING AN ACCOUNT");
    }
}
