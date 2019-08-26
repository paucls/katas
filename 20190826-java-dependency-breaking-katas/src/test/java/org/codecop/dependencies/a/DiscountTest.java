package org.codecop.dependencies.a;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DiscountTest {

    @Test
    public void discount_when_net_price_is_more_than_1000() {
        Discount discount = new Discount();

        Money net = new Money(1002);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("901.8")), total);
    }

    @Test
    public void discount_when_is_crazy_sale_day() {
        MarketingCampaign marketingCampaignMock = mock(MarketingCampaign.class);
        when(marketingCampaignMock.isCrazySalesDay()).thenReturn(true);
        Discount discount = new Discount(marketingCampaignMock);

        Money net = new Money(1000);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("850")), total);
    }

}
