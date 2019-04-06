package com.katas;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class StockPortfolioAcceptanceTest {

    private Console console;
    private PortfolioService portfolio;

    @Before
    public void setUp() {
        console = mock(Console.class);
        portfolio = new PortfolioService();
    }

    @Test
    public void should_print_current_portfolio() {
        portfolio.buyShares("Old School Waterfall Software LTD", 1000);
        portfolio.buyShares("Crafter Masters Limited", 200);
        portfolio.buyShares("XP Practitioners Incorporated", 200);
        portfolio.sellShares("Old School Waterfall Software LTD", 500);
        portfolio.buyShares("Crafter Masters Limited", 200);

        portfolio.print();

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("company | shares | current price | current value");
        inOrder.verify(console).printLine("Old School Waterfall Software LTD | 500 | $5.75 | $2785.75");
        inOrder.verify(console).printLine("Crafter Masters Limited | 400 | $17.25 | $6900.00");
        inOrder.verify(console).printLine("XP Practitioners Incorporated | 700 | $15.00 | $4500.00");
    }
}
