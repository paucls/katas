package dojo;

class Expense {
    ExpenseType type;
    int amount;

    String getExpenseName() {
        return switch (type) {
            case DINNER -> "Dinner";
            case BREAKFAST -> "Breakfast";
            case CAR_RENTAL -> "Car Rental";
        };
    }

    boolean isMealExpense() {
        return type == ExpenseType.DINNER || type == ExpenseType.BREAKFAST;
    }

    boolean isMealOverExpenses() {
        return type == ExpenseType.DINNER
                && amount > 5000
                || type == ExpenseType.BREAKFAST && amount > 1000;
    }
}
