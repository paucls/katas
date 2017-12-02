package com.katas

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Account(val dateProvider: DateProvider) {

    private val header = "Date  Amount  Balance"
    private val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    private var transactions = mutableListOf<Transaction>()

    fun deposit(amount: Int) {
        transactions.add(Transaction(dateProvider.currentDate(), amount))
    }

    fun printStatement(): String {
        val rows = transactions.map(this::printTransaction).joinToString()

        return header + rows
    }

    private fun printTransaction(transaction: Transaction): String {
        val date = transaction.date.format(formatter)

        return "\n${date}  +${transaction.amount}  ${transaction.amount}"
    }

}

class DateProvider {
    fun currentDate(): LocalDate {
        return LocalDate.now()
    }
}

data class Transaction(val date: LocalDate, val amount: Int)
