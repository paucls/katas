package com.katas;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PortfolioServiceTest {
    @Test
    public void should_record_the_buy_of_shares_operation() {
        OperationsRepository operationsRepository = mock(OperationsRepository.class);
        PortfolioService portfolioService = new PortfolioService(operationsRepository);

        portfolioService.buyShares("Company A", 100);

        verify(operationsRepository).save(new Operation("Company A", 100));
    }
}
