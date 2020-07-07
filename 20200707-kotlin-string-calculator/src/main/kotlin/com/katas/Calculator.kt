package com.katas

class Calculator {
    private val delimiter = arrayOf(",")

    fun add(numbers: String): Int {
        if (numbers.isEmpty()) return 0

        return numbers
                .split(*delimiter)
                .map(String::toInt)
                .sum()
    }
}
