module com.example.tap2024 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tap2024 to javafx.fxml;
    exports com.example.tap2024;

    requires java.sql;
    requires mysql.connector.j;
    requires mariadb.java.client;
    opens com.example.tap2024.Modelos;
}