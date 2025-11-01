package com.aim2code.aopDemo.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class MemberShipDAOImpl implements MemberShipDAO {
    @Override
    public void AddAccount() {
        System.out.println(getClass()+": Doing my DB work: ADDING AN MEMBER ACCOUNT");
    }
}
