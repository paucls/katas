package com.katas;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {
    @Test
    public void should_print_100_numbers() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String[] numbers = fizzBuzz.print();

        assertThat(numbers).hasSize(100);
    }
}
