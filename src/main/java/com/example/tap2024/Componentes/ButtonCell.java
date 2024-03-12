package com.example.tap2024.Componentes;

import com.example.tap2024.Modelos.Empleados_DAO;
import com.example.tap2024.Vistas.EmpleadosForm;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;

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
