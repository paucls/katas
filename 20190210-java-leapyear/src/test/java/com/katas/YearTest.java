package com.katas;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class YearTest {
    @Test
    public void should_be_leap_year_when_divisible_by_4() {
        final Year year = new Year(1996);

        boolean isLeapYear = year.isLeapYear();

        assertThat(isLeapYear).isTrue();
    }

    @Test
    public void should_be_common_year_when_not_divisible_by_4() {
        final Year year = new Year(2001);

        boolean isLeapYear = year.isLeapYear();

        assertThat(isLeapYear).isFalse();
    }

    @Test
    public void should_be_common_year_when_divisible_by_4_and_100() {
        final Year year = new Year(1900);

        boolean isLeapYear = year.isLeapYear();

        assertThat(isLeapYear).isFalse();
    }

    @Test
    public void should_be_leap_year_when_divisible_by_4_and_400() {
        final Year year = new Year(2000);

        boolean isLeapYear = year.isLeapYear();

        assertThat(isLeapYear).isTrue();
    }
}
