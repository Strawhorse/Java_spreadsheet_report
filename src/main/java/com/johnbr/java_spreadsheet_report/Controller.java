package com.johnbr.java_spreadsheet_report;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Controller {

    @FXML
    public Button quitButton;

    @FXML
    private Label welcomeText;


//   methods
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Hi");
    }

    @FXML
    protected void quitButton(ActionEvent event) {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }
}