package com.example.tp1bourseprojetjavafx.database.queries;

import com.example.tp1bourseprojetjavafx.database.Database;
import com.example.tp1bourseprojetjavafx.expense.Expense;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExpenseDAO {

    public boolean insertExpense(Expense expense) {
        String insertExpense = """
                    INSERT INTO expense (name, date, housing, food, goingOut, transportation, travel, tax, other)
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
               """;

        try (Connection con = Database.connect()) {
            PreparedStatement statement = con.prepareStatement(insertExpense);
            statement.setString(1, expense.getName());
            statement.setString(2, expense.getDate().toString());
            statement.setString(3, expense.getHousing());
            statement.setBoolean(4, expense.getFood());
            statement.setBoolean(5, expense.getGoingOut());
            statement.setBoolean(6, expense.getTransportation());
            statement.setBoolean(7, expense.getTravel());
            statement.setBoolean(8, expense.getTax());
            statement.setBoolean(9, expense.getOther());
            statement.executeUpdate();
            return true;
        } catch (SQLException exception) {
            Logger.getAnonymousLogger().log(Level.WARNING, LocalDateTime.now() + exception.getMessage());
            return false;
        }
    }

    public boolean insertExpenseMonth(Expense expense) {
        String insertExpense = """
                    INSERT INTO expense_month (name, date, housing, food, goingOut, transportation, travel, tax, other)
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
               """;

        try (Connection con = Database.connect()) {
            PreparedStatement statement = con.prepareStatement(insertExpense);
            statement.setString(1, expense.getName());
            statement.setString(2, expense.getDate().toString());
            statement.setString(3, expense.getHousing());
            statement.setBoolean(4, expense.getFood());
            statement.setBoolean(5, expense.getGoingOut());
            statement.setBoolean(6, expense.getTransportation());
            statement.setBoolean(7, expense.getTravel());
            statement.setBoolean(8, expense.getTax());
            statement.setBoolean(9, expense.getOther());
            statement.executeUpdate();
            return true;
        } catch (SQLException exception) {
            Logger.getAnonymousLogger().log(Level.WARNING, LocalDateTime.now() + exception.getMessage());
            return false;
        }
    }

    public List<Expense> getExpenses() {

        List<Expense> result = new ArrayList<>();

        String getExpenses = """
                    SELECT * FROM expense
               """;

        try (Connection con = Database.connect()) {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(getExpenses);

            while (rs.next()) {
                Expense expense = new Expense(
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getString("housing"),
                        rs.getBoolean("food"),
                        rs.getBoolean("goingOut"),
                        rs.getBoolean("transportation"),
                        rs.getBoolean("travel"),
                        rs.getBoolean("tax"),
                        rs.getBoolean("other")
                );
                result.add(expense);
            }

            List<Expense> expenseList = new ArrayList<>();;
            expenseList.add(new Expense("Burger King", "2024-06-01", "Appartement",
                    true, false, true, false, false, false));

            return result;

        } catch (SQLException exception) {

            Logger.getAnonymousLogger().log(Level.WARNING, LocalDateTime.now() + exception.getMessage());
            return null;
        }
    }
}
