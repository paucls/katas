package com.katas

class ShoppingBasket(private val items: List<Item>) {
    val total: Int
        get() = if (items.isEmpty()) 0 else items.sumBy { it.price }
}
