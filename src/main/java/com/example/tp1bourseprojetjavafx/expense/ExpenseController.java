package com.example.tp1bourseprojetjavafx.expense;

import com.example.tp1bourseprojetjavafx.MainApplication;
import com.example.tp1bourseprojetjavafx.database.queries.ExpenseDAO;
import com.example.tp1bourseprojetjavafx.dialog.AddExpenseDialogue.AddExpenseController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import java.io.IOException;
import java.util.Objects;

public class ExpenseController {

     @FXML
    public void redirectToDialogExpense() throws IOException {
         FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("dialog-add-expense.fxml"));
         DialogPane dialogPane = loader.load();

         AddExpenseController controller = loader.getController();

         Dialog<Expense> dialog = new Dialog<>();
         dialog.setTitle("Ajouter une dépense");
         dialog.setDialogPane(dialogPane);

         dialog.setResultConverter((buttonType) -> {
             System.out.println("JE VIENS DE CLIQUER");
            if (!Objects.equals(ButtonBar.ButtonData.OK_DONE, buttonType.getButtonData())) {
                return null;
            }

            ExpenseDAO expenseDAO = new ExpenseDAO();
            expenseDAO.insertExpense(controller.getExpense());
            return controller.getExpense();

         });

         dialog.showAndWait();

     }
}
