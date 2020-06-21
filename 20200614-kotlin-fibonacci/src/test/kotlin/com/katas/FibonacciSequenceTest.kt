package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FibonacciSequenceTest {

    private val fibonacciSequence = FibonacciSequence()

    @Test
    internal fun `first number in sequence is 0`() {
        assertThat(fibonacciSequence.numberAt(0)).isZero()
    }

    @Test
    internal fun `second number in sequence is 1`() {
        assertThat(fibonacciSequence.numberAt(1)).isEqualTo(1)
    }

    @Test
    internal fun `third number in sequence is 1`() {
        assertThat(fibonacciSequence.numberAt(2)).isEqualTo(1)
    }

    @Test
    internal fun `fourth number in sequence is 2`() {
        assertThat(fibonacciSequence.numberAt(3)).isEqualTo(2)
    }

    @Test
    internal fun `sixth number in sequence is 5`() {
        assertThat(fibonacciSequence.numberAt(5)).isEqualTo(5)
    }
}