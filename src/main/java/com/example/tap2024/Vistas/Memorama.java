package com.example.tap2024.Vistas;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Memorama extends Stage {

    private Scene escena;
    private VBox vBoxPrincipal;
    private HBox hBoxTimer;
    private HBox[] hBoxJugadores = new HBox[4];
    private GridPane gridPaneJugadores;
    private TextField txtNoPares;
    private Button btnResolver;
    private Label lblTimer;
    private Thread timerThread;

    public Memorama() {
        CrearUI();
        this.setTitle("Juego con Timer");
        this.setScene(escena);
        this.show();
        iniciarTimer();
    }

    private void CrearUI() {
        txtNoPares = new TextField();
        btnResolver = new Button("Resolver");
        lblTimer = new Label("00:00");

        // Timer HBox
        hBoxTimer = new HBox(lblTimer);
        hBoxTimer.setSpacing(10);

        // Jugadores HBoxes
        gridPaneJugadores = new GridPane();
        for (int i = 0; i < hBoxJugadores.length; i++) {
            hBoxJugadores[i] = new HBox(new Label("Jugador " + (i + 1)), new TextField());
            gridPaneJugadores.add(hBoxJugadores[i], i % 2, i / 2);
            gridPaneJugadores.setHgap(10);
            gridPaneJugadores.setVgap(10);
        }

        // VBox principal
        vBoxPrincipal = new VBox(new HBox(new Label("No. Pares:"), txtNoPares, btnResolver), gridPaneJugadores, hBoxTimer);
        vBoxPrincipal.setSpacing(15);

        escena = new Scene(vBoxPrincipal, 300, 200);
    }

    private void iniciarTimer() {
        timerThread = new Thread(() -> {
            int minutos = 0;
            int segundos = 0;
            try {
                while (true) {
                    segundos++;
                    if (segundos == 60) {
                        minutos++;
                        segundos = 0;
                    }
                    String tiempoStr = String.format("%02d:%02d", minutos, segundos);
                    Platform.runLater(() -> lblTimer.setText(tiempoStr));
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        timerThread.start();
    }
}
