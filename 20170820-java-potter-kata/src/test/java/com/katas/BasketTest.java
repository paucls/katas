package com.katas;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BasketTest {

    @Test
    public void no_discount_for_single_book() throws Exception {
        Basket basket = new Basket(Arrays.asList("first book"));

        // Assert
        assertThat(basket.calculateTotal(), is(8.00));
    }

}
