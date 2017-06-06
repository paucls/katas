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
    public void prints_number_for_numbers_not_multiple_of_three(int number) {
        Assume.assumeThat(number % 3, not(0));

        String result = fizzBuzz.print(number);

        assertThat(result, equalTo(Integer.toString(number)));
    }

    @Property
    public void prints_fizz_for_numbers_multiple_of_three(int number) {
        Assume.assumeThat(number % 3, is(0));

        String result = fizzBuzz.print(number);

        assertThat(result, equalTo("Fizz"));
    }

}
