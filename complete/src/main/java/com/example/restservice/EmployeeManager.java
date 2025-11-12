package com.example.restservice;

import com.example.restservice.*;

public class EmployeeManager {

    private Employee employee1;
    private Employee employee2;
    private Employee employee3;

    private Employees employees;

    public EmployeeManager(){
        employees = new Employees();

        employee1= new Employee("100","Mohamed", "Shaaban", "S@gmail.com", "SW");
        employee2= new Employee("101","Mohamed", "Ali", "A@gmail.com", "SW");
        employee3= new Employee("102","Mohamed", "Awdi", "AW@gmail.com", "SW");

        employees.setEmployees(employee1);
        employees.setEmployees(employee2);
        employees.setEmployees(employee3);

    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employee employee) {
        employees.setEmployees(employee);
    }
}