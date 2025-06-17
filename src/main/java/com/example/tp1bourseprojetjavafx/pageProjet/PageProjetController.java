package com.example.tp1bourseprojetjavafx.pageProjet;

import com.example.tp1bourseprojetjavafx.MainApplication;
import com.example.tp1bourseprojetjavafx.database.queries.ExpenseDAO;
import com.example.tp1bourseprojetjavafx.dialog.AddExpenseDialogue.AddExpenseController;
import com.example.tp1bourseprojetjavafx.expense.Expense;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Objects;

public class PageProjetController {
    @FXML
    private TableView<Expense> expenseData;

    @FXML
    private TableColumn<Expense, String> expenseName;

    @FXML
    private TableColumn<Expense, String> expenseHousing;

    @FXML
    private TableColumn<Expense, String> expenseDate;

    @FXML
    private TableColumn<Expense, Boolean> expenseFood;

    @FXML
    private TableColumn<Expense, Boolean> expenseGoingOut;

    @FXML
    private TableColumn<Expense, Boolean> expenseTransportation;

    @FXML
    private TableColumn<Expense, Boolean> expenseTravel;

    @FXML
    private TableColumn<Expense, Boolean> expenseTax;

    @FXML
    private TableColumn<Expense, Boolean> expenseOther;

    ExpenseDAO expenseDAO = new ExpenseDAO();

    /**
     * Constructor
     * */

    @FXML
    public void initialize() {
        loadExpenses();

        expenseName.setCellValueFactory(cellData ->
                new ReadOnlyObjectWrapper<>(cellData.getValue().getName() != null ? cellData.getValue().getName() : "N/A"));

        expenseDate.setCellValueFactory(cellData ->
                new ReadOnlyObjectWrapper<>(cellData.getValue().getDate() != null ? cellData.getValue().getDate() : "N/A"));

        expenseHousing.setCellValueFactory(cellData ->
                new ReadOnlyObjectWrapper<>(cellData.getValue().getHousing() != null ? cellData.getValue().getHousing() : "N/A"));

        expenseFood.setCellValueFactory(cellData ->
                new ReadOnlyObjectWrapper<>(Boolean.TRUE.equals(cellData.getValue().getFood())));

        expenseGoingOut.setCellValueFactory(cellData ->
                new ReadOnlyObjectWrapper<>(Boolean.TRUE.equals(cellData.getValue().getGoingOut())));

        expenseTransportation.setCellValueFactory(cellData ->
                new ReadOnlyObjectWrapper<>(Boolean.TRUE.equals(cellData.getValue().getTransportation())));

        expenseTravel.setCellValueFactory(cellData ->
                new ReadOnlyObjectWrapper<>(Boolean.TRUE.equals(cellData.getValue().getTravel())));

        expenseTax.setCellValueFactory(cellData ->
                new ReadOnlyObjectWrapper<>(Boolean.TRUE.equals(cellData.getValue().getTax())));

        expenseOther.setCellValueFactory(cellData ->
                new ReadOnlyObjectWrapper<>(Boolean.TRUE.equals(cellData.getValue().getOther())));

    }

    private void loadExpenses() {
        ObservableList<Expense> expenses = FXCollections.observableArrayList(expenseDAO.getExpenses());
        expenseData.setItems(expenses);
        System.out.println("Expenses chargées : " + expenseData.toString());
    }

    @FXML
    public void redirectToDialogExpense() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("dialog-add-expense-month.fxml"));
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

        loadExpenses();

    }
}
