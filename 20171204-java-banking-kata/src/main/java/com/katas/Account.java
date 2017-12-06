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

    public void deposit(int amount) {
        transactions.add(new Transaction(LocalDate.now(), amount));
    }

    public String printStatement() {
        StringBuilder statementLines = new StringBuilder();
        Integer balance = 0;

        for (Transaction transaction : transactions) {
            String date = transaction.getDate().toString();
            Integer amount = transaction.getAmount();
            balance += amount;

            statementLines.append(buildStatementLine(balance, date, amount));
        }

        return STATEMENT_HEADER + statementLines;
    }

    private String buildStatementLine(Integer balance, String date, Integer amount) {
        return "\n" + date + "  +" + amount + "  " + balance;
    }

}