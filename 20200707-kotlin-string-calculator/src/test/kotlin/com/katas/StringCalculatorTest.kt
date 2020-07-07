package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringCalculatorTest {

    private val calculator = Calculator()

    @Test
    internal fun `should return 0 when empty string is passed`() {
        assertThat(calculator.add("")).isEqualTo(0)
    }

    @Test
    internal fun `should return number when string has a single number`() {
        assertThat(calculator.add("1")).isEqualTo(1)
    }

    @Test
    internal fun `should return sum of the number when string has a two numbers`() {
        assertThat(calculator.add("1,2")).isEqualTo(3)
    }
}
