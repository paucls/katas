package com.katas

fun isLeapYear(year: Int): Boolean {
    return isDivisibleBy4(year) && !isDivisibleBy100(year)
}

private fun isDivisibleBy100(year: Int) = year % 100 == 0

private fun isDivisibleBy4(year: Int) = year % 4 == 0
