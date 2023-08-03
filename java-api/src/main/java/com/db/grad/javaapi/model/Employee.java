package com.db.grad.javaapi.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;

    private String employee_name;

    private String employee_surname;

    private String employee_email;

    private String employee_department;

    private String employee_role;

    private String employee_password_hash;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Bond> bonds;

}