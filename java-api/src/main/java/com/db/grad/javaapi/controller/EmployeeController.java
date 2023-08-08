package com.db.grad.javaapi.controller;


import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Employee;
import com.db.grad.javaapi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    public EmployeeController(final EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeServiceImpl.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable final int id) {
        Optional<Employee> employee = employeeServiceImpl.getEmployeeById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/bonds")
    public ResponseEntity<List<Bond>> getBondsByEmployeeId(@PathVariable final int id) {
        if (Objects.isNull(getEmployeeById(id).getBody())) {
               return ResponseEntity.notFound().build();
        }
        List<Bond> bonds = employeeServiceImpl.getBondsByEmployeeId(id);
        return ResponseEntity.ok(bonds);
    }

    @GetMapping("/books/{employeeId}")
    public ResponseEntity<Set<String>> findBooksByEmployeeId(@PathVariable final int employeeId) {
        Set<String> result = employeeServiceImpl.findBooksByEmployeeId(employeeId);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }
}