module com.example.suahet {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.suahet to javafx.fxml;
    exports com.example.suahet;
}