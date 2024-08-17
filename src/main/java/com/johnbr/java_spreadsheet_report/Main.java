package com.johnbr.java_spreadsheet_report;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;



public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));






//        primaryStage.setTitle("Cork English College Login");
//        no band label at the top
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(fxmlLoader.load()));
        primaryStage.show();
    }


//    launch method
    public static void main(String[] args) {
        launch();
    }
}