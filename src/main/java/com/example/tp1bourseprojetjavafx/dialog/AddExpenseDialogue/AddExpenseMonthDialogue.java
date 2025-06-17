package com.example.tp1bourseprojetjavafx.dialog.AddExpenseDialogue;

import com.example.tp1bourseprojetjavafx.expense.Expense;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddExpenseMonthDialogue {


    @FXML
    private TextField name;
    @FXML private ComboBox<String> date;
    @FXML private TextField housing;
    @FXML private CheckBox food;
    @FXML private CheckBox goingOut;
    @FXML private CheckBox transportation;
    @FXML private CheckBox travel;
    @FXML private CheckBox tax;
    @FXML private CheckBox other;

    public void initialize() {
    date.setItems(FXCollections.observableArrayList(
            "Janvier", "Février", "Mars", "Avril", "Mai", "Juin",
            "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"
    ));
    }


    public Expense getExpenseMonth() {
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
