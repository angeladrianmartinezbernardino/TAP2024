package com.example.tap2024.Modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

public class Empleados_DAO {
    private int id_empleado;
    private String nombre_empleado;
    private String rfc_empleado;
    private float salario;
    private String telefono;
    private String direccion;

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getRfc_empleado() {
        return rfc_empleado;
    }

    public void setRfc_empleado(String rfc_empleado) {
        this.rfc_empleado = rfc_empleado;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

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
        try {
            Empleados_DAO objEmp;
            Statement stmt = Conexion.Conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                objEmp = new Empleados_DAO();
                objEmp.id_empleado = res.getInt("id_empleado");
                objEmp.nombre_empleado = res.getString("nombre_empleado");
                objEmp.rfc_empleado = res.getString("rfc_empleado");
                objEmp.salario = res.getFloat("salario");
                objEmp.telefono = res.getString("telefono");
                objEmp.direccion = res.getString("direccion");
                listaEmp.add(objEmp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaEmp;
    }
}
