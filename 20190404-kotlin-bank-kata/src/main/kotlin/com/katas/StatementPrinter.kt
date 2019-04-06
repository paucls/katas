package com.katas

import java.time.format.DateTimeFormatter

class StatementPrinter(private val console: Console) {

    fun print(transactions: List<Transaction>) {
        console.printLine("DATE | AMOUNT | BALANCE")

        if (!transactions.isEmpty()) {
            val transaction = transactions[0]
            val formattedDate = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(transaction.date)
            val line = "$formattedDate | ${transaction.amount} | ${transaction.amount}"
            console.printLine(line)
        }
    }

}
