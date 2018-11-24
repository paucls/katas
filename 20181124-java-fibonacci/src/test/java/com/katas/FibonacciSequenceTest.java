package com.katas;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciSequenceTest {
    @Test
    public void first_number_is_zero() {
        FibonacciSequence fibonacci = new FibonacciSequence();

        assertThat(fibonacci.getNumber(0)).isEqualTo(0);
    }
    @Test
    public void second_number_is_one() {
        FibonacciSequence fibonacci = new FibonacciSequence();

        assertThat(fibonacci.getNumber(1)).isEqualTo(1);
    }
}
