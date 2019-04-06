package com.katas

class StatementPrinter(private val console: Console) {

    fun print(transactions: List<Transaction>) {
        console.printLine("DATE | AMOUNT | BALANCE")
    }

}
