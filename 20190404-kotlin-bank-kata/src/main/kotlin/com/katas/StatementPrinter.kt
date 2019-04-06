package com.katas

import java.time.format.DateTimeFormatter

class StatementPrinter(private val console: Console) {

    private val statementHeader = "DATE | AMOUNT | BALANCE"
    private val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    fun print(transactions: List<Transaction>) {
        printHeader()

        printLines(calculateLines(transactions))
    }

    private fun printHeader() {
        console.printLine(statementHeader)
    }

    private fun calculateLines(transactions: List<Transaction>): List<String> {
        var runningBalance = 0

        return transactions.map { transaction ->
            runningBalance += transaction.amount
            toLine(transaction, runningBalance)
        }.reversed()
    }

    private fun toLine(it: Transaction, runningBalance: Int) =
            "${dateFormatter.format(it.date)} | ${it.amount} | $runningBalance"

    private fun printLines(lines: List<String>) {
        lines.forEach { console.printLine(it) }
    }

}
