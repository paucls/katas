package com.katas;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Matchers.any;
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
    public void calculates_balance_for_multiple_deposits() {
        // Given
        LocalDate date = LocalDate.of(2017, 10, 25);
        when(dateProviderMock.currentDate()).thenReturn(date);
        account.deposit(500);
        account.deposit(400);

        // When
        account.printStatement();

        // Then
        verify(statementPresenterMock).printStatement(Arrays.asList(
                new StatementLine(date, 500, 500),
                new StatementLine(date, 400, 900)
        ));
    }

    @Test
    public void calculates_balance_for_deposits_and_withdrawals() {
        // Given
        LocalDate date = LocalDate.of(2016, 1, 25);
        when(dateProviderMock.currentDate()).thenReturn(date);
        account.deposit(500);
        account.withdraw(300);

        // When
        account.printStatement();

        // Then
        verify(statementPresenterMock).printStatement(Arrays.asList(
                new StatementLine(date, 500, 500),
                new StatementLine(date, -300, 200)
        ));
    }

    @Test
    public void prints_the_response_from_presenter() {
        // Given
        when(statementPresenterMock.printStatement(any())).thenReturn("an account statement!");

        // When
        String statement = account.printStatement();

        // Then
        assertThat(statement).isEqualTo("an account statement!");
    }

}
