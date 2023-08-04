package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.TradeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TradeServiceImplTest {

    @Mock
    private TradeRepository tradeRepository;

    @InjectMocks
    private TradeServiceImpl tradeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAllTrades() {
        List<Trade> trades = new ArrayList<>();
        trades.add(createTrade(1L, "ISIN1", "Buy", "USD", 100, new Date(), "Settled", new Date(), 105.5, 2.5, "Book1", "Holder1"));
        trades.add(createTrade(2L, "ISIN2", "Sell", "EUR", 50, new Date(), "Pending", new Date(), 95.0, 1.5, "Book2", "Holder2"));

        when(tradeRepository.findAll()).thenReturn(trades);

        List<Trade> result = tradeService.findAllTrades();

        assertEquals(2, result.size());
        assertEquals("ISIN1", result.get(0).getIsin());
        assertEquals(50, result.get(1).getQuantity());
    }

    private Trade createTrade(Long tradeId, String isin, String tradeType, String tradeCurrency,
                              int quantity, Date settlementDate, String tradeStatus, Date tradeDate,
                              double unitPrice, double couponPercent, String bookName, String bondHolder) {
        Trade trade = new Trade();
        trade.setTrade_id(tradeId);
        trade.setIsin(isin);
        trade.setTradeType(tradeType);
        trade.setTradeCurrency(tradeCurrency);
        trade.setQuantity(quantity);
        trade.setTradeSettlementDate(settlementDate);
        trade.setTradeStatus(tradeStatus);
        trade.setTradeDate(tradeDate);
        trade.setUnitPrice(unitPrice);
        trade.setCouponPercent(couponPercent);
        trade.setBookName(bookName);
        trade.setBondHolder(bondHolder);
        return trade;
    }
}
