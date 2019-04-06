package com.katas

import com.nhaarman.mockito_kotlin.inOrder
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test
import java.time.LocalDate

class StatementPrinterTest {

    private val console = mock<Console>()
    private val statementPrinter = StatementPrinter(console)

    @Test
    fun `should print only the header when there are no transactions`() {
        val noTransactions = emptyList<Transaction>()

        statementPrinter.print(noTransactions)

        verify(console).printLine("DATE | AMOUNT | BALANCE")
    }

    @Test
    fun `should print a statement with one line when there is one transaction`() {
        val transactions = listOf(
                Transaction(LocalDate.of(2014, 4, 1), 1000)
        )

        statementPrinter.print(transactions)

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

        statementPrinter.print(transactions)

        inOrder(console) {
            verify(console).printLine("DATE | AMOUNT | BALANCE")
            verify(console).printLine("02/04/2014 | -100 | 900")
            verify(console).printLine("01/04/2014 | 1000 | 1000")
        }
    }
}
