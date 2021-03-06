package com.katas;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FibonacciTest {

    private final Fibonacci fibonacci = new Fibonacci();

    @Test
    public void first_number_in_sequence_is_zero() {
        assertThat(fibonacci.numberAt(0)).isZero();
    }

    @Test
    public void second_number_in_sequence_is_one() {
        assertThat(fibonacci.numberAt(1)).isOne();
    }

    @Test
    public void third_number_in_sequence_is_one() {
        assertThat(fibonacci.numberAt(2)).isOne();
    }

    @Test
    public void fourth_number_in_sequence_is_two() {
        assertThat(fibonacci.numberAt(3)).isEqualTo(2);
    }

    @Test
    public void sixth_number_in_sequence_is_five() {
        assertThat(fibonacci.numberAt(5)).isEqualTo(5);
    }
}
