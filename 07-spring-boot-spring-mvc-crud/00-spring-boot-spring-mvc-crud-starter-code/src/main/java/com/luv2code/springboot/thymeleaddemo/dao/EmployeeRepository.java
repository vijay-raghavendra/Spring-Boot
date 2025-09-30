package com.luv2code.springboot.thymeleaddemo.dao;

import com.luv2code.springboot.thymeleaddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!
    //add a method to sort by first name
    public List<Employee> findAllByOrderByFirstNameAsc();
}
