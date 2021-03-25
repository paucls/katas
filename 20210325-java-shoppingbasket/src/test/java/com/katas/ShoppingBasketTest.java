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
    public void should_calculate_total_for_one_item() {
        shoppingBasket = aShoppingBasket(new Item(100.0, 1));
        assertThat(shoppingBasket.getTotal()).isEqualTo(100.0);
    }

    @Test
    public void should_calculate_total_for_item_with_quantity_larger_than_one() {
        shoppingBasket = aShoppingBasket(new Item(25.0, 2));
        assertThat(shoppingBasket.getTotal()).isEqualTo(50.0);
    }

    @Test
    public void should_apply_5p_discount_when_total_is_more_than_100() {
        shoppingBasket = aShoppingBasket(new Item(50.0, 4));
        assertThat(shoppingBasket.getTotal()).isEqualTo(190.0);
    }

    @Test
    public void should_apply_10p_discount_when_total_is_more_than_200() {
        shoppingBasket = aShoppingBasket(new Item(50.0, 5));
        assertThat(shoppingBasket.getTotal()).isEqualTo(225.0);
    }

    private ShoppingBasket aShoppingBasket(Item... items) {
        return new ShoppingBasket(Arrays.asList(items));
    }
}
