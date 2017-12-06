package com.katas;

import java.time.LocalDate;

public class Transaction {

    private LocalDate date;
    private Integer amount;

    Transaction(LocalDate date, Integer amount) {
        this.date = date;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getAmount() {
        return amount;
    }
}
