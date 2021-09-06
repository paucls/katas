package com.katas;

public class FizzBuzz {
    public String fizzBuzz(Integer number) {
        if (isMultipleOf3(number) && isMultipleOf5(number))
            return "FizzBuzz";
        if (isMultipleOf3(number))
            return "Fizz";
        if (isMultipleOf5(number))
            return "Buzz";
        return number.toString();
    }

    private boolean isMultipleOf5(int number) {
        return number % 5 == 0;
    }

    private boolean isMultipleOf3(int number) {
        return number % 3 == 0;
    }
}
