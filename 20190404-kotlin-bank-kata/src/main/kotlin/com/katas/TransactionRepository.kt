package com.katas

class TransactionRepository {
    private val transactions: MutableList<Transaction> = mutableListOf()

    fun save(transaction: Transaction) {
        transactions.add(transaction)
    }

    fun getAccountTransactions(): List<Transaction> {
        return transactions.toList()
    }
}
