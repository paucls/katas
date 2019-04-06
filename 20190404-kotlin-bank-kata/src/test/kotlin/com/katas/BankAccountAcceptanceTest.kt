package com.katas

import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test
import java.time.LocalDate

class BankAccountAcceptanceTest {

    private val transactionsRepository = TransactionRepository()
    private val console: Console = mock()
    private val statementPrinter = StatementPrinter(console)
    private val clock: Clock = mock()
    private val account = AccountService(transactionsRepository, statementPrinter, clock)

    @Test
    fun `should print statement containing all transactions`() {
        given(clock.today())
                .willReturn(LocalDate.of(2014, 4, 1))
                .willReturn(LocalDate.of(2014, 4, 2))
                .willReturn(LocalDate.of(2014, 4, 10))

        account.deposit(1000)
        account.withdraw(100)
        account.deposit(500)

        account.printStatement()

        verify(console).printLine("DATE | AMOUNT | BALANCE")
        verify(console).printLine("10/04/2014 | 500 | 1400")
        verify(console).printLine("02/04/2014 | -100 | 900")
        verify(console).printLine("01/04/2014 | 1000 | 1000")
    }
}
