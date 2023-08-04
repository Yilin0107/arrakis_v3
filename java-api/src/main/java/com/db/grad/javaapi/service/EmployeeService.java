package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(int id);

    List<Bond> getBondsByEmployeeId(int employeeId);

    Employee findByEmployeeEmail(String email);
}
