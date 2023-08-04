package com.db.grad.javaapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(name = "bond_currency")
    private String bondCurrency;

    private String cusip;

    @Column(name = "face_value")
    private int faceValue;

    @Column(name = "issuer_name")
    private String issuerName;

    @Column(name = "bond_maturity_date")
    private Date bondMaturityDate;

    private String status;

    private String type;

    @Column(name = "employee_id")
    private int employeeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    private Employee employee;

    @OneToMany(mappedBy = "bond", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Trade> trades;
}