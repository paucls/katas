package com.katas;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingBasketTest {

    private final ShoppingBasket shoppingBasket = new ShoppingBasket();

    @Test
    public void should_have_a_total_of_zero_when_empty() {
        assertThat(shoppingBasket.getTotal()).isZero();
    }
}
