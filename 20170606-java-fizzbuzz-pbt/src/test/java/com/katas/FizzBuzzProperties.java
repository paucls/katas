package com.katas;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Assume;
import org.junit.Before;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;

@RunWith(JUnitQuickcheck.class)
public class FizzBuzzProperties {

    private FizzBuzz fizzBuzz;

    @Before
    public void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Property
    public void prints_number_for_numbers_not_divisible_by_three_or_five(int number) {
        Assume.assumeThat(number % 3, not(0));
        Assume.assumeThat(number % 5, not(0));

        String result = fizzBuzz.print(number);

        assertThat(result, equalTo(Integer.toString(number)));
    }

    @Property
    public void prints_Fizz_for_numbers_divisible_by_three(int number) {
        Assume.assumeThat(number % 3, is(0));
        Assume.assumeThat(number % 5, not(0));

        String result = fizzBuzz.print(number);

        assertThat(result, equalTo("Fizz"));
    }

    @Property
    public void prints_Buzz_for_numbers_divisible_by_five(int number) {
        Assume.assumeThat(number % 3, not(0));
        Assume.assumeThat(number % 5, is(0));

        String result = fizzBuzz.print(number);

        assertThat(result, equalTo("Buzz"));
    }

    @Property
    public void prints_FizzBuzz_for_numbers_divisible_by_three_and_five(int number) {
        Assume.assumeThat(number % 3, is(0));
        Assume.assumeThat(number % 5, is(0));

        String result = fizzBuzz.print(number);

        assertThat(result, equalTo("FizzBuzz"));
    }

}
