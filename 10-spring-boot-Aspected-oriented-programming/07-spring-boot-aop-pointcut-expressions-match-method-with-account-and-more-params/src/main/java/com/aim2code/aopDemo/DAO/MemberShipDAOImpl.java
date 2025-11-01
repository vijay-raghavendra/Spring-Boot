package com.aim2code.aopDemo.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class MemberShipDAOImpl implements MemberShipDAO {
    @Override
    public Boolean AddMember() {
        System.out.println(getClass()+": Doing my DB work: ADDING AN MEMBER ACCOUNT");
        return true;
    }
}
