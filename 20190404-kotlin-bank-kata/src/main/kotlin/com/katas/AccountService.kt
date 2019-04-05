package com.katas

class AccountService(private val console: Console) {
    fun deposit(amount: Int) {
    }

    fun withdraw(amount: Int) {
    }

    fun printStatement() {
        console.printLine("DATE | AMOUNT | BALANCE")
    }
}
