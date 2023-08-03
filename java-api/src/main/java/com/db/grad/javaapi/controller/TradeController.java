package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trades")
public class TradeController {
    @Autowired
    private TradeRepository tradeRepository;

    @GetMapping
    public List<Trade> getAllTrades() {
        return tradeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Trade getTradeById(@PathVariable Long id) {
        return tradeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Trade createTrade(@RequestBody Trade trade) {
        return tradeRepository.save(trade);
    }

//    @PutMapping("/{id}")
//    public Trade updateTrade(@PathVariable Long id, @RequestBody Trade updatedTrade) {
//        Trade trade = tradeRepository.findById(id).orElse(null);
//        if (trade != null) {
//            // Update the trade properties from the updatedTrade object
//            trade.setTradeType(updatedTrade.getTradeType());
//            trade.setTradeCurrency(updatedTrade.getTradeCurrency());
//            // ... Set other properties
//
//            return tradeRepository.save(trade);
//        }
//        return null;
//    }

    @DeleteMapping("/{id}")
    public void deleteTrade(@PathVariable Long id) {
        tradeRepository.deleteById(id);
    }
}