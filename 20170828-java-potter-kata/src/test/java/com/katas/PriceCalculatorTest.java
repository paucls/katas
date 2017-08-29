package com.katas;

import org.junit.Test;
import org.junit.Before;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PriceCalculatorTest {

    private static final String FIRST_BOOK = "first book";
    private static final String SECOND_BOOK = "second book";
    private static final String THIRD_BOOK = "third book";
    private static final String FOURTH_BOOK = "fourth book";
    private static final String FIFTH_BOOK = "fifth book";

    private PriceCalculator priceCalculator;

    @Before
    public void setup() {
        priceCalculator = new PriceCalculator();
    }

    @Test
    public void no_discount_for_one_book() {
        ShoppingBasket basket = new ShoppingBasket(Collections.singletonList(FIRST_BOOK));

        assertThat(priceCalculator.calculate(basket)).isEqualTo(8.0);
    }

    @Test
    public void no_discount_for_multiple_copies_same_book() {
        ShoppingBasket basket = new ShoppingBasket(Arrays.asList(FIRST_BOOK, FIRST_BOOK));

        assertThat(priceCalculator.calculate(basket)).isEqualTo(16.0);
    }

    @Test
    public void apply_5percent_discount_for_two_different_books() {
        ShoppingBasket basket = new ShoppingBasket(Arrays.asList(FIRST_BOOK, SECOND_BOOK));

        assertThat(priceCalculator.calculate(basket)).isEqualTo(2 * 8 * 0.95);
    }

    @Test
    public void apply_10percent_discount_for_three_different_books() {
        ShoppingBasket basket = new ShoppingBasket(Arrays.asList(FIRST_BOOK, SECOND_BOOK, THIRD_BOOK));

        assertThat(priceCalculator.calculate(basket)).isEqualTo(3 * 8 * 0.90);
    }

    @Test
    public void apply_20percent_discount_for_four_different_books() {
        ShoppingBasket basket = new ShoppingBasket(Arrays.asList(FIRST_BOOK, SECOND_BOOK, THIRD_BOOK, FOURTH_BOOK));

        assertThat(priceCalculator.calculate(basket)).isEqualTo(4 * 8 * 0.80);
    }

    @Test
    public void apply_30percent_discount_for_five_different_books() {
        ShoppingBasket basket = new ShoppingBasket(Arrays.asList(FIRST_BOOK, SECOND_BOOK, THIRD_BOOK, FOURTH_BOOK, FIFTH_BOOK));

        assertThat(priceCalculator.calculate(basket)).isEqualTo(5 * 8 * 0.75);
    }

    @Test
    public void apply_5percent_discount_to_books_on_pack_but_not_to_remaining_book() {
        ShoppingBasket basket = new ShoppingBasket(Arrays.asList(FIRST_BOOK, SECOND_BOOK, SECOND_BOOK));

        assertThat(priceCalculator.calculate(basket)).isEqualTo(2 * 8 * 0.95 + 8);
    }

    @Test
    public void apply_5percent_discount_to_books_on_pack1_and_pack2_but_not_to_remaining_book() {
        ShoppingBasket basket = new ShoppingBasket(Arrays.asList(
                FIRST_BOOK, SECOND_BOOK,
                FIRST_BOOK, SECOND_BOOK,
                SECOND_BOOK));

        assertThat(priceCalculator.calculate(basket)).isEqualTo((2 * 8 * 0.95) + (2 * 8 * 0.95) + 8);
    }

}
