module com.example.guii {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.guii to javafx.fxml;
    exports com.example.guii;
}