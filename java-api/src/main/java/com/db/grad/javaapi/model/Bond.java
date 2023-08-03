package com.db.grad.javaapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Bond {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String isin;

    private String bond_currency;

    private String cusip;

    private int face_value;

    private String issuer_name;

    private Date bond_maturity_date;

    private String status;

    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    private Employee employee;

    @OneToMany(mappedBy = "bond", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Trade> trades;
}