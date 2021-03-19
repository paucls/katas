package com.katas;

public class FizzBuzz {

    public static final int NUMBERS_TO_PRINT = 100;

    public String[] numbers() {
        String[] fizzBuzzedNumbers = new String[NUMBERS_TO_PRINT];

        for (int number = 1; number <= NUMBERS_TO_PRINT; number++) {

            if (number == 3) {
                fizzBuzzedNumbers[number - 1] = "Fizz";
            } else {
                fizzBuzzedNumbers[number - 1] = Integer.toString(number);
            }
        }

        return fizzBuzzedNumbers;
    }
}
