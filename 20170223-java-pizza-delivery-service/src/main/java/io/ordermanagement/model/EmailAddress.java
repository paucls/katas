package io.ordermanagement.model;

import javax.persistence.Embeddable;

/**
 * Address Value Object
 */
@Embeddable
public class EmailAddress implements ValueObject {

    private String email;

    public EmailAddress(String email) {
        this.setEmail(email);
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid e-mail address.");
        }

        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmailAddress that = (EmailAddress) o;

        return email != null ? email.equals(that.email) : that.email == null;
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "EmailAddress{" +
                "email='" + email + '\'' +
                '}';
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.matches("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{3}");
    }
}

