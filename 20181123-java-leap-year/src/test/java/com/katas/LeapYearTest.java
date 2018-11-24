package com.katas;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LeapYearTest {
    @Test
    public void should_be_leap_year_when_divisible_by_4() {
        boolean result = isLeapYear(1996);

        assertThat(result).isTrue();
    }

    @Test
    public void should_not_be_leap_year_when_non_divisible_by_4() {
        boolean result = isLeapYear(1997);

        assertThat(result).isFalse();
    }

    @Test
    public void should_not_be_leap_year_when_divisible_by_4_and_also_100() {
        boolean result = isLeapYear(1900);

        assertThat(result).isFalse();
    }

    @Test
    public void should_be_leap_year_when_divisible_by_4_and_also_400() {
        boolean result = isLeapYear(2000);

        assertThat(result).isTrue();
    }

    private boolean isLeapYear(int year) {
        return year % 4 == 0
                && year % 100 != 0
                || year % 400 == 0;
    }
}
