package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FizzBuzzerShould {
    @Test
    internal fun `output number as string`() {
        val fizzBuzzer = FizzBuzzer()

        val result = fizzBuzzer.fizzBuzz(1)

        assertThat(result).isEqualTo("1")
    }
}
