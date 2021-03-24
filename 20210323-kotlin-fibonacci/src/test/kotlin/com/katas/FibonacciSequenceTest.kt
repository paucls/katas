package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class FibonacciSequenceTest {

    private val fibonacciSequence = FibonacciSequence()

    @Test
    fun `first number in sequence is zero`() {
        assertThat(fibonacciSequence.numberAt(0)).isZero()
    }

    @Test
    fun `second number in sequence is one`() {
        assertThat(fibonacciSequence.numberAt(1)).isOne()
    }

    @ParameterizedTest
    @CsvSource(
        "2, 1",
        "3, 2",
        "5, 5"
    )
    fun `other numbers are the sum of previous two`(position: Int, number: Int) {
        assertThat(fibonacciSequence.numberAt(position)).isEqualTo(number)
    }
}
