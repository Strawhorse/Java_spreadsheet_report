module com.johnbr.java_spreadsheet_report {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.johnbr.java_spreadsheet_report to javafx.fxml;
    exports com.johnbr.java_spreadsheet_report;
}