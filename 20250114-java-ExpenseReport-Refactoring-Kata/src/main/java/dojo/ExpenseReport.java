package dojo;

import java.util.Date;
import java.util.List;

public class ExpenseReport {
    public void printReport(List<Expense> expenses) {

        System.out.println("Expenses " + new Date());

        for (Expense expense : expenses) {
            System.out.println(expense.getExpenseName() + "\t" + expense.amount + "\t" + formatMealOverExpenses(expense));
        }

        System.out.println("Meal expenses: " + calculateMealExpenses(expenses));
        System.out.println("Total expenses: " + calculateTotal(expenses));
    }

    private static String formatMealOverExpenses(Expense expense) {
        return expense.isMealOverExpenses() ? "X" : " ";
    }

    private static int calculateMealExpenses(List<Expense> expenses) {
        return expenses.stream()
                .filter(Expense::isMealExpense)
                .mapToInt(expense -> expense.amount).sum();
    }

    private static int calculateTotal(List<Expense> expenses) {
        return expenses.stream().mapToInt(expense -> expense.amount).sum();
    }
}
