package com.katas;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    private final FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void should_print_100_numbers() {
        assertThat(fizzBuzz.numbers()).hasSize(100);
    }

    @Test
    public void should_print_1_as_first_number() {
        assertThat(fizzBuzz.numbers().get(0)).isEqualTo("1");
    }

    @Test
    public void should_print_2_as_second_number() {
        assertThat(fizzBuzz.numbers().get(1)).isEqualTo("2");
    }

    @Test
    public void should_print_Fizz_for_number_3() {
        assertThat(fizzBuzz.numbers().get(2)).isEqualTo("Fizz");
    }
}
