package com.acme.mytrader.price;

public class PriceSourceImpl implements PriceSource {
	
	PriceListener listener;

	public PriceSourceImpl(PriceListener listener) {
		this.listener=listener;
	}

	@Override
	public void addPriceListener(PriceListener listener) {
		// TODO Auto-generated method stub
		System.out.println("Add Price Listener from Database");

	}

	@Override
	public void removePriceListener(PriceListener listener) {
		// TODO Auto-generated method stub
		System.out.println("Remove Price Listener from database");

	}

}
