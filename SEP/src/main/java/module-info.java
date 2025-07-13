module com.example.sep {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sep to javafx.fxml;
    exports com.example.sep;
}