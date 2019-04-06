package com.katas

import com.nhaarman.mockito_kotlin.inOrder
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test
import java.time.LocalDate

class StatementPrinterTest {

    private val console = mock<Console>()

    @Test
    fun `should print an empty statement when no transactions`() {
        val transactions = emptyList<Transaction>()

        StatementPrinter(console).print(transactions)

        verify(console).printLine("DATE | AMOUNT | BALANCE")
    }

    @Test
    fun `should print a statement with one transaction`() {
        val transactions = listOf(
                Transaction(LocalDate.of(2014, 4, 1), 1000)
        )

        StatementPrinter(console).print(transactions)

        inOrder(console) {
            verify(console).printLine("DATE | AMOUNT | BALANCE")
            verify(console).printLine("01/04/2014 | 1000 | 1000")
        }
    }
}
