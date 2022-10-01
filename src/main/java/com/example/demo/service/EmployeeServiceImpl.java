package com.example.demo.service;

import com.example.demo.Address;
import com.example.demo.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee(1, "Ram",new Address("Bangalore", "Karnataka", "India")));
        employees.add(new Employee(2, "Shyam",new Address("Mysore", "Karnataka", "India")));
        employees.add(new Employee(3, "Mohan",new Address("Dharwad", "Karnataka", "India")));
        employees.add(new Employee(4, "Murli",new Address("Tumkur", "Karnataka", "India")));
    }

    @Override
    public Optional<Employee> getEmployeeById(Integer id) {
        Optional<Employee> employeeOptional = employees.stream().filter(employee -> id == employee.getId()).findFirst();
        return employeeOptional;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee add(Employee employee) {
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        Employee savedEmployee = getEmployeeById(employee.getId()).get();
        savedEmployee.setName(employee.getName());
        return savedEmployee;
    }
}
