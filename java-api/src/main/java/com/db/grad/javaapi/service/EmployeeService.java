package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(int id);

    List<Bond> getBondsByEmployeeId(int employeeId);

    Employee findByEmployeeEmail(String email);

    Map<String, List<Bond>> findBondsByEmployeeIdGroupedByBook(int employeeId);

    Set<String> findBooksByEmployeeId(int employeeId);
}
