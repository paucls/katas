package com.katas

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Account(private val dateProvider: DateProvider,
              private val statementPresenter: StatementPresenter) {

    private var transactions = mutableListOf<Transaction>()

    fun deposit(amount: Int) {
        val newBalance = balance() + amount
        transactions.add(Transaction(dateProvider.currentDate(), amount, newBalance))
    }

    fun withdraw(amount: Int) {
        val newBalance = balance() - amount
        transactions.add(Transaction(dateProvider.currentDate(), -amount, newBalance))
    }

    private fun balance(): Int {
        return if (transactions.isEmpty()) 0
        else transactions.last().balance
    }

    fun printStatement(): String = statementPresenter.print(transactions)
}

data class Transaction(val date: LocalDate, val amount: Int, val balance: Int)

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
        val amount = if (transaction.amount > 0) "+${transaction.amount}" else transaction.amount

        return "\n$date  $amount  ${transaction.balance}"
    }
}

