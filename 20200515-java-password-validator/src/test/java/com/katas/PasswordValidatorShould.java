package com.katas;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordValidatorShould {

    private final PasswordValidator passwordValidator = new PasswordValidator();

    @Test
    public void indicate_when_a_password_is_valid() {
        assertThat(passwordValidator.isValid("Ab_12345")).isTrue();
    }

    @Test
    public void ensure_password_is_at_least_8_characters_long() {
        assertThat(passwordValidator.isValid("Ab_1234")).isFalse();
    }

    @Test
    public void ensure_password_has_a_capital_letter() {
        assertThat(passwordValidator.isValid("ab_12345")).isFalse();
    }

    @Test
    public void ensure_password_has_a_lowercase() {
        assertThat(passwordValidator.isValid("AB_12345")).isFalse();
    }

    @Test
    public void ensure_password_has_a_number() {
        assertThat(passwordValidator.isValid("ABabcde_")).isFalse();
    }

    @Test
    public void ensure_password_has_an_underscore() {
        assertThat(passwordValidator.isValid("AB123abc")).isFalse();
    }
}
