module com.example.dictionary11dec {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dictionary11dec to javafx.fxml;
    exports com.example.dictionary11dec;
}