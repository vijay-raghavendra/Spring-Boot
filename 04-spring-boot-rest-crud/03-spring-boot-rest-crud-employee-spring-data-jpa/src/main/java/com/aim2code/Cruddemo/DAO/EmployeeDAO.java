package com.aim2code.Cruddemo.DAO;

import com.aim2code.Cruddemo.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(int id);

    public Employee saveOrUpdateEmployee(Employee employee);

    public int deleteEmployee(int id);

}
