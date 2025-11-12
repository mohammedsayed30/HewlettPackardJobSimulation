package com.example.restservice;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    //list of employees
    private List<Employee> Employees ;

    public Employees() {
        this.Employees = new ArrayList<>();
    }

    @JsonProperty("Employees")
    public List<Employee> getEmployees() {
        return Employees;
    }

    public void setEmployees(Employee employee) {
        Employees.add(employee);
    }
}