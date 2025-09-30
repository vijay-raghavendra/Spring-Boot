package com.aim2code.Cruddemo.ServiceLayer;

import com.aim2code.Cruddemo.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(int id);

    public Employee saveOrUpdateEmployee(Employee employee);

    public int deleteEmployee(int id);
}
