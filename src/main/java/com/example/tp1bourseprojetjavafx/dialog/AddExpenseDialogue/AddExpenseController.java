package com.example.tp1bourseprojetjavafx.dialog.AddExpenseDialogue;

import com.example.tp1bourseprojetjavafx.expense.Expense;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;

public class AddExpenseController extends Dialog<Expense> {

    @FXML private TextField name;
    @FXML private DatePicker date;
    @FXML private TextField housing;
    @FXML private CheckBox food;
    @FXML private CheckBox goingOut;
    @FXML private CheckBox transportation;
    @FXML private CheckBox travel;
    @FXML private CheckBox tax;
    @FXML private CheckBox other;


    public Expense getExpense() {
        return new Expense(
                name.getText(),
                date.getValue(),
                housing.getText(),
                food.isSelected(),
                goingOut.isSelected(),
                transportation.isSelected(),
                travel.isSelected(),
                tax.isSelected(),
                other.isSelected()
        );
    }
}
