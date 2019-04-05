package com.katas

import java.time.LocalDate

class AccountService(
        private val console: Console,
        private val transactionsRepository: TransactionRepository
) {
    fun deposit(amount: Int) {
        val date = LocalDate.now()
        val transaction = Transaction(date, amount)
        transactionsRepository.save(transaction)
    }

    fun withdraw(amount: Int) {
        val date = LocalDate.now()
        val transaction = Transaction(date, -amount)
        transactionsRepository.save(transaction)
    }

    fun printStatement() {
        console.printLine("DATE | AMOUNT | BALANCE")
    }
}
