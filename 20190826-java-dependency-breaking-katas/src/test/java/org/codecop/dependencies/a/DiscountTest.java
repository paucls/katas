package org.codecop.dependencies.a;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DiscountTest {

    private final MarketingCampaign campaignMock;
    private final Discount discount;

    public DiscountTest() {
        campaignMock = mock(MarketingCampaign.class);
        discount = new Discount(campaignMock);
    }

    @Test
    public void discount_when_net_price_is_more_than_1000() {
        when(campaignMock.isCrazySalesDay()).thenReturn(false);

        Money net = new Money(1002);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("901.8")), total);
    }

    @Test
    public void discount_when_is_crazy_sale_day() {
        when(campaignMock.isCrazySalesDay()).thenReturn(true);

        Money net = new Money(1000);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("850")), total);
    }

    @Test
    public void discount_when_net_price_is_more_than_100_and_campaign_is_active() {
        when(campaignMock.isCrazySalesDay()).thenReturn(false);
        when(campaignMock.isActive()).thenReturn(true);

        Money net = new Money(101);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("95.95")), total);
    }

    @Test
    public void no_discount() {
        when(campaignMock.isCrazySalesDay()).thenReturn(false);

        Money net = new Money(99);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("99")), total);
    }
}
