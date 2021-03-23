package com.katas;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingBasketTest {

    private ShoppingBasket shoppingBasket;

    @Test
    public void should_have_total_price_of_0_when_empty() {
        shoppingBasket = aShoppingBasket();
        assertThat(shoppingBasket.getTotal()).isZero();
    }

    @Test
    public void should_calculate_total_for_one_item() {
        shoppingBasket = aShoppingBasket(new Item(100, 1));
        assertThat(shoppingBasket.getTotal()).isEqualTo(100);
    }

    @Test
    public void should_calculate_total_for_multiple_items() {
        shoppingBasket = aShoppingBasket(new Item(100, 1), new Item(20, 1));
        assertThat(shoppingBasket.getTotal()).isEqualTo(120);
    }

    @Test
    public void should_calculate_total_for_item_with_quantity_more_than_one() {
        shoppingBasket = aShoppingBasket(new Item(100, 2));
        assertThat(shoppingBasket.getTotal()).isEqualTo(200);
    }

    private ShoppingBasket aShoppingBasket(Item... items) {
        return new ShoppingBasket(Arrays.asList(items));
    }
}
