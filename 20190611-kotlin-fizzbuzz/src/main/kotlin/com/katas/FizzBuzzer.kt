package com.katas

class FizzBuzzer {
    fun fizzBuzz(number: Int): String {
        return when {
            number.isMultipleOf(3) && number.isMultipleOf(5) -> "FizzBuzz"
            number.isMultipleOf(5) -> "Buzz"
            number.isMultipleOf(3) -> "Fizz"
            else -> number.toString()
        }
    }
}

fun Int.isMultipleOf(number: Int): Boolean {
    return this % number == 0
}