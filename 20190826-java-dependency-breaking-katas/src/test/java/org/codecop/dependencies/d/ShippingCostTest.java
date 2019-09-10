package org.codecop.dependencies.d;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShippingCostTest {

    @Test
    public void calculate_cost_when_country_US_and_standard_delivery() {
        ShippingCost shippingCost = new ShippingCost();

        Money cost = shippingCost.calculate(new Country("US"), DeliveryOptions.STANDARD);

        assertThat(cost, equalTo(new Money(15)));
    }
}
