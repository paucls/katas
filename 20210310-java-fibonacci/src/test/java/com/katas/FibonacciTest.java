package com.katas;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FibonacciTest {

    private final Fibonacci fibonacci = new Fibonacci();

    @Test
    public void first_number_in_sequence_is_zero() {
        Integer number = fibonacci.getNumberAt(0);

        assertThat(number).isZero();
    }

    @Test
    public void second_number_in_sequence_is_one() {
        Integer number = fibonacci.getNumberAt(1);

        assertThat(number).isOne();
    }
}
