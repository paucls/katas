package com.katas;

class FizzBuzz {

    String print(int number) {
        if (isMultiple3(number)) {
            return "Fizz";
        }
        return Integer.toString(number);
    }

    private boolean isMultiple3(int number) {
        return number % 3 == 0;
    }

}
