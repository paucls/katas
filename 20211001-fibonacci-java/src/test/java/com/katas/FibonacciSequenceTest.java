package com.katas;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FibonacciSequenceTest {

    private final FibonacciSequence fibonacciSequence = new FibonacciSequence();

    @Test
    public void first_number_in_sequence_is_zero() {
        assertThat(fibonacciSequence.numberAt(1)).isZero();
    }

    @Test
    public void second_number_in_sequence_is_one() {
        assertThat(fibonacciSequence.numberAt(2)).isOne();
    }

    @Test
    public void third_number_in_sequence_is_one() {
        assertThat(fibonacciSequence.numberAt(3)).isOne();
    }

    @Test
    public void fourth_number_in_sequence_is_two() {
        assertThat(fibonacciSequence.numberAt(4)).isEqualTo(2);
    }

    @Test
    public void sixth_number_in_sequence_is_five() {
        assertThat(fibonacciSequence.numberAt(6)).isEqualTo(5);
    }
}
