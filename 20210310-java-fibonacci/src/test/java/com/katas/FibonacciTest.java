package com.katas;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FibonacciTest {
    @Test
    public void first_number_in_sequence_is_zero() {
        Fibonacci fibonacci = new Fibonacci();
        Integer number = fibonacci.getNumberAt(0);
        assertThat(number).isZero();
    }
}
