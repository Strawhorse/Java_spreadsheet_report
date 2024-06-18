package com.johnbr.java_spreadsheet_report;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller {

    @FXML
    public Button quitButton;


    @FXML
    private Label welcomeText;
    @FXML
    private Label buttonForLogin;


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


    @FXML
    protected void loginButton(ActionEvent event){
        buttonForLogin.setText("Logging in...");
    }

}