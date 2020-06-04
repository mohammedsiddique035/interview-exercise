package com.acme.mytrader.strategy;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.PriceSource;
import org.slf4j.Logger;
/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
public class TradingStrategy {

    private ExecutionService executionService;
    private PriceListener priceListener;
    private PriceSource priceSource;



    public TradingStrategy(ExecutionService executionService, PriceListener priceListener, PriceSource priceSource) {
        this.executionService = executionService;
        this.priceListener = priceListener;
        this.priceSource = priceSource;
    }


    public String buyingStrategy(String security, Double bidPrice, int volume) {


        Double currentStockPrice = priceListener.currentStockPrice(security);
        if(executionService.getCurrentVolume(security)>=volume) {//check volume availability before buying
            Double userQuotedPricePerStock = bidPrice / volume;
            if (currentStockPrice.compareTo(userQuotedPricePerStock) <= 0) {
                priceListener.priceUpdate(security, bidPrice);//update the bid price
                executionService.buy(security, bidPrice, volume);
                priceSource.addPriceListener(priceListener);
                return "Buy " + security + " stocks success";
            }
        }
        return "Buy "+security+" stocks fail";
    }

    public String sellingStrategy(String security, Double bidPrice, int volume) {
        Double currentStockPrice = priceListener.currentStockPrice(security);
        Double userExpectedPricePerStock = bidPrice / volume;
//since its selling no need to check the available stocks
        if (currentStockPrice.compareTo(userExpectedPricePerStock) > 0) {
            executionService.sell(security, currentStockPrice, volume);
            priceSource.removePriceListener(priceListener);
            return "Sell "+security+" stocks success";
        }
        return "Sell "+security+" stocks fail";
    }
//as soon as the bid matches the desired amount monitor service purchase all the available stocks with max amount matches
    public String monitorStrategy(String security,Double bidPrice,Double maxSpent) {
        if(priceListener.currentStockPrice(security).compareTo(bidPrice)==0){
            int currentVolume=executionService.getCurrentVolume(security);
            int volume= (int) (maxSpent/bidPrice);
            System.out.println("purchased "+volume+" "+ security +" stocks for each price of "+bidPrice);
            executionService.buy(security, bidPrice, volume);
            return "Monitor Buy IBM stocks success";
        }
        return "Monitor Buy IBM stocks Failed";
    }



}


