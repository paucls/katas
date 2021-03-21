package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FibonacciSequenceTest {
    @Test
    internal fun `first number in sequence is zero`() {
        val fibonacciSequence = FibonacciSequence()

        val number = fibonacciSequence.numberAt(0)

        assertThat(number).isZero()
    }
}
