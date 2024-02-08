package com.example.tap2024.vistas;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculadora extends Stage {
    private Scene escena;
    private VBox vContenedor;
    private GridPane gdpTeclado;
    private TextField txtPantalla;
    private Button[] arBotones = new Button[16];

    public Calculadora(){
        CrearUI();
        this.setTitle("Mi primer Calculadora :)");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        vContenedor = new VBox();
    }
}
