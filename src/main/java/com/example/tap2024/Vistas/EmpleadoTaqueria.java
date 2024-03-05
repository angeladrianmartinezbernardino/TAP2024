package com.example.tap2024.Vistas;

import com.example.tap2024.Modelos.Empleados_DAO;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmpleadoTaqueria extends Stage {
    private VBox vbxPrincipal;
    private ToolBar tlbMenu;
    private Scene escena;
    private TableView<Empleados_DAO> tbvEmpleados;

    public EmpleadoTaqueria() {
        CrearUI();
        this.setTitle("Taqueria Los Inges :)");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        tlbMenu = new ToolBar();
        CrearTable();
        vbxPrincipal = new VBox(tlbMenu, tbvEmpleados);
        escena = new Scene(vbxPrincipal, 300, 200);
    }

    private void CrearTable() {
        tbvEmpleados = new TableView<Empleados_DAO>();
        TableColumn<Empleados_DAO, String> tbcNombreEmp = new TableColumn<>("Empleado");
        TableColumn<Empleados_DAO, String> tbcrfcEmp = new TableColumn<>("RFC");
        TableColumn<Empleados_DAO, Float> tbcSueldoEmp = new TableColumn<>("Sueldo");
        TableColumn<Empleados_DAO, String> tbcTelEmp = new TableColumn<>("Telefono");
        TableColumn<Empleados_DAO, String> tbcDirEmp = new TableColumn<>("Direccion");
        //...
        tbvEmpleados.getColumns().addAll(tbcNombreEmp, tbcrfcEmp, tbcSueldoEmp, tbcTelEmp, tbcDirEmp);
    }
}
