package com.katas;

import java.time.LocalDate;
import java.util.Objects;

class StatementLine {
    private LocalDate date;
    private int amount;
    private int balance;

    StatementLine(LocalDate date, int amount, int balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatementLine that = (StatementLine) o;
        return amount == that.amount &&
                balance == that.balance &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, balance);
    }
}
