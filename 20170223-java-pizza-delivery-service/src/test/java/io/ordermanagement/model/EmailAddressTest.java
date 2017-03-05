package io.ordermanagement.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class EmailAddressTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void constructor_when_validEmail_initializesValue() {
        EmailAddress emailAddress = new EmailAddress("email@server.com");

        assertThat(emailAddress, notNullValue());
    }

    @Test
    public void constructor_when_invalidEmail_throws_exception() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid e-mail address.");

        new EmailAddress("email.com");
    }

}