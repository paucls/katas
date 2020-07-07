package com.katas

class Calculator {
    fun add(numbers: String): Int {
        if (numbers.isEmpty())
            return 0
        return numbers.toInt()
    }
}
