package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LeapYearTest {
    @Test
    internal fun `should be leap year if divisible by 4`() {
        assertThat(isLeapYear(1996)).isTrue()
    }

    @Test
    internal fun `should be common year if not divisible by 4`() {
        assertThat(isLeapYear(2001)).isFalse()
    }

    @Test
    internal fun `should be atypical common year if divisible by 4 and 100`() {
        assertThat(isLeapYear(1900)).isFalse()
    }
}
