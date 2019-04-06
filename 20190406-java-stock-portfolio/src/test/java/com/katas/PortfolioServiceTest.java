package com.katas;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PortfolioServiceTest {

    public static final String COMPANY = "Acme corporation";
    private OperationsRepository operationsRepository;
    private PortfolioService portfolioService;

    @Before
    public void setUp() {
        operationsRepository = mock(OperationsRepository.class);
        portfolioService = new PortfolioService(operationsRepository);
    }

    @Test
    public void should_record_the_buy_of_shares_operation() {
        portfolioService.buyShares(COMPANY, 100);

        verify(operationsRepository).save(new Operation(COMPANY, 100));
    }

    @Test
    public void should_record_the_sell_of_shares_operation() {
        portfolioService.sellShares(COMPANY, 100);

        verify(operationsRepository).save(new Operation(COMPANY, -100));
    }
}
