module com.johnbr.java_spreadsheet_report {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires mysql.connector.j;
    requires java.sql;


    opens com.johnbr.java_spreadsheet_report to javafx.fxml;
    exports com.johnbr.java_spreadsheet_report;
}