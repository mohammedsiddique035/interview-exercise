package com.acme.mytrader.price;

import java.math.BigDecimal;

public interface PriceListener {
    void priceUpdate(String security, double price);
    Double currentStockPrice(String security);
}
