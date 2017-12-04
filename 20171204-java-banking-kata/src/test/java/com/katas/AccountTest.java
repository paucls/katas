package com.katas;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AccountTest {

    @Test
    public void printStatement_should_by_empty_when_no_transactions() {
        // Arrange
        Account account = new Account();

        // Act
        String statement = account.printStatement();

        // Assert
        assertThat(statement, is("Date  Amount  Balance"));
    }

}
