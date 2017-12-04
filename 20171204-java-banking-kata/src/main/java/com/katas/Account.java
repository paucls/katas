package com.katas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private static final String STATEMENT_HEADER = "Date  Amount  Balance";
    private List<Transaction> transactions;

    Account() {
        this.transactions = new ArrayList<>();
    }

    public String printStatement() {
        StringBuilder statementLines = new StringBuilder();

        for (Transaction transaction : transactions) {
            String date = transaction.getDate().toString();
            Integer amount = transaction.getAmount();
            String statementLine = "\n" + date + "  +" + amount + "  " + amount;
            statementLines.append(statementLine);
        }

        return STATEMENT_HEADER + statementLines;
    }

    public void deposit(int amount) {
        transactions.add(new Transaction(LocalDate.now(), amount));
    }

}