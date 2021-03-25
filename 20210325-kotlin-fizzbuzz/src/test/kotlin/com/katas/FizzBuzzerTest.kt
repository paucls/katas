package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FizzBuzzerTest {

    private val fizzBuzzer = FizzBuzzer()

    @Test
    fun `should return the string 1 for number 1`() {
        assertThat(fizzBuzzer.fizzBuzz(1)).isEqualTo("1")
    }

    @Test
    fun `should return the string 2 for number 2`() {
        assertThat(fizzBuzzer.fizzBuzz(2)).isEqualTo("2")
    }

    @Test
    fun `should return Fizz for numbers divisible by 3`() {
        assertThat(fizzBuzzer.fizzBuzz(3)).isEqualTo("Fizz")
        assertThat(fizzBuzzer.fizzBuzz(9)).isEqualTo("Fizz")
    }

    @Test
    fun `should return Buzz for numbers divisible by 5`() {
        assertThat(fizzBuzzer.fizzBuzz(5)).isEqualTo("Buzz")
        assertThat(fizzBuzzer.fizzBuzz(25)).isEqualTo("Buzz")
    }
}
