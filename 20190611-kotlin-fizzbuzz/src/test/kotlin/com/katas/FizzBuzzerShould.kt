package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class FizzBuzzerShould {

    private val fizzBuzzer = FizzBuzzer()

    @Test
    fun `return a string representing the number`() {
        assertThat(fizzBuzzer.fizzBuzz(1)).isEqualTo("1")
        assertThat(fizzBuzzer.fizzBuzz(2)).isEqualTo("2")
    }

    @Test
    fun `return Fizz for numbers divisible by 3`() {
        assertThat(fizzBuzzer.fizzBuzz(3)).isEqualTo("Fizz")
        assertThat(fizzBuzzer.fizzBuzz(6)).isEqualTo("Fizz")
    }

    @Test
    fun `return Buzz for numbers divisible by 5`() {
        assertThat(fizzBuzzer.fizzBuzz(5)).isEqualTo("Buzz")
        assertThat(fizzBuzzer.fizzBuzz(10)).isEqualTo("Buzz")
    }

    @Test
    fun `return FizzBuzz for number divisible by 3 and 5`() {
        assertThat(fizzBuzzer.fizzBuzz(15)).isEqualTo("FizzBuzz")
    }
}