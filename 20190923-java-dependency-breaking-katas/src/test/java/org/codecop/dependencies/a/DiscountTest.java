package org.codecop.dependencies.a;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DiscountTest {

    private MarketingCampaign marketingCampaignMock;
    private Discount discount;

    @Before
    public void setUp() {
        marketingCampaignMock = mock(MarketingCampaign.class);
        discount = new Discount(marketingCampaignMock);
    }

    @Test
    public void calculates_discount_when_amount_over_1000_and_crazy_sales_day() {
        when(marketingCampaignMock.isCrazySalesDay()).thenReturn(true);

        Money net = new Money(1002);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("851.7")), total);
    }

    @Test
    public void calculates_discount_when_amount_over_1000_and_no_crazy_sales_day() {
        when(marketingCampaignMock.isCrazySalesDay()).thenReturn(false);

        Money net = new Money(1002);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("901.8")), total);
    }

}
