package com.johnbr.java_spreadsheet_report;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    private Label labelUsername;
    






//    methods

    public void setUsername(String username) {
//        to pass whichever person is logged in to the dashboard
        labelUsername.setText(username);
    }

}
