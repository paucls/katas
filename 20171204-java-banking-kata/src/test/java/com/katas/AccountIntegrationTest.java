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
    public void printStatement_when_multiple_deposits_prints_multiple_statement_lines() {
        // Given
        account.deposit(500);
        account.deposit(400);

        // When
        String statement = account.printStatement();

        // Then
        assertThat(statement).isEqualTo("Date  Amount  Balance" +
                "\n" + testDate + "  +500  500" +
                "\n" + testDate + "  +400  900");
    }

}
