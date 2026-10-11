package com.airtribe.learntrack.util;

public class InputValidator {

    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        return isNotEmpty(email)
                && email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");
    }

    public static boolean isPositive(int number) {
        return number > 0;
    }
}