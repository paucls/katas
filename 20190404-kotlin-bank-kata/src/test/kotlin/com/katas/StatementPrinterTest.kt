package com.katas

import com.nhaarman.mockito_kotlin.inOrder
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test
import java.time.LocalDate

class StatementPrinterTest {

    private val console = mock<Console>()

    @Test
    fun `should just print the header when no transactions`() {
        val transactions = emptyList<Transaction>()

        StatementPrinter(console).print(transactions)

        verify(console).printLine("DATE | AMOUNT | BALANCE")
    }

    @Test
    fun `should print a statement with one line when there is one transaction`() {
        val transactions = listOf(
                Transaction(LocalDate.of(2014, 4, 1), 1000)
        )

        StatementPrinter(console).print(transactions)

        inOrder(console) {
            verify(console).printLine("DATE | AMOUNT | BALANCE")
            verify(console).printLine("01/04/2014 | 1000 | 1000")
        }
    }

    @Test
    fun `should print statement with multiple lines calculating running balance`() {
        val transactions = listOf(
                Transaction(LocalDate.of(2014, 4, 1), 1000),
                Transaction(LocalDate.of(2014, 4, 2), -100)
        )

        StatementPrinter(console).print(transactions)

        inOrder(console) {
            verify(console).printLine("DATE | AMOUNT | BALANCE")
            verify(console).printLine("02/04/2014 | -100 | 900")
            verify(console).printLine("01/04/2014 | 1000 | 1000")
        }
    }
}
