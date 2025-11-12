package com.example.restservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController{

    private  EmployeeManager employeeManager;

    public EmployeeController(){
        this.employeeManager = new EmployeeManager();
    }

    //mapping the get request
    @GetMapping("/employees")
    public Employees getEmployees(){
        return employeeManager.getEmployees();
    }

    //add new employee
    @PostMapping("/employees")
    public Employee addEmployees(@RequestBody Employee employee){
        employeeManager.setEmployees(employee);
        return employee;
    }

}