package com.johnbr.java_spreadsheet_report;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class LoginController {

    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;




    //    methods

    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void loginButtonOnAction(ActionEvent event) {

//        create loop to check that both sets of user credentials were entered
        if (!usernameTextField.getText().isBlank() && !enterPasswordField.getText().isBlank()) {
            try {
                validateLogin();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            loginMessageLabel.setText("Incorrect or empty login details entered");
            usernameTextField.setText("");
            enterPasswordField.setText("");
        }
    }


//method to validate login against username/password in database
    public void validateLogin() throws SQLException {

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectToDB = connection.getConnection();

        String verifyLoginDetails = "SELECT count(1) from user_account WHERE username = '" + usernameTextField.getText() + "' AND password = '" + enterPasswordField.getText() + "';";

        Statement statement = connectToDB.createStatement();
        ResultSet queryResult = statement.executeQuery(verifyLoginDetails);

        while(queryResult.next()){
            if(queryResult.getInt(1) == 1) {
                loginMessageLabel.setText("Login Successful!");
            } else{
                loginMessageLabel.setText("Login details incorrect. Please try again.");
            }
        }

    }



}