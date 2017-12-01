package com.katas

class Account {

    private val header = "Date  Amount  Balance"
    private var transactions = mutableListOf<Transaction>()

    fun printStatement(): String {
        val rows = transactions.map {
            "\n24/12/2015  +${it.amount}  ${it.amount}"
        }.joinToString()

        return header + rows
    }

    fun deposit(amount: Int) {
        transactions.add(Transaction(amount))
    }

}

data class Transaction(val amount: Int)


