package com.aim2code.aopDemo.DAO;

import com.aim2code.aopDemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;

    private String serviceCode;

    @Override
    public void AddAccount(Account account,Boolean vipFlag) {
        System.out.println(getClass()+": Doing my DB work: ADDING AN ACCOUNT");
    }

    @Override
    public Boolean checkAccount() {
        System.out.println(getClass()+": inside checkAccount()");
        return true;
    }

    public String getServiceCode() {
        System.out.println(getClass()+": inside getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+": inside setServiceCode()");
        this.serviceCode = serviceCode;
    }

    public String getName() {
        System.out.println(getClass()+": inside getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+": inside setName()");
        this.name = name;
    }

    @Override
    public List<Account> findAccounts(boolean b) {
        List<Account> accounts = new ArrayList<>();
        if(b)
            throw new RuntimeException("Arrayre akasham looooona, kalalekantunava !");
        //create sample accounts
        Account account1 = new Account("vijay","004110");
        Account account2 = new Account("Naveen","004111");
        Account account3 = new Account("Sushanth","004112");
        //add them to our account list
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        //System.out.println(getClass()+": inside findAccounts() from AccountsDAOImpl");

        return accounts;
    }
}
