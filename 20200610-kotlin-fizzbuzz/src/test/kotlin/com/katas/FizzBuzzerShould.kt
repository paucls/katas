package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class FizzBuzzerShould {
    private val fizzBuzzer = FizzBuzzer()

    @ParameterizedTest
    @CsvSource(
            "1,  1",
            "4,  4"
    )
    fun `output number as string`(number: Int, output: String) {
        assertThat(fizzBuzzer.fizzBuzz(number)).isEqualTo(output)
    }

    @ParameterizedTest
    @CsvSource(
            "3,  Fizz",
            "6,  Fizz"
    )
    fun `output Fizz for multiples of 3`(number: Int, output: String) {
        assertThat(fizzBuzzer.fizzBuzz(number)).isEqualTo(output)
    }

    @Test
    internal fun `output Buzz for multiples of 5`() {
        assertThat(fizzBuzzer.fizzBuzz(5)).isEqualTo("Buzz")
    }
}
