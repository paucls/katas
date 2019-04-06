package com.katas

import java.time.format.DateTimeFormatter

class StatementPrinter(private val console: Console) {

    private val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    fun print(transactions: List<Transaction>) {
        console.printLine("DATE | AMOUNT | BALANCE")

        val lines = calculateLines(transactions)
        lines.forEach { console.printLine(it) }
    }

    private fun calculateLines(transactions: List<Transaction>): MutableList<String> {
        val lines = mutableListOf<String>()
        var runningBalance = 0

        transactions.forEach {
            runningBalance += it.amount

            lines += "${dateFormatter.format(it.date)} | ${it.amount} | $runningBalance"
        }

        lines.reverse()
        return lines
    }

}
