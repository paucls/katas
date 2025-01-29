package dojo;

import java.util.Date;
import java.util.List;

public class ExpenseReport {
    public void printReport(List<Expense> expenses) {

        Expenses expensesList = new Expenses(expenses);

        System.out.println("Expenses " + new Date());

        for (Expense expense : expenses) {
            System.out.println(expense.name() + "\t" + expense.amount + "\t" + formatMealOverExpense(expense));
        }

        // print
        System.out.println("Meal expenses: " + expensesList.calculateMealExpenses());
        System.out.println("Total expenses: " + expensesList.calculateTotal());
    }

    private static String formatMealOverExpense(Expense expense) {
        String mealOverExpensesMarker;
        if (expense.isMealOverExpense()) mealOverExpensesMarker = "X";
        else mealOverExpensesMarker = " ";
        return mealOverExpensesMarker;
    }
}