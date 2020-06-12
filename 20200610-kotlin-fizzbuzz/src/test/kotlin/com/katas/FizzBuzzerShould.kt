package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FizzBuzzerShould {
    private val fizzBuzzer = FizzBuzzer()

    @Test
    internal fun `output number as string`() {
        assertThat(fizzBuzzer.fizzBuzz(1)).isEqualTo("1")
    }
}
