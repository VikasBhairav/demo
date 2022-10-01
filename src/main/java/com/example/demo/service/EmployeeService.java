package com.example.demo.service;

import com.example.demo.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public Optional<Employee> getEmployeeById(Integer id);

    public List<Employee> getAllEmployees();

    public Employee add(Employee employee);

    public Employee update(Employee employee);
}
