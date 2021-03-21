package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ShoppingBasketTest {
    @Test
    fun `should have total zero when is empty`() {
        val shoppingBasket = ShoppingBasket()
        assertThat(shoppingBasket.total).isZero()
    }
}
