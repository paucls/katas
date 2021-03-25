package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FizzBuzzerTest {

    private val fizzBuzzer = FizzBuzzer()

    @Test
    fun `should return the string representation of given number when not divisible by 3 or 5`() {
        assertThat(fizzBuzzer.fizzBuzz(1)).isEqualTo("1")
        assertThat(fizzBuzzer.fizzBuzz(2)).isEqualTo("2")
        assertThat(fizzBuzzer.fizzBuzz(4)).isEqualTo("4")
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

    @Test
    fun `should return FizzBuzz for numbers divisible by 3 and 5`() {
        assertThat(fizzBuzzer.fizzBuzz(15)).isEqualTo("FizzBuzz")
    }
}
