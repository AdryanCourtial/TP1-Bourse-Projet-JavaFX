package com.example.tp1bourseprojetjavafx.database;

import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    /**
     * Location of database
     */
    private static final String location = "database.db";

    /**
     * Currently only table needed
     */
    private static final String requiredTable = "Expense";

    public static boolean isOK() {
        if (!checkDrivers()) return false; //driver errors

        if (!checkConnection()) return false; //can't connect to db

        return createTableIfNotExists(); //tables didn't exist
    }

    private static boolean checkDrivers() {
        try {
            Class.forName("org.sqlite.JDBC");
            DriverManager.registerDriver(new JDBC());
            return true;
        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            Logger.getAnonymousLogger().log(Level.SEVERE, LocalDateTime.now() + ": Could not start SQLite Drivers");
            return false;
        }
    }

    private static boolean checkConnection() {
        try (Connection connection = connect()) {
            return connection != null;
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, LocalDateTime.now() + ": Could not connect to database");
            return false;
        }
    }

    private static boolean createTableIfNotExists() {
        String createTables =
                """
                        CREATE TABLE IF NOT EXISTS expense(
                             name TEXT NOT NULL,
                             date TEXT NOT NULL,
                             housing TEXT NOT NULL,
                             food BOOLEAN NOT NULL,
                             goingOut BOOLEAN NOT NULL,
                             transportation BOOLEAN NOT NULL,
                             travel BOOLEAN NOT NULL,
                             tax BOOLEAN NOT NULL,
                             other BOOLEAN NOT NULL
                     );
                   """;

        try (Connection connection = Database.connect()) {
            PreparedStatement statement = connection.prepareStatement(createTables);
            statement.executeUpdate();
            return true;
        } catch (SQLException exception) {
            Logger.getAnonymousLogger().log(Level.SEVERE, LocalDateTime.now() + ": Could not find tables in database");
            return false;
        }
    }

    public static Connection connect() {
        String dbPrefix = "jdbc:sqlite:";
        Connection connection;
        try {
            connection = DriverManager.getConnection(dbPrefix + location);
        } catch (SQLException exception) {
            Logger.getAnonymousLogger().log(Level.SEVERE,
                    LocalDateTime.now() + ": Could not connect to SQLite DB at " +
                            location);
            return null;
        }
        return connection;
    }

}
