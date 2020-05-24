package com.katas;

public class PasswordValidator {
    public boolean isValid(String password) {
        return password.matches(".*[A-Z].*") &&
                password.matches(".*[a-z].*") &&
                password.matches(".*[\\d].*") &&
                password.contains("_") &&
                password.length() >= 8;
    }
}
