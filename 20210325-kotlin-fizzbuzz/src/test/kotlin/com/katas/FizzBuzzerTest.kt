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
    internal fun `should return the string 2 for number 2`() {
        assertThat(fizzBuzzer.fizzBuzz(2)).isEqualTo("2")
    }
}
