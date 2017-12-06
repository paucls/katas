package com.katas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private DateProvider dateProvider;
    private StatementPresenter statementPresenter;
    private List<Transaction> transactions;

    Account(DateProvider dateProvider, StatementPresenter statementPresenter) {
        this.dateProvider = dateProvider;
        this.statementPresenter = statementPresenter;
        this.transactions = new ArrayList<>();
    }

    public void deposit(int amount) {
        transactions.add(new Transaction(dateProvider.currentDate(), amount));
    }

    public String printStatement() {
        Integer balance = 0;

        List<StatementLine> statementLines = new ArrayList<>();
        for (Transaction transaction : transactions) {
            LocalDate date = transaction.getDate();
            Integer amount = transaction.getAmount();
            balance += amount;

            statementLines.add(new StatementLine(date, amount, balance));
        }

        return statementPresenter.printStatement(statementLines);
    }

}