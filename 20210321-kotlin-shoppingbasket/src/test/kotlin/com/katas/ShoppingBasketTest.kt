package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ShoppingBasketTest {
    @Test
    fun `should have total zero when is empty`() {
        val shoppingBasket = ShoppingBasket(emptyList())
        assertThat(shoppingBasket.total).isZero()
    }

    @Test
    fun `should calculate total when single item`() {
        val shoppingBasket = ShoppingBasket(listOf(Item(100, 1)))
        assertThat(shoppingBasket.total).isEqualTo(100)
    }
}
