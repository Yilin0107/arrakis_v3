package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByEmployeeEmail(String employeeEmail);

}
