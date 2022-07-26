module com.example.admin1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.admin1 to javafx.fxml;
    exports com.example.admin1;
}