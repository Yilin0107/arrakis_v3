package com.db.grad.javaapi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trade_id;

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