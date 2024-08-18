package com.johnbr.java_spreadsheet_report;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.util.Objects;


public class RegisterController {

    @FXML
    private Button registerButton;
    @FXML
    private Button closeButton;
    @FXML
    private TextField FirstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField setPasswordField;
    @FXML
    private TextField confirmPasswordField;
    @FXML
    private Label registrationLabel;
    @FXML
    private Label confirmPasswordLabel;



    public void registerButtonOnAction(ActionEvent event) {
        registrationLabel.setText("Registered successfully!");
        registerUser();
    }


    public void closeButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }


    public void registerUser(){

        if (setPasswordField.getText().equals(confirmPasswordField.getText())) {
            confirmPasswordLabel.setText("Passwords match. Registration details correct.");
        } else {
            confirmPasswordLabel.setText("Passwords do not match.");
            setPasswordField.setText("");
            confirmPasswordField.setText("");
        }

    }


}
