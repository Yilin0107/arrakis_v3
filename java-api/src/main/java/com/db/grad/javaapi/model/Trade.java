package com.db.grad.javaapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trade_id;

    @ManyToOne
    @JoinColumn(name = "isin", referencedColumnName = "isin", insertable = false, updatable = false)
    private Bond bond;

    private String isin;

    private String trade_type;

    private String trade_currency;

    private int quantity;

    private Date trade_settlement_date;

    private String trade_status;

    private Date trade_date;

    private double unit_price;

    private double coupon_percent;

    private String bookName;

    private String bondHolder;
}