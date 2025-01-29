package dojo;

import java.util.List;

public class Expenses {
    private final List<Expense> expenses;

    public Expenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    int calculateTotal() {
        int total = 0;
        for (Expense expense : getExpenses()) {
            total += expense.amount;
        }
        return total;
    }

    int calculateMealExpenses() {
        int mealExpenses = 0;
        for (Expense expense : getExpenses()) {
            if (expense.isMealExpense()) {
                mealExpenses += expense.amount;
            }
        }
        return mealExpenses;
    }
}
