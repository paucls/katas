package com.katas;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static final int NUMBERS_TO_PRINT = 100;

    public List<String> numbers() {
        List<String> fizzBuzzedNumbers = new ArrayList<>();

        for (int number = 1; number <= NUMBERS_TO_PRINT; number++) {

            if (number == 3) {
                fizzBuzzedNumbers.add("Fizz");
            } else {
                fizzBuzzedNumbers.add(Integer.toString(number));
            }
        }

        return fizzBuzzedNumbers;
    }
}
