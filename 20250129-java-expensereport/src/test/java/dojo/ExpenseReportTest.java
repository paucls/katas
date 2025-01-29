package dojo;

import org.approvaltests.Approvals;
import org.approvaltests.core.Options;
import org.approvaltests.scrubbers.DateScrubber;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class ExpenseReportTest {
    @Test
    public void testExpenseReport() throws IOException {
        //Redirect System.out to buffer
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        var expenses = List.of(
                createExpense(ExpenseType.DINNER, 5000),
                createExpense(ExpenseType.DINNER, 5001),
                createExpense(ExpenseType.BREAKFAST, 1000),
                createExpense(ExpenseType.BREAKFAST, 1001),
                createExpense(ExpenseType.CAR_RENTAL, 200)
        );
        new ExpenseReport().printReport(expenses);

        bo.flush();
        String allWrittenLines = bo.toString();
        Approvals.verify(allWrittenLines, new Options(
                DateScrubber.getScrubberFor("Wed Dec 11 14:41:00 CET 2024"))
        );
    }

    private Expense createExpense(ExpenseType expenseType, int amount) {
        var expense = new Expense();
        expense.type = expenseType;
        expense.amount = amount;
        return expense;
    }
}
