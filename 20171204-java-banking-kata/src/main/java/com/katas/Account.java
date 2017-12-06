package com.katas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private static final String STATEMENT_HEADER = "Date  Amount  Balance";

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

        statementPresenter.printStatement(statementLines);

        //

        StringBuilder allStatementLines = new StringBuilder();
        balance = 0;

        for (Transaction transaction : transactions) {
            String date = transaction.getDate().toString();
            Integer amount = transaction.getAmount();
            balance += amount;

            allStatementLines.append(buildStatementLine(balance, date, amount));
        }

        return STATEMENT_HEADER + allStatementLines;
    }

    private String buildStatementLine(Integer balance, String date, Integer amount) {
        return "\n" + date + "  +" + amount + "  " + balance;
    }

}