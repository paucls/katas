package com.katas

class FizzBuzzer {
    fun fizzBuzz(number: Int): String {
        if (isMultipleOf5(number)) return "Buzz"
        if (isMultipleOf3(number)) return "Fizz"
        return number.toString()
    }

    private fun isMultipleOf3(number: Int) = number % 3 == 0

    private fun isMultipleOf5(number: Int) = number % 5 == 0
}
