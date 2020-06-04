package com.acme.mytrader.strategy;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.execution.ExecutionServiceImpl;
import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.PriceListenerImpl;
import com.acme.mytrader.price.PriceSource;
import com.acme.mytrader.price.PriceSourceImpl;

public class TradingStrategyTest {
	
	private ExecutionService executionService;
	private PriceListener priceListener;
	private PriceSource priceSource;
	private TradingStrategy tradingStrategy;
	
	@Before
	public void setup() {		
		executionService = new ExecutionServiceImpl();
		priceListener = new PriceListenerImpl();
		priceSource = new PriceSourceImpl(priceListener);
		tradingStrategy = new TradingStrategy(executionService, priceListener, priceSource);
	}
	
    @Test
    public void testBuyStrategy() {
    	assertEquals("Buy IBM stocks success", tradingStrategy.buyingStrategy("IBM", 55d, 1));
        assertEquals("Monitor Buy IBM stocks success", tradingStrategy.monitorStrategy("IBM", 55d,200d));

    }

    @Test
    public void testSellStrategy() {
    	assertEquals("Sell Amazon stocks success", tradingStrategy.sellingStrategy("Amazon", 80d, 10));

    }

    @Test
    public void testNotBuyStrategy() {
    	assertEquals("Buy IBM stocks fail", tradingStrategy.buyingStrategy("IBM", 10d, 10));
        assertEquals("Buy IBM stocks success", tradingStrategy.buyingStrategy("IBM", 65d, 1));
        assertEquals("Monitor Buy IBM stocks Failed", tradingStrategy.monitorStrategy("IBM", 55d,200d));


    }

    @Test
    public void testNotSellStrategy() {
    	assertEquals("Sell Amazon stocks fail", tradingStrategy.sellingStrategy("Amazon", 150d, 10));
    }
}
