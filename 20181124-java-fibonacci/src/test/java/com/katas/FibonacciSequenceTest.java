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
    public void first_number_is_zero() {
        assertThat(fibonacci.getNumber(0)).isEqualTo(0);
    }

    @Test
    public void second_number_is_one() {
        assertThat(fibonacci.getNumber(1)).isEqualTo(1);
    }

    @Test
    public void third_number_is_one() {
        assertThat(fibonacci.getNumber(2)).isEqualTo(1);
    }

    @Test
    public void fourth_number_is_two() {
        assertThat(fibonacci.getNumber(3)).isEqualTo(2);
    }
}
