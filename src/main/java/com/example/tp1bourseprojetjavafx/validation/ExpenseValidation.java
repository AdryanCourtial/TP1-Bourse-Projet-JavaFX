package com.example.tp1bourseprojetjavafx.validation;

import com.example.tp1bourseprojetjavafx.expense.Expense;

public class ExpenseValidation {

    public static boolean validateExpense(Expense expense) {

        if (expense == null) {
            return false;
        }

        if (expense.getDate() == null) {
            return false;
        }

        if (expense.getName() == null || expense.getName().length() > 15) {
            return false;
        }

        if (expense.getHousing() == null) {
            return false;
        }

        return true;
    }
}
