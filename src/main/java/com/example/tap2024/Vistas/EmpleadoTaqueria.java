package com.example.tap2024.Vistas;

import com.example.tap2024.Componentes.ButtonCell;
import com.example.tap2024.Modelos.Empleados_DAO;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.kordamp.bootstrapfx.BootstrapFX;
import org.kordamp.bootstrapfx.scene.layout.Panel;

public class EmpleadoTaqueria extends Stage {
    private Panel pnlPrincipal;
    private BorderPane bpnPrincipal;
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
        imvEmp.setFitHeight(50);
        imvEmp.setFitWidth(50);
        btnAgregarEmpleado = new Button();
        btnAgregarEmpleado.setOnAction(event -> new EmpleadosForm(tbvEmpleados, null));
        btnAgregarEmpleado.setPrefSize(50, 50);
        btnAgregarEmpleado.setGraphic(imvEmp);
        tlbMenu = new ToolBar(btnAgregarEmpleado);
        CrearTable();
        bpnPrincipal = new BorderPane();
        bpnPrincipal.setTop(tlbMenu);
        bpnPrincipal.setCenter(tbvEmpleados);
        pnlPrincipal = new Panel("Taqueria");
        pnlPrincipal.getStyleClass().add("panel-primary");
        pnlPrincipal.setBody(bpnPrincipal);
        escena = new Scene(pnlPrincipal, 700, 400);
        escena.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
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

        TableColumn<Empleados_DAO, String> tbcEditar = new TableColumn<Empleados_DAO, String>("Editar");
        tbcEditar.setCellFactory(new Callback<TableColumn<Empleados_DAO, String>, TableCell<Empleados_DAO, String>>() {
            @Override
            public TableCell<Empleados_DAO, String> call(TableColumn<Empleados_DAO, String> param) {
                return new ButtonCell(1);
            }
        });

        TableColumn<Empleados_DAO, String> tbcEliminar = new TableColumn<Empleados_DAO, String>("Eliminar");
        tbcEliminar.setCellFactory(new Callback<TableColumn<Empleados_DAO, String>, TableCell<Empleados_DAO, String>>() {
            @Override
            public TableCell<Empleados_DAO, String> call(TableColumn<Empleados_DAO, String> param) {
                return new ButtonCell(2);
            }
        });
        tbvEmpleados.getColumns().addAll(tbcNombreEmp, tbcrfcEmp, tbcSueldoEmp, tbcTelEmp, tbcDirEmp, tbcEditar, tbcEliminar);
        tbvEmpleados.setItems(objEmp.Consultar());
    }
}
