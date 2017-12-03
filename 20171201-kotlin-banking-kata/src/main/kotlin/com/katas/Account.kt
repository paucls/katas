package com.katas

import com.katas.Transaction.Deposit
import com.katas.Transaction.Withdraw

class Account(private val dateProvider: DateProvider,
              private val statementPresenter: StatementPresenter) {

    private var transactions = mutableListOf<Transaction>()

    fun deposit(amount: Int) {
        val newBalance = balance() + amount
        transactions.add(Deposit(dateProvider.currentDate(), amount, newBalance))
    }

    fun withdraw(amount: Int) {
        val newBalance = balance() - amount
        transactions.add(Withdraw(dateProvider.currentDate(), amount, newBalance))
    }

    private fun balance(): Int {
        return if (transactions.isEmpty()) 0
        else transactions.last().balance
    }

    fun printStatement(): String = statementPresenter.print(transactions)
}
