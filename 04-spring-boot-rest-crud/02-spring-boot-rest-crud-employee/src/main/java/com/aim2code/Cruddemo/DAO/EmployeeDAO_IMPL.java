package com.aim2code.Cruddemo.DAO;

import com.aim2code.Cruddemo.Entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAO_IMPL implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAO_IMPL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> getAllEmployees() {
        return entityManager.createQuery("from Employee e", Employee.class).getResultList();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee saveOrUpdateEmployee(Employee employee) {
        Employee emp = entityManager.merge(employee);
        return emp;
    }


    @Override
    public int deleteEmployee(int id) {
        Employee emp = entityManager.find(Employee.class, id);
        entityManager.remove(emp);
        return  emp.getId();
    }
}
