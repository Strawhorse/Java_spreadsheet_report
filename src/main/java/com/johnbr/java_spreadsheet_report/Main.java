package com.johnbr.java_spreadsheet_report;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;



public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));


        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("Spreadsheet report generator!");
        stage.setScene(scene);
        stage.show();
    }







//    launch method
    public static void main(String[] args) {
        launch();
    }
}