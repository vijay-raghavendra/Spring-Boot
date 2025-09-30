package com.aim2code.Cruddemo.SpringDataJPA;

import com.aim2code.Cruddemo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
