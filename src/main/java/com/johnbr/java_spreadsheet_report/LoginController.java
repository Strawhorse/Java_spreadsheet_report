package com.johnbr.java_spreadsheet_report;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import static javafx.fxml.FXMLLoader.*;


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

    public void loginButtonOnAction(ActionEvent event) {

//        create loop to check that both sets of user credentials were entered
        if (!usernameTextField.getText().isBlank() && !enterPasswordField.getText().isBlank()) {
            try {
                validateLogin();
            } catch (SQLException | IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            loginMessageLabel.setText("Incorrect or empty login details entered");
            usernameTextField.setText("");
            enterPasswordField.setText("");
        }
    }


//method to validate login against username/password in database
    public void validateLogin() throws SQLException, IOException {

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectToDB = connection.getConnection();

        String verifyLoginDetails = "SELECT count(1) from user_account WHERE username = '" + usernameTextField.getText() + "' AND password = '" + enterPasswordField.getText() + "';";

        Statement statement = connectToDB.createStatement();
        ResultSet queryResult = statement.executeQuery(verifyLoginDetails);

        while(queryResult.next()){
            if(queryResult.getInt(1) == 1) {
                loginMessageLabel.setText("Login Successful!");
//                createAccountForm();
            } else{
                loginMessageLabel.setText("Login details incorrect. Please try again.");
            }
        }

    }

//    method to swap over to registration form
    public void createAccountForm() throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("register.fxml")));
        Stage registerstage = new Stage();
        registerstage.initStyle(StageStyle.UNDECORATED);
        registerstage.setScene(new Scene(root, 520, 474));
        registerstage.show();
    }




    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }


}