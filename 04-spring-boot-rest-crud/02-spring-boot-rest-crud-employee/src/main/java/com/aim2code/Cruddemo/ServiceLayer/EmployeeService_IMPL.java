package com.aim2code.Cruddemo.ServiceLayer;

import com.aim2code.Cruddemo.DAO.EmployeeDAO;
import com.aim2code.Cruddemo.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService_IMPL implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService_IMPL(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    @Transactional
    public Employee saveOrUpdateEmployee(Employee employee) {
        return employeeDAO.saveOrUpdateEmployee(employee);
    }

    @Override
    @Transactional
    public int deleteEmployee(int id) {
        return employeeDAO.deleteEmployee(id);
    }
}
