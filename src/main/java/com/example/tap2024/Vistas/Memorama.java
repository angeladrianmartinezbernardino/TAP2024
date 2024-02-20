package com.example.tap2024.Vistas;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        RevolverCartas();
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

    public void RevolverCartas() {
        String[] arImaagenes = {"Cereza.jpg", "Fresa.jpg", "Mango.jpg", "Melon.jpg", "Mora.jpg", "Pera.jpg", "Sandia.jpg"};
        Button[][] arBtnCartas = new Button[2][5];
        ImageView imvCarta ;
        int posx = 0;
        int posy = 0;
        int cont = 0;
        for (int i = 0; i < arImaagenes.length; ) {
            posx = (int) (Math.random() * 2);
            posy = (int) (Math.random() * 4);
            if (arBtnCartas[posx][posy] == null) {
                arBtnCartas[posx][posy] = new Button();
                imvCarta = new ImageView(getClass().getResource("/Imagenes/"+arImaagenes[i]).toString());
                cont++;
                arBtnCartas[posx][posy].setGraphic(imvCarta);
                arBtnCartas[posx][posy].setPrefSize(100, 100);

                if (cont == 2) i++;
            }
        }

        Image[][] arCartas = new Image[2][5];
        Image carta;
    }
}
