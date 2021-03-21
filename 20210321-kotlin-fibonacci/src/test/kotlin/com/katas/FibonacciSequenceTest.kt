package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FibonacciSequenceTest {
    private val fibonacciSequence = FibonacciSequence()

    @Test
    internal fun `first number in sequence is zero`() {
        assertThat(fibonacciSequence.numberAt(0)).isZero()
    }

    @Test
    internal fun `second number in sequence is one`() {
        assertThat(fibonacciSequence.numberAt(1)).isOne()
    }

    @Test
    internal fun `third number in sequence is one`() {
        assertThat(fibonacciSequence.numberAt(2)).isOne()
    }

    @Test
    internal fun `fourth number in sequence is two`() {
        assertThat(fibonacciSequence.numberAt(3)).isEqualTo(2)
    }

    @Test
    internal fun `sixth number in sequence is five`() {
        assertThat(fibonacciSequence.numberAt(5)).isEqualTo(5)
    }
}
