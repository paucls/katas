package com.katas;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzerTest {
    private FizzBuzzer fizzBuzzer;

    @Before
    public void setUp() {
        fizzBuzzer = new FizzBuzzer();
    }

    @Test
    public void should_return_a_string_representing_1() {
        String result = fizzBuzzer.fizzBuzz(1);

        assertThat(result).isEqualTo("1");
    }

    @Test
    public void should_return_a_string_representing_2() {
        String result = fizzBuzzer.fizzBuzz(2);

        assertThat(result).isEqualTo("2");
    }

    @Test
    public void should_return_a_string_representing_4() {
        String result = fizzBuzzer.fizzBuzz(4);

        assertThat(result).isEqualTo("4");
    }

    @Test
    public void should_return_fizz_for_number_3() {
        String result = fizzBuzzer.fizzBuzz(3);

        assertThat(result).isEqualTo("Fizz");
    }
}
