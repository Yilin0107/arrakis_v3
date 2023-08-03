package com.db.grad.javaapi.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "employee_surname")
    private String employeeSurname;

    @Column(name = "employee_email")
    private String employeeEmail;

    @Column(name = "employee_department")
    private String employeeDepartment;

    @Column(name = "employee_role")
    private String employeeRole;

    @Column(name = "employee_password_hash")
    private String employeePasswordHash;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Bond> bonds;

    public void setEmployeePasswordHash(String employeePasswordHash) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.employeePasswordHash = passwordEncoder.encode(employeePasswordHash);
    }
}