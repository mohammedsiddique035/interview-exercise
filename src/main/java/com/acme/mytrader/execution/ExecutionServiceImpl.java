package com.acme.mytrader.execution;

import java.util.HashMap;
import java.util.Map;

public class ExecutionServiceImpl implements ExecutionService {

    Map<String, Integer> executionServiceListDb=new HashMap<>();

    public ExecutionServiceImpl(){
        executionServiceListDb.put("IBM",200);
        executionServiceListDb.put("Amazon",150);
    }

	@Override
	public void buy(String security, double price, int volume) {
		// TODO Auto-generated method stub
        if(executionServiceListDb.get(security)-volume<0){
            try {
                throw new Exception("can not purchase the as the volume on the stock are limited");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            executionServiceListDb.put(security, executionServiceListDb.get(security) - volume);//when stocks are purchased available stocks decreases
            System.out.println(volume + " volume " + security + " stocks bye on market price of each " + price);
        }

	}

	@Override
	public void sell(String security, double price, int volume) {
		// TODO Auto-generated method stub
        executionServiceListDb.put(security,executionServiceListDb.get(security)+volume);////when stocks are purchased available stocks increases
		System.out.println(volume+" volume " +security+" stocks sell on market price of each " +price  );
	}


	public int getCurrentVolume(String security){
	    return executionServiceListDb.get(security);
    }

}
