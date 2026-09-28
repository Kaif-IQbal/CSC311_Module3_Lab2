module com.example.csc311_module3_lab2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.csc311_module3_lab2 to javafx.fxml;
    exports com.example.csc311_module3_lab2;
}