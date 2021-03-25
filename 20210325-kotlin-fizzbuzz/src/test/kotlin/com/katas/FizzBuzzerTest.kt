package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FizzBuzzerTest {

    private val fizzBuzzer = FizzBuzzer()

    @Test
    fun `should return the string 1 for number 1`() {
        assertThat(fizzBuzzer.fizzBuzz(1)).isEqualTo("1")
    }
}
