package org.codecop.dependencies.a;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class DiscountTest {

    @Test
    public void discount_when_net_price_is_more_than_1000() {
        Discount discount = new Discount();

        Money net = new Money(1002);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("901.8")), total);
    }

}
