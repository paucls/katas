package com.katas

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

class StatementPrinterTest {

    private val console = mock<Console>()

    @Test
    fun `should print an empty statement when no transactions`() {
        val transactions = emptyList<Transaction>()

        StatementPrinter(console).print(transactions)

        verify(console).printLine("DATE | AMOUNT | BALANCE")
    }
}
