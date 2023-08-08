package com.db.grad.javaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PasswordUpdateRunner implements CommandLineRunner {
    private final EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    public PasswordUpdateRunner(final EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @Override
    public void run(String... args) throws Exception {
        employeeServiceImpl.initializeEmployeesPasswordHash();
    }
}