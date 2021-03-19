package com.katas;

import org.junit.Test;

import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {
    @Test
    public void should_print_100_numbers() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String[] numbers = fizzBuzz.print();

        assertThat(numbers).hasSize(100);
    }

    @Test
    public void should_print_1_as_first_number() {
        FizzBuzz fizzbuzz = new FizzBuzz();

        String[] numbers = fizzbuzz.print();

        assertThat(numbers[0]).isEqualTo("1");
    }
}
