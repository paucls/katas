package com.katas

import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import java.time.LocalDate

class AccountServiceTest {

    private val today = LocalDate.of(2019, 1, 20)

    private val transactionsRepository: TransactionRepository = mock()
    private val statementPrinter: StatementPrinter = mock()
    private val clock: Clock = mock()
    private val accountService = AccountService(transactionsRepository, statementPrinter, clock)

    @Before
    fun setUp() {
        given(clock.today()).willReturn(today)
    }

    @Test
    fun `should store a deposit transaction`() {
        val amount = 1000

        accountService.deposit(amount)

        verify(transactionsRepository).save(Transaction(
                date = today,
                amount = amount))
    }

    @Test
    fun `should store a withdrawal transaction`() {
        val amount = 500

        accountService.withdraw(amount)

        verify(transactionsRepository).save(Transaction(
                date = today,
                amount = -amount))
    }

    @Test
    fun `should print a statement for transactions`() {
        val transactions = listOf(Transaction(
                date = today,
                amount = 500))
        given(transactionsRepository.getAccountTransactions()).willReturn(transactions)

        accountService.printStatement()

        verify(statementPrinter).print(transactions)
    }
}
