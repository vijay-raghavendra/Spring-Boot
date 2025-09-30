package com.aim2code.Cruddemo.RestControllerClasses;

import com.aim2code.Cruddemo.Entity.Employee;
import com.aim2code.Cruddemo.ErrorClasses.EmployeeNotFound;
import com.aim2code.Cruddemo.ServiceLayer.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    private ObjectMapper objectMapper;

    @Autowired
    public EmployeeController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
       List<Employee> empList = employeeService.getAllEmployees();

       if(empList.isEmpty()){
           throw new EmployeeNotFound("No Data Found from employee table");
       }
        return empList;
    }

    @GetMapping("/employees/{employee_Id}")
    public Employee getEmployeeById(@PathVariable int employee_Id){

        Employee employee = employeeService.getEmployeeById(employee_Id);
        if(employee_Id<0)
        {
            throw new EmployeeNotFound("employee Id Cannot be Negative : "+ employee_Id);
        } else if (employee == null) {
            throw new EmployeeNotFound("employee Id :"+  employee_Id + " not found in Database");
        }
        else {
            return employee;
        }
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.saveOrUpdateEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.saveOrUpdateEmployee(employee);
    }

    @PatchMapping("/employees/{employee_Id}")
    public Employee partiallyUpdateEmployee(@PathVariable int employee_Id, @RequestBody Map<String,Object> patchPayLoad)
    {
        Employee theEmployee = employeeService.getEmployeeById(employee_Id);
        
        if(theEmployee == null)
        {
            throw new EmployeeNotFound("employee Id :"+  employee_Id + " not found in Database for Update");
        } else if (patchPayLoad.containsKey("id")) {
            throw new EmployeeNotFound("Cannot Update the Id of the existing Employee");
        }
        else {
            Employee patchedEmployee = apply(patchPayLoad, theEmployee);

            return employeeService.saveOrUpdateEmployee(patchedEmployee);

        }
    }

    private Employee apply(Map<String, Object> patchPayLoad, Employee theEmployee) {

        //convert employee object to the JSON object Node
        ObjectNode employeeNode = objectMapper.convertValue(theEmployee, ObjectNode.class);

        //Convert Map patchPayLoad to the JSON object Node
        ObjectNode payLoadNode = objectMapper.convertValue(patchPayLoad, ObjectNode.class);

        //merge the nodes
        employeeNode.setAll(payLoadNode);

        //Convert the JSON Node to Employee object and return
        return objectMapper.convertValue(employeeNode, Employee.class);
    }

    @DeleteMapping("/employees/{employee_id}")
    public String deleteEmployee(@PathVariable int employee_id){
        employeeService.deleteEmployee(employee_id);
        return "Employee Deleted Successfully";
    }

}
