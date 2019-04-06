package com.katas

import java.time.format.DateTimeFormatter

class StatementPrinter(private val console: Console) {

    private val statementHeader = "DATE | AMOUNT | BALANCE"
    private val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    fun print(transactions: List<Transaction>) {
        printHeader()

        val lines = calculateLines(transactions)
        printLines(lines)
    }

    private fun printHeader() {
        console.printLine(statementHeader)
    }

    private fun calculateLines(transactions: List<Transaction>): MutableList<String> {
        val lines = mutableListOf<String>()
        var runningBalance = 0

        transactions.forEach {
            runningBalance += it.amount

            lines += toLine(it, runningBalance)
        }

        lines.reverse()
        return lines
    }

    private fun toLine(it: Transaction, runningBalance: Int) =
            "${dateFormatter.format(it.date)} | ${it.amount} | $runningBalance"

    private fun printLines(lines: MutableList<String>) {
        lines.forEach { console.printLine(it) }
    }

}
