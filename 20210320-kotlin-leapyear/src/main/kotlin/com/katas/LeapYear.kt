package com.katas

fun isLeapYear(year: Int): Boolean {
    return isDivisibleBy4(year) &&
            !isDivisibleBy100(year) || isDivisibleBy400(year)
}

private fun isDivisibleBy400(year: Int) = year % 400 == 0

private fun isDivisibleBy100(year: Int) = year % 100 == 0

private fun isDivisibleBy4(year: Int) = year % 4 == 0
