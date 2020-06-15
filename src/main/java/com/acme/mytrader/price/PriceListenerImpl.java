package com.acme.mytrader.price;

import java.util.HashMap;
import java.util.Map;

public class PriceListenerImpl implements PriceListener {

    Map<String,Double> priceListDb=new HashMap<>();

    public PriceListenerImpl(){
        priceListDb.put("IBM",12d);
        priceListDb.put("Amazon",13d);
    }

	@Override
	public void priceUpdate(String security, double price) {
		// TODO Auto-generated method stub
		System.out.println(security +" stock "+price+" price Update in Database");
        priceListDb.put(security,price);
	}


	public Double currentStockPrice(String security) {
		System.out.println("Current stock price " + security+ priceListDb.get(security));
        return priceListDb.get(security);
	}

}
