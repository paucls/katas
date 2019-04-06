package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.time.LocalDate

class ClockTest {
    @Test
    fun `should return a new date`() {
        val clock = Clock()
        val today = LocalDate.now()

        assertThat(clock.today()).isEqualTo(today)
    }
}
