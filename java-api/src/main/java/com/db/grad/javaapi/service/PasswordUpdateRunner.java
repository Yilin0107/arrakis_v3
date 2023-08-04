package com.db.grad.javaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PasswordUpdateRunner implements CommandLineRunner {
    private final EmployeeService employeeService;

    @Autowired
    public PasswordUpdateRunner(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        employeeService.initializeEmployeesPasswordHash();
    }
}