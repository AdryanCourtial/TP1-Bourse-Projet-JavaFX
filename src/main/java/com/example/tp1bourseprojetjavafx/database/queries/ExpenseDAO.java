package com.example.tp1bourseprojetjavafx.database.queries;

import com.example.tp1bourseprojetjavafx.database.Database;
import com.example.tp1bourseprojetjavafx.expense.Expense;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
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
}
