package com.johnbr.java_spreadsheet_report;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private Button loginButton;
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


//    methods

    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }




    public void loginForm(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Stage loginstage = (Stage) loginButton.getScene().getWindow();
        loginstage.initStyle(StageStyle.UNDECORATED);
        loginstage.setScene(new Scene(root, 520, 400));
        loginstage.show();
    }





}
