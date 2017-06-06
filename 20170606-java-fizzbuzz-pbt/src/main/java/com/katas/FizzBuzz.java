package com.katas;

class FizzBuzz {

    String print(int number) {
        if (isMultiple3(number) && isMultiple5(number)) {
            return "FizzBuzz";
        }
        if (isMultiple3(number)) {
            return "Fizz";
        }
        if (isMultiple5(number)) {
            return "Buzz";
        }

        return Integer.toString(number);
    }

    private boolean isMultiple5(int number) {
        return number % 5 == 0;
    }

    private boolean isMultiple3(int number) {
        return number % 3 == 0;
    }

}
