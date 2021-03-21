package com.katas;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingBasketTest {

    private ShoppingBasket shoppingBasket;

    @Test
    public void should_have_a_total_of_zero_when_empty() {
        shoppingBasket = aShoppingBasket();
        assertThat(shoppingBasket.getTotal()).isZero();
    }

    @Test
    public void should_calculate_total_for_single_item() {
        shoppingBasket = aShoppingBasket(new Item(100, 1));
        assertThat(shoppingBasket.getTotal()).isEqualTo(100);
    }

    @Test
    public void should_calculate_total_for_two_items() {
        shoppingBasket = aShoppingBasket(new Item(100, 1), new Item(20, 1));
        assertThat(shoppingBasket.getTotal()).isEqualTo(120);
    }

    private ShoppingBasket aShoppingBasket(Item... items) {
        return new ShoppingBasket(Arrays.asList(items));
    }
}
