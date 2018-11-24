package com.katas;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciSequenceTest {
    private FibonacciSequence fibonacci;

    @Before
    public void setUp() {
        fibonacci = new FibonacciSequence();
    }

    @Test
    public void first_two_numbers_are_the_same_than_index() {
        assertThat(fibonacci.getNumber(0)).isEqualTo(0);
        assertThat(fibonacci.getNumber(1)).isEqualTo(1);
    }

    @Test
    public void other_numbers_are_the_sum_of_the_two_preceding_ones() {
        assertThat(fibonacci.getNumber(2)).isEqualTo(1);
        assertThat(fibonacci.getNumber(3)).isEqualTo(2);
        assertThat(fibonacci.getNumber(5)).isEqualTo(5);
    }
}
