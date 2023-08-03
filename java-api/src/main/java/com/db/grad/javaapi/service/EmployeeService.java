package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Employee;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }
}
