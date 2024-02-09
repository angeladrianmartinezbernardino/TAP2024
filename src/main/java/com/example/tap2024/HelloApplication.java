package com.example.tap2024;

import com.example.tap2024.vistas.Calculadora;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Scene scene = new Scene(new BorderPane());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        new Calculadora();
    }

    public static void main(String[] args) {
        launch();
    }
}