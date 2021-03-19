package com.katas;

public class FizzBuzz {

    public static final int NUMBERS_LENGTH = 100;

    public String[] numbers() {
        String[] numbers = new String[NUMBERS_LENGTH];

        for (int i = 0; i < NUMBERS_LENGTH; i++) {
            numbers[i] = Integer.toString(i + 1);
        }

        return numbers;
    }
}
