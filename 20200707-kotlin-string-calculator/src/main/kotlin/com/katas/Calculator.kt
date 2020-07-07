package com.katas

class Calculator {
    private val delimiter = arrayOf(",", "\n")

    fun add(numbers: String): Int {
        if (numbers.isEmpty()) return 0

        var delimiters = delimiter.clone()
        if (numbers.startsWith("//")) {
            val customDelimiter = numbers.substring(2).split("\n")[0]
            delimiters = arrayOf(customDelimiter, "\n")

            return numbers.split("\n")[1]
                    .split(*delimiters)
                    .map(String::toInt)
                    .sum()
        }

        return numbers
                .split(*delimiters)
                .map(String::toInt)
                .sum()
    }
}
