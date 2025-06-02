package com.example.tp1bourseprojetjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;

public class MyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MyApplication.class.getResource("expenses-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 400);
        // Titre
        stage.setTitle("Finance Tracker");

        // Icône
        stage.getIcons().add(new Image(MyApplication.class.getResourceAsStream("icon.png")));
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}