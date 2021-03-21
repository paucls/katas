package com.katas

class Item(
    private val price: Int,
    private val quantity: Int
) {
    fun calculateSubTotal(): Int {
        return price * quantity
    }
}
