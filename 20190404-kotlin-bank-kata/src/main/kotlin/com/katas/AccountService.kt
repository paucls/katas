package com.katas

import java.time.LocalDate

class AccountService(
        private val transactionsRepository: TransactionRepository,
        private val statementPrinter: StatementPrinter
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
        statementPrinter.print(transactionsRepository.getAccountTransactions())
    }
}
