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
        var balance = 0
        var rows = ""

        transactions.forEach {
            balance += it.amount
            rows += printTransaction(it, balance)
        }

        return header + rows
    }

    private fun printTransaction(transaction: Transaction, balance: Int): String {
        val date = transaction.date.format(formatter)

        return "\n${date}  +${transaction.amount}  ${balance}"
    }

}

class DateProvider {
    fun currentDate(): LocalDate {
        return LocalDate.now()
    }
}

data class Transaction(val date: LocalDate, val amount: Int)
