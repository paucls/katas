package com.katas;

class Year {
    private final int year;

    Year(int year) {
        this.year = year;
    }

    boolean isLeapYear() {
        return isDivisibleBy(4)
                && !(isDivisibleBy(100))
                || isDivisibleBy(400);
    }

    private boolean isDivisibleBy(int number) {
        return year % number == 0;
    }
}
