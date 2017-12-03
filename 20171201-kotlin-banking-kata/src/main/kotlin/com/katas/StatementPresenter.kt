package com.katas

import java.time.format.DateTimeFormatter

interface StatementPresenter {
    fun print(transactions: List<Transaction>): String
}

class PrintStatementPresenter : StatementPresenter {
    private val header = "Date  Amount  Balance"
    private val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    override fun print(transactions: List<Transaction>): String {
        val rows = transactions.joinToString("", transform = this::printTransaction)

        return header + rows
    }

    private fun printTransaction(transaction: Transaction): String {
        val date = transaction.date.format(formatter)
        val amount = formatAmount(transaction)

        return "\n$date  $amount  ${transaction.balance}"
    }

    private fun formatAmount(transaction: Transaction): String {
        return when (transaction) {
            is Transaction.Deposit -> "+${transaction.amount}"
            is Transaction.Withdraw -> "-${transaction.amount}"
        }
    }

}