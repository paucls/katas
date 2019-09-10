package org.codecop.dependencies.d;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShippingCostTest {

    private RestCountriesAPI restCountriesAPI;
    private ShippingCost shippingCost;

    @Before
    public void setUp() {
        restCountriesAPI = mock(RestCountriesAPI.class);

        shippingCost = new ShippingCost() {
            @Override
            protected RestCountriesAPI restCountriesAPI() {
                return restCountriesAPI;
            }
        };
    }

    @Test
    public void calculate_cost_when_EU_country() {
        when(restCountriesAPI.isInCommonMarket(any())).thenReturn(true);

        Money cost = shippingCost.calculate(new Country("Spain"), DeliveryOptions.STANDARD);

        assertThat(cost, equalTo(new Money(5)));
    }

    @Test
    public void calculate_cost_when_country_US_and_standard_delivery() {
        when(restCountriesAPI.isInCommonMarket(any())).thenReturn(false);
        when(restCountriesAPI.isInAmericas(any())).thenReturn(true);

        Money cost = shippingCost.calculate(new Country("US"), DeliveryOptions.STANDARD);

        assertThat(cost, equalTo(new Money(15)));
    }

    @Test
    public void calculate_cost_when_country_US_and_express_delivery() {
        when(restCountriesAPI.isInCommonMarket(any())).thenReturn(false);
        when(restCountriesAPI.isInAmericas(any())).thenReturn(true);

        Money cost = shippingCost.calculate(new Country("US"), DeliveryOptions.EXPRESS);

        assertThat(cost, equalTo(new Money(40)));
    }

    @Test
    public void calculate_cost_when_other_country() {
        when(restCountriesAPI.isInCommonMarket(any())).thenReturn(false);
        when(restCountriesAPI.isInAmericas(any())).thenReturn(false);
        when(restCountriesAPI.distanceTo(any())).thenReturn(1000);

        Money cost = shippingCost.calculate(new Country("China"), DeliveryOptions.EXPRESS);

        assertThat(cost, equalTo(new Money(100)));
    }
}
