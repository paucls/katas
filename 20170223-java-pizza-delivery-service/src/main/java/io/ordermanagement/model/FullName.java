package io.ordermanagement.model;

import javax.persistence.Embeddable;

/**
 * FullName Value Object
 */
@Embeddable
public class FullName implements ValueObject {

    private String firstName;
    private String lastName;

    private FullName() {
    }

    public FullName(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("First and last name are required.");
        }

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }
}
