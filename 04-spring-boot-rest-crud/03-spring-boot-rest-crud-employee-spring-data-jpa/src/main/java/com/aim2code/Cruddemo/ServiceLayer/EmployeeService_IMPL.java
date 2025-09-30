package com.aim2code.Cruddemo.ServiceLayer;

import com.aim2code.Cruddemo.DAO.EmployeeDAO;
import com.aim2code.Cruddemo.Entity.Employee;
import com.aim2code.Cruddemo.SpringDataJPA.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService_IMPL implements EmployeeService{

    //private EmployeeDAO employeeDAO;
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService_IMPL(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            return employee.get();
        }else {
            return null;
        }
    }

    @Override
    public Employee saveOrUpdateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public int deleteEmployee(int id) {
         employeeRepository.deleteById(id);
         return 0;
    }
}
