package com.example.tap2024.Componentes;

import com.example.tap2024.Modelos.Empleados_DAO;
import com.example.tap2024.Vistas.EmpleadosForm;
import javafx.scene.control.*;

import java.util.Optional;

public class ButtonCell extends TableCell<Empleados_DAO, String> {
    Button btnCelda;
    int opc;
    Empleados_DAO objEmp;

    public ButtonCell(int opc) {
        this.opc = opc;
        String txtButton = (opc == 1) ? "Editar" : "Eliminar";
        btnCelda = new Button(txtButton);
        btnCelda.setOnAction(event -> AccionBoton(opc));
    }

    private void AccionBoton(int opc) {
        TableView<Empleados_DAO> tbvEmpleados = ButtonCell.this.getTableView();
        objEmp = tbvEmpleados.getItems().get(ButtonCell.this.getIndex());
        if (opc == 1) {
            new EmpleadosForm(tbvEmpleados, objEmp);
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Mensaje del sistema");
            alert.setHeaderText("Confirmación de acción");
            alert.setContentText("¿Deseas borrar el empleado?" + objEmp.getNombre_empleado());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                objEmp.Eliminar();
                tbvEmpleados.setItems((objEmp.Consultar()));
                tbvEmpleados.refresh();
            }
        }
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            this.setGraphic(btnCelda);
        }
    }
}
