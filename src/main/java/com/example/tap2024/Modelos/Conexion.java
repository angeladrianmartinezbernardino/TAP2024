package com.example.tap2024.Modelos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static String SERVER = "localhost";
    static private String DB = "taqueria";
    static private String USER = "jefe";
    static private String PASSWORD = "1234567890";
    static public Connection Conexion;

    public static void Crear_conexion() {
        try {
            //Class.forName("con.mysql.cj.jdbc.Driver");
            Class.forName("org.mariadb.jdbc.Driver");
            //Conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + DB + "?allowPublicKeyRetrieval=true&useSSL=false", USER, PASSWORD);
            Conexion = DriverManager.getConnection("jdbc:mariadb://" + SERVER + ":3306/" + DB, USER, PASSWORD);
            System.out.println("¡Conexión establecida con éxito!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
