package com.example.tp1bourseprojetjavafx.scene;

import com.example.tp1bourseprojetjavafx.MainApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {

    private Stage stage;

    public SceneController(Stage stage) {
        this.stage = stage;
    }

    public void switchTo(String fxmlFile) throws IOException {
        System.out.println(new FXMLLoader(MainApplication.class.getResource(fxmlFile)));
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}
