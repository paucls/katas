package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class FizzBuzzerShould {
    private val fizzBuzzer = FizzBuzzer()

    @Test
    internal fun `output number as string`() {
        assertThat(fizzBuzzer.fizzBuzz(1)).isEqualTo("1")
    }

    @Test
    internal fun `output number 2 as string`() {
        assertThat(fizzBuzzer.fizzBuzz(2)).isEqualTo("2")
    }

    @Test
    internal fun `output Fizz for multiples of 3`() {
        assertThat(fizzBuzzer.fizzBuzz(3)).isEqualTo("Fizz")
    }
}
