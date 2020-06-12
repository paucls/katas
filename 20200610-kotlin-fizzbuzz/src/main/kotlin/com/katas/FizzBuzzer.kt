package com.katas

class FizzBuzzer {
    fun fizzBuzz(number: Int): String {
        if (number % 3 == 0) return "Fizz"
        return number.toString()
    }
}
