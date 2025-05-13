package com.example.tp1bourseprojetjavafx.database.queries;

import com.example.tp1bourseprojetjavafx.database.Database;
import com.example.tp1bourseprojetjavafx.expense.Expense;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExpenseDAO {

    public boolean insertExpense(Expense expense) {
        String insertExpense = """
                    INSERT INTO expense (date, housing, food, goingOut, transportation, travel, tax, other)
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?)
               """;

        try (Connection con = Database.connect()) {
            PreparedStatement statement = con.prepareStatement(insertExpense);
            statement.setString(1, expense.getDate());
            statement.setDouble(2, expense.getHousing());
            statement.setBoolean(3, expense.getFood());
            statement.setBoolean(4, expense.getGoingOut());
            statement.setBoolean(5, expense.getTransportation());
            statement.setBoolean(6, expense.getTravel());
            statement.setBoolean(7, expense.getTax());
            statement.setBoolean(8, expense.getOther());
            statement.executeQuery();
            return true;
        } catch (SQLException exception) {
            Logger.getAnonymousLogger().log(Level.SEVERE, LocalDateTime.now() + ": Could not find tables in database");
            return false;
        }
    }
}
