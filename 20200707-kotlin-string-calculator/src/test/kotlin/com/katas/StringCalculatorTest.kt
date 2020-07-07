package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringCalculatorTest {
    @Test
    internal fun `should return 0 when empty string is passed`() {
        val calculator = Calculator()
        val result = calculator.add("")
        assertThat(result).isEqualTo(0)
    }
}
