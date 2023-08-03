package com.db.grad.javaapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    @JoinColumn(name = "isin", referencedColumnName = "isin", insertable = false, updatable = false)
    private Bond bond;

    private String isin;

    @Column(name = "trade_type")
    private String tradeType;

    @Column(name = "trade_currency")
    private String tradeCurrency;

    private int quantity;

    @Column(name = "trade_settlement_date")
    private Date tradeSettlementDate;

    @Column(name = "trade_status")
    private String tradeStatus;

    @Column(name = "trade_date")
    private Date tradeDate;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "coupon_percent")
    private double couponPercent;

    private String bookName;

    private String bondHolder;
}