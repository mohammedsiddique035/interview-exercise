package com.acme.mytrader.strategy;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.execution.ExecutionServiceImpl;
import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.Matchers.isA;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class ExecutionServiceTest {

    private ExecutionService executionService;

    @Before
    public void setup() {
        executionService = new ExecutionServiceImpl();
    }

    @Test//tradingStrategy.buyingStrategy("IBM", 55d, 1));
    public void testBuyStrategy() {
        assertEquals(200,executionService.getCurrentVolume("IBM"));
    }



}
