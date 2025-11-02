package com.aim2code.aopDemo.DAO;

import com.aim2code.aopDemo.Account;
import org.springframework.stereotype.Repository;

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
}
