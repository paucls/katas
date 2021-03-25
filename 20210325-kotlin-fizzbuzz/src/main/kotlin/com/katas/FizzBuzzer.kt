package com.katas

class FizzBuzzer {

    fun fizzBuzz(number: Int): String = when {
        isFizzBuzz(number) -> "FizzBuzz"
        isFizz(number) -> "Fizz"
        isBuzz(number) -> "Buzz"
        else -> number.toString()
    }

    private fun isFizzBuzz(number: Int) = isFizz(number) && isBuzz(number)

    private fun isFizz(number: Int) = number % 3 == 0

    private fun isBuzz(number: Int) = number % 5 == 0
}
