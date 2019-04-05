package com.katas

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test
import java.time.LocalDate

class AccountServiceTest {

    private val console: Console = mock()
    private val transactionsRepository: TransactionRepository = mock()
    private val accountService = AccountService(console, transactionsRepository)

    @Test
    fun `should store a deposit transaction`() {
        val amount = 1000

        accountService.deposit(amount)

        verify(transactionsRepository).save(Transaction(
                date = LocalDate.now(),
                amount = amount
        ))
    }

    @Test
    fun `should print an empty statement when there are no transactions`() {
        accountService.printStatement()

        verify(console).printLine("DATE | AMOUNT | BALANCE")
    }
}
