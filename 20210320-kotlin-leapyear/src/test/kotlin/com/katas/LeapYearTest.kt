package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LeapYearTest {
    @Test
    internal fun `should be leap year if divisible by 4`() {
        assertThat(isLeapYear(1996)).isTrue()
    }
}
