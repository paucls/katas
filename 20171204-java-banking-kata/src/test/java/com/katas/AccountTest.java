package com.katas;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountTest {

    private DateProvider dateProviderMock;
    private Account account;

    @Before
    public void setUp() {
        dateProviderMock = mock(DateProvider.class);
        account = new Account(dateProviderMock);
    }

    @Test
    public void printStatement_when_no_transactions_prints_only_the_header() {
        // When
        String statement = account.printStatement();

        // Then
        assertThat(statement).isEqualTo("Date  Amount  Balance");
    }

    @Test
    public void printStatement_when_one_deposit_prints_a_statement_line() {
        // Given
        when(dateProviderMock.currentDate()).thenReturn(LocalDate.of(2017, 12, 06));
        account.deposit(500);

        // When
        String statement = account.printStatement();

        // Then
        assertThat(statement).isEqualTo("Date  Amount  Balance" +
                "\n2017-12-06  +500  500");
    }

    @Test
    public void printStatement_when_multiple_deposits_prints_multiple_statement_lines() {
        // Given
        when(dateProviderMock.currentDate()).thenReturn(LocalDate.of(2017, 10, 25));
        account.deposit(500);
        account.deposit(400);

        // When
        String statement = account.printStatement();

        // Then
        assertThat(statement).isEqualTo("Date  Amount  Balance" +
                "\n2017-10-25  +500  500" +
                "\n2017-10-25  +400  900");
    }

}
