package com.example.tap2024;

import com.example.tap2024.Componentes.Hilo;
import com.example.tap2024.Modelos.Conexion;
import com.example.tap2024.Vistas.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private MenuBar mnbPrincipal;
    private Menu menParcial1, menParcial2, menSalir;
    private MenuItem mitCalculadora, mitMemorama, mitSalir, mitCuadromagico, mitEmpleado, mitPista;
    private BorderPane bdpPanel;

    @Override
    public void start(Stage stage) throws IOException {
        CrearMenu();
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        bdpPanel = new BorderPane();
        bdpPanel.setTop(mnbPrincipal);
        Scene scene = new Scene(bdpPanel);
        scene.getStylesheets().add(getClass().getResource("/Estilos/Main.css").toString());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        //new Calculadora();
        stage.setMaximized(true);
        new Hilo("Juno").start();
        new Hilo("Joshua").start();
        new Hilo("Alma").start();
        new Hilo("Sergio").start();
        new Hilo("Alma").start();
        Conexion.Crear_conexion();
    }

    private void CrearMenu() {
        // Inicializar MenuBar
        mnbPrincipal = new MenuBar();

        // Inicializar Menus
        menParcial1 = new Menu("Primer Parcial");
        menParcial2 = new Menu("Segundo Parcial");
        menSalir = new Menu("Salir");

        // Inicializar MenuItems
        mitCalculadora = new MenuItem("Calculadora");
        mitCalculadora.setOnAction((event) -> new Calculadora());
        mitMemorama = new MenuItem("Memorama");
        mitMemorama.setOnAction((event) -> new Memorama());
        mitCuadromagico = new MenuItem("Cuadro magico");
        mitCuadromagico.setOnAction((event) -> new CuadroMagico());
        mitSalir = new MenuItem("Salir");
        mitSalir.setOnAction(event -> System.exit(0));
        mitEmpleado = new MenuItem("Empleado Tauqeria");
        mitEmpleado.setOnAction((event) -> new EmpleadoTaqueria());
        mitPista = new MenuItem("Pista");
        mitPista.setOnAction((event) -> new Pista());

        // Añadir MenuItems a Menus
        menParcial1.getItems().addAll(mitCalculadora, mitMemorama, mitEmpleado, mitCuadromagico);
        menParcial2.getItems().addAll(mitPista);
        menSalir.getItems().add(mitSalir);

        // Añadir Menus a MenuBar
        mnbPrincipal.getMenus().addAll(menParcial1, menParcial2, menSalir);
    }


    public static void main(String[] args) {
        launch();
    }
}