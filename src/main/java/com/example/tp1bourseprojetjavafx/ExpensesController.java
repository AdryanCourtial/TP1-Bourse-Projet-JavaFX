package com.example.tp1bourseprojetjavafx;

import com.example.tp1bourseprojetjavafx.model.Expense;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ExpensesController {

    @FXML private TableView<Expense> expenseTable;

    @FXML private TableColumn<Expense, String> colPeriode;
    @FXML private TableColumn<Expense, Double> colTotal;
    @FXML private TableColumn<Expense, Double> colLogement;
    @FXML private TableColumn<Expense, Double> colNourriture;
    @FXML private TableColumn<Expense, Double> colSorties;
    @FXML private TableColumn<Expense, Double> colTransport;
    @FXML private TableColumn<Expense, Double> colVoyage;
    @FXML private TableColumn<Expense, Double> colImpots;
    @FXML private TableColumn<Expense, Double> colAutres;

    @FXML
    public void initialize() {
        colPeriode.setCellValueFactory(new PropertyValueFactory<>("periode"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colLogement.setCellValueFactory(new PropertyValueFactory<>("logement"));
        colNourriture.setCellValueFactory(new PropertyValueFactory<>("nourriture"));
        colSorties.setCellValueFactory(new PropertyValueFactory<>("sorties"));
        colTransport.setCellValueFactory(new PropertyValueFactory<>("transport"));
        colVoyage.setCellValueFactory(new PropertyValueFactory<>("voyage"));
        colImpots.setCellValueFactory(new PropertyValueFactory<>("impots"));
        colAutres.setCellValueFactory(new PropertyValueFactory<>("autres"));

        ObservableList<Expense> expenses = FXCollections.observableArrayList(
                new Expense("2020-01", 1000, 100, 100, 100, 100, 100, 100, 100),
                new Expense("2020-02", 1000, 100, 100, 100, 100, 100, 100, 100),
                new Expense("2020-03", 1000, 100, 100, 100, 100, 100, 100, 100)
        );

        expenseTable.setItems(expenses);
    }
}
