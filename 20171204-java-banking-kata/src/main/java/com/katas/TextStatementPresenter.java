package com.katas;

import java.time.LocalDate;
import java.util.List;

public class TextStatementPresenter implements StatementPresenter {

    private static final String STATEMENT_HEADER = "Date  Amount  Balance";

    @Override
    public String printStatement(List<StatementLine> statementLines) {
        StringBuilder statementLinesText = new StringBuilder();

        for (StatementLine line : statementLines) {
            statementLinesText.append(buildStatementLine(line.getDate(), line.getAmount(), line.getBalance()));
        }

        return STATEMENT_HEADER + statementLinesText;
    }

    private String buildStatementLine(LocalDate date, Integer amount, Integer balance) {
        String prefix = amount > 0 ? "+" : "";

        return "\n" + date + "  " + prefix + amount + "  " + balance;
    }
}
