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

    @Test
    fun `output Fizz for multiples of 3`() {
        assertThat(fizzBuzzer.fizzBuzz(3)).isEqualTo("Fizz")
    }
}
