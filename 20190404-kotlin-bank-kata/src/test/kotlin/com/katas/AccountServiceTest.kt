package com.katas

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

class AccountServiceTest {
    @Test
    fun `should print an empty statement when there are no transactions`() {
        val console: Console = mock()
        val accountService = AccountService(console)

        accountService.printStatement()

        verify(console).printLine("DATE | AMOUNT | BALANCE")
    }
}
