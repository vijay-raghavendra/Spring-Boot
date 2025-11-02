package com.aim2code.aopDemo.DAO;

import com.aim2code.aopDemo.Account;

public interface AccountDAO {

    public void AddAccount(Account account, Boolean vipFlag);

    Boolean checkAccount();

    public String getServiceCode() ;

    public void setServiceCode(String serviceCode) ;

    public String getName() ;

    public void setName(String name) ;
}
