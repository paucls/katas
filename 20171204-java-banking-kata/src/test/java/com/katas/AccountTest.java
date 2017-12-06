package com.katas;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AccountTest {

    private DateProvider dateProviderMock;
    private StatementPresenter statementPresenterMock;
    private Account account;

    @Before
    public void setUp() {
        dateProviderMock = mock(DateProvider.class);
        statementPresenterMock = mock(StatementPresenter.class);
        account = new Account(dateProviderMock, statementPresenterMock);
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

    @Test
    public void calculates_balance_for_multiple_deposits() {
        // Given
        LocalDate date = LocalDate.of(2017, 10, 25);
        when(dateProviderMock.currentDate()).thenReturn(date);
        account.deposit(500);
        account.deposit(400);

        // When
        account.printStatement();

        // Then
        List<StatementLine> statementLines = Arrays.asList(
                new StatementLine(date, 500, 500),
                new StatementLine(date, 400, 900)
        );
        verify(statementPresenterMock).printStatement(statementLines);
    }

}
