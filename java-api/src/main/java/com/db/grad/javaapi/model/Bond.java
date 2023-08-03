package com.db.grad.javaapi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
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
}