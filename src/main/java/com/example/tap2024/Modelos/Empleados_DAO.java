package com.example.tap2024.Modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.Statement;

public class Empleados_DAO {
    int id_empleado;
    String nombre_empleado;
    String rfc_empleado;
    float salario;
    String telefono;
    String direccion;

    public void Insertar() {
        String query = "INSERT INTO empleado(nombre_empleado, rfc_empleado, salario, telefono, direccion) VALUES ('" + nombre_empleado + "', '" + rfc_empleado + "', " + salario + ", '" + telefono + "', '" + direccion + "')";
        try {
            Statement stmt = Conexion.Conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Actualizar() {
        String query = "UPDATE empleado SET nombre_empleado='" + nombre_empleado + "', rfc_empleado='" + rfc_empleado + "', salario=" + salario + ", " + "telefono='" + telefono + "', direccion='" + direccion + "' WHERE id_empleado =" + id_empleado;
        try {
            Statement stmt = Conexion.Conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Eliminar() {
        String query = "DELETE FROM empleado WHERE id_empleado=" + id_empleado;
        try {
            Statement stmt = Conexion.Conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Empleados_DAO> Consultar() {
        ObservableList<Empleados_DAO> listaEmp = FXCollections.observableArrayList();
        String query = "SELECT * FROM empleado";
        try{
            Empleados_DAO objEmp;
            Statement stmt = Conexion.Conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                objEmp = new Empleados_DAO();
                objEmp.id_empleado = res.getInt("id_empleado");
                objEmp.nombre_empleado = res.getString("nombre_empleado");
                objEmp.rfc_empleado = res.getString("rfc_empleado");
                objEmp.salario = res.getFloat("salario");
                objEmp.telefono = res.getString("telefono");
                objEmp.direccion = res.getString("direccion");
                listaEmp.add(objEmp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaEmp;
    }
}
