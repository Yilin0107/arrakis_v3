package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Employee;
import com.db.grad.javaapi.model.LoginUser;
import com.db.grad.javaapi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    public AuthController(EmployeeServiceImpl employeeRepository) {
        this.employeeServiceImpl = employeeRepository;
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginUser user) {
        Employee existingUser = employeeServiceImpl.findByEmployeeEmail(user.getEmail());

        if (existingUser != null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (passwordEncoder.matches(user.getPassword(), existingUser.getEmployeePasswordHash())) {
                return ResponseEntity.ok("Login successful");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}