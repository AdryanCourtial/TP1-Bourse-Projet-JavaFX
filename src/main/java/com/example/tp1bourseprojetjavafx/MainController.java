package com.example.tp1bourseprojetjavafx;

import com.example.tp1bourseprojetjavafx.scene.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Label welcomeText;

    @FXML
    public void onHelloButtonClick(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController((Stage) ((Node) event.getSource()).getScene().getWindow());
        System.out.println("sceneController");

        sceneController.switchTo("expense-view.fxml");

    }
}