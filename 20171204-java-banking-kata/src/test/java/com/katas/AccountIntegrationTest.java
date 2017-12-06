package com.katas;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AccountIntegrationTest {

    private Account account;
    private LocalDate testDate;

    @Before
    public void setUp() {
        DateProvider dateProvider = new DateProvider();
        account = new Account(dateProvider, new TextStatementPresenter());
        testDate = dateProvider.currentDate();
    }

    @Test
    public void printStatement_when_no_transactions_prints_only_the_header() {
        // Act
        String statement = account.printStatement();

        // Assert
        assertThat(statement).isEqualTo("Date  Amount  Balance");
    }

    @Test
    public void printStatement_when_one_deposit_prints_a_statement_line() {
        // Arrange
        account.deposit(500);

        // Act
        String statement = account.printStatement();

        // Assert
        assertThat(statement).isEqualTo("Date  Amount  Balance" +
                "\n" + testDate + "  +500  500");
    }

    @Test
    public void printStatement_when_multiple_deposits_prints_multiple_statement_lines() {
        // Arrange
        account.deposit(500);
        account.deposit(400);

        // Act
        String statement = account.printStatement();

        // Assert
        assertThat(statement).isEqualTo("Date  Amount  Balance" +
                "\n" + testDate + "  +500  500" +
                "\n" + testDate + "  +400  900");
    }

}
