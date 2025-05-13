package com.example.tp1bourseprojetjavafx;

import com.example.tp1bourseprojetjavafx.database.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class MainApplication extends Application {

    public Connection con;

    @Override
    public void start(Stage stage) throws IOException {

        if (Database.isOK()) {

            try {

                this.con = Database.connect();

                FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));

                Scene scene = new Scene(fxmlLoader.load(), 320, 240);
                stage.setTitle("Bourse Project JavaFX");
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {

                e.printStackTrace();

            }
        } else {

            System.out.println("Database NOT OK");

        }
    }

    public static void main(String[] args) {
        launch();
    }
}