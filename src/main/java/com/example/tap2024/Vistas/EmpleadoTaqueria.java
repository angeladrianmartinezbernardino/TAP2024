package com.example.tap2024.Vistas;

import com.example.tap2024.Componentes.ButtonCell;
import com.example.tap2024.Modelos.Empleados_DAO;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class EmpleadoTaqueria extends Stage {
    private VBox vbxPrincipal;
    private ToolBar tlbMenu;
    private Scene escena;
    private TableView<Empleados_DAO> tbvEmpleados;
    private Button btnAgregarEmpleado;

    public EmpleadoTaqueria() {
        CrearUI();
        this.setTitle("Taqueria Los Inges :)");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        ImageView imvEmp = new ImageView(getClass().getResource("/Imagenes/Edificio.png").toString());
        btnAgregarEmpleado = new Button();
        btnAgregarEmpleado.setOnAction(event -> new EmpleadosForm(tbvEmpleados));
        btnAgregarEmpleado.setPrefSize(50, 50);
        btnAgregarEmpleado.setGraphic(imvEmp);
        tlbMenu = new ToolBar(btnAgregarEmpleado);
        CrearTable();
        vbxPrincipal = new VBox(tlbMenu, tbvEmpleados);
        escena = new Scene(vbxPrincipal, 300, 200);
    }

    private void CrearTable() {
        Empleados_DAO objEmp = new Empleados_DAO();
        tbvEmpleados = new TableView<Empleados_DAO>();
        TableColumn<Empleados_DAO, String> tbcNombreEmp = new TableColumn<>("Empleado");
        tbcNombreEmp.setCellValueFactory(new PropertyValueFactory<>("nombre_empleado"));
        TableColumn<Empleados_DAO, String> tbcrfcEmp = new TableColumn<>("RFC");
        tbcrfcEmp.setCellValueFactory(new PropertyValueFactory<>("rfc_empleado"));
        TableColumn<Empleados_DAO, Float> tbcSueldoEmp = new TableColumn<>("Sueldo");
        tbcSueldoEmp.setCellValueFactory(new PropertyValueFactory<>("salario"));
        TableColumn<Empleados_DAO, String> tbcTelEmp = new TableColumn<>("Telefono");
        tbcTelEmp.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        TableColumn<Empleados_DAO, String> tbcDirEmp = new TableColumn<>("Direccion");
        tbcDirEmp.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        TableColumn<Empleados_DAO, String> tbcEditar = new TableColumn<Empleados_DAO, String>();
        tbcEditar.setCellFactory(new Callback<TableColumn<Empleados_DAO, String>, TableCell<Empleados_DAO, String>>() {
            @Override
            public TableCell<Empleados_DAO, String> call(TableColumn<Empleados_DAO, String> empleadosDaoStringTableColumn) {
                return new ButtonCell();
            }
        });
        tbvEmpleados.getColumns().addAll(tbcNombreEmp, tbcrfcEmp, tbcSueldoEmp, tbcTelEmp, tbcDirEmp, tbcEditar);
        tbvEmpleados.setItems(objEmp.Consultar());
    }
}
