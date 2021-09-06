package com.katas;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    private final FizzBuzz fizzBuzzer = new FizzBuzz();

    @Test
    public void should_output_string_1_for_number_1() {
        assertThat(fizzBuzzer.fizzBuzz(1)).isEqualTo("1");
    }

    @Test
    public void should_output_string_2_for_number_2() {
        assertThat(fizzBuzzer.fizzBuzz(2)).isEqualTo("2");
    }

    @Test
    public void should_output_Fizz_for_number_multiple_of_3() {
        assertThat(fizzBuzzer.fizzBuzz(3)).isEqualTo("Fizz");
        assertThat(fizzBuzzer.fizzBuzz(6)).isEqualTo("Fizz");
    }

    @Test
    public void should_output_Buzz_for_number_multiple_of_5() {
        assertThat(fizzBuzzer.fizzBuzz(5)).isEqualTo("Buzz");
        assertThat(fizzBuzzer.fizzBuzz(10)).isEqualTo("Buzz");
    }

    @Test
    public void should_output_FizzBuzz_for_number_multiple_of_3_and_5() {
        assertThat(fizzBuzzer.fizzBuzz(15)).isEqualTo("FizzBuzz");
        assertThat(fizzBuzzer.fizzBuzz(30)).isEqualTo("FizzBuzz");
    }
}
