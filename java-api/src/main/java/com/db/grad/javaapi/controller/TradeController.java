package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trades")
public class TradeController {
    private final TradeService tradeService;

    @Autowired
    public TradeController(final TradeService tradeService) {
        this.tradeService = tradeService;
    }


    @GetMapping
    public List<Trade> getAllTrades() {
        return tradeService.findAllTrades();
    }
}