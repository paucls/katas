package com.katas;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class AccountTest {

    private Account account;

    @Before
    public void setUp() {
        account = new Account();
    }

    @Test
    public void printStatement_when_no_transactions_prints_only_the_header() {
        // Act
        String statement = account.printStatement();

        // Assert
        assertThat(statement).isEqualTo("Date  Amount  Balance");
    }

    @Test
    public void printStatement_when_one_deposit_prints_it() {
        // Arrange
        account.deposit(500);

        // Act
        String statement = account.printStatement();

        // Assert
        assertThat(statement).isEqualTo("Date  Amount  Balance" +
                "\n2017-12-04  +500  500");
    }

}
