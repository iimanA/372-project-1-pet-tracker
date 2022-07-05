module project2.ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    opens project2.ui to javafx.fxml;
    exports project2.ui;
    exports project2.controller;
    opens project2.controller to javafx.fxml;
}