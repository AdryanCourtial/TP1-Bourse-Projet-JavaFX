package com.example.tp1bourseprojetjavafx.components;

import com.example.tp1bourseprojetjavafx.scene.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public class HeaderController {

    private SceneController sceneController;

    public HeaderController() {
    }

    @FXML
    public void redirectExpense(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController((Stage) ((Node) event.getSource()).getScene().getWindow());
        sceneController.switchTo("expense-view.fxml");
    }

    @FXML
    public void redirectDashboard(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController((Stage) ((Node) event.getSource()).getScene().getWindow());
        sceneController.switchTo("dashboard-view.fxml");
    }

    @FXML
    public void redirectPageProjet(ActionEvent event) throws IOException {
        SceneController sceneController = new SceneController((Stage) ((Node) event.getSource()).getScene().getWindow());
        sceneController.switchTo("page-projet-view.fxml");
    }
}
