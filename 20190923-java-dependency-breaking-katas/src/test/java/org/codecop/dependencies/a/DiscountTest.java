package org.codecop.dependencies.a;

import java.math.BigDecimal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiscountTest {

    @Test
    public void calculates_discount_on_crazy_sales_day() {
        Discount discount = new Discount();

        Money net = new Money(1002);
        Money total = discount.discountFor(net);

        assertEquals(new Money(new BigDecimal("851.7")), total);
    }

}
