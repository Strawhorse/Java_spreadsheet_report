package com.johnbr.java_spreadsheet_report;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;


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



    public void registerButtonOnAction(ActionEvent event) throws SQLException {
        if (setPasswordField.getText().equals(confirmPasswordField.getText())) {
            confirmPasswordLabel.setText("");
            registerUser();
        } else {
            confirmPasswordLabel.setText("Passwords do not match. Try again.");
            setPasswordField.setText("");
            confirmPasswordField.setText("");
        }
    }


    public void closeButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }


//    main method for registering users
    public void registerUser() throws SQLException {

        DatabaseConnection registerConnection = new DatabaseConnection();
        Connection connectToRegister = registerConnection.getConnection();

        String firstNameText = FirstnameTextField.getText();
        String lastNameText = lastnameTextField.getText();
        String userNameText = usernameTextField.getText();
        String passwordInsertText = setPasswordField.getText();

        String verifyLoginDetails = "insert into user_account (firstname, lastname, username, password)values(?,?,?,?)";
        PreparedStatement pstmt = connectToRegister.prepareStatement(verifyLoginDetails);
        pstmt.setString(1, firstNameText);
        pstmt.setString(2, lastNameText);
        pstmt.setString(3, userNameText);
        pstmt.setString(4, passwordInsertText);

        pstmt.executeUpdate();
        System.out.println("Executing query: " + pstmt.toString());
        registrationLabel.setText("User registration complete! Login now.");

        connectToRegister.close();



    }


}
