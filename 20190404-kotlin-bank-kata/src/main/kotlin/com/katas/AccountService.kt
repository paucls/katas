package com.katas

class AccountService(
        private val transactionsRepository: TransactionRepository,
        private val statementPrinter: StatementPrinter,
        private val clock: Clock
) {

    fun deposit(amount: Int) {
        transactionsRepository.save(depositTransaction(amount))
    }

    fun withdraw(amount: Int) {
        transactionsRepository.save(withdrawalTransaction(amount))
    }

    fun printStatement() {
        statementPrinter.print(transactionsRepository.getAccountTransactions())
    }

    private fun depositTransaction(amount: Int): Transaction {
        return Transaction(clock.today(), amount)
    }

    private fun withdrawalTransaction(amount: Int): Transaction {
        return Transaction(clock.today(), -amount)
    }
}
