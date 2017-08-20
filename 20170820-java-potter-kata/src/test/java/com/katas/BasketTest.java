package com.katas;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BasketTest {

    @Test
    public void no_discount_for_single_book() throws Exception {
        Basket basket = new Basket(Collections.singletonList("first book"));

        assertThat(basket.calculateTotal(), is(8.00));
    }

    @Test
    public void no_discount_for_multiple_copies_same_book() throws Exception {
        Basket basket = new Basket(Arrays.asList("first book", "first book", "first book"));

        assertThat(basket.calculateTotal(), is(24.00));
    }


}
