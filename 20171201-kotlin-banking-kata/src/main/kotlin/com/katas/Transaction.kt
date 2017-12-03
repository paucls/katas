package com.katas

import java.time.LocalDate

sealed class Transaction(val date: LocalDate, val amount: Int, val balance: Int) {
    class Deposit(date: LocalDate, amount: Int, balance: Int) : Transaction(date, amount, balance)
    class Withdraw(date: LocalDate, amount: Int, balance: Int) : Transaction(date, amount, balance)
}