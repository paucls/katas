package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringCalculatorTest {

    private val calculator = Calculator()

    @Test
    internal fun `should return 0 when empty string is passed`() {
        assertThat(calculator.add("")).isEqualTo(0)
    }
}
