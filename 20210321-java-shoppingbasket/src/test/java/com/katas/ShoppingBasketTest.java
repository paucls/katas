package com.katas;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingBasketTest {

    private ShoppingBasket shoppingBasket;

    @Test
    public void should_have_a_total_of_zero_when_empty() {
        shoppingBasket = new ShoppingBasket();
        assertThat(shoppingBasket.getTotal()).isZero();
    }

    @Test
    public void should_calculate_total_for_single_item() {
        shoppingBasket = new ShoppingBasket(Arrays.asList(new Item(100, 1)));
        assertThat(shoppingBasket.getTotal()).isEqualTo(100);
    }
}
