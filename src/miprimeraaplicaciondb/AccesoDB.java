/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miprimeraaplicaciondb;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class AccesoDB {
    
    private final String host;
    private final String user;
    private final String password;
    private final String db;
    
    //************ Abrir o cerrar  conexión*****************//
    
    private Connection conexion;
    private String sql;
               
    
    public AccesoDB(String host, String user, String password, String db){
        
        this.host = host;
        this.user = user;
        this.password = password;
        this.db = db;
    }
    
    public String getHost(){
        return host;
    }
    
    public String getUser(){
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getDB() {
        return db;
    }
    
public void ConectarDB() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String cadena = "jdbc:mysql://" + getHost() + "/" + getDB();
        conexion = DriverManager.getConnection(cadena, getUser(), getPassword());
        System.out.println("Conexión a la base de datos exitosa");
    } catch (ClassNotFoundException e) {
        System.out.println("Error al cargar el controlador JDBC: " + e.toString());
    } catch (SQLException e) {
        System.out.println("Error de conexión a la base de datos: " + e.toString());
    }
}

public void ActualizarDB(String sql) throws SQLException {
    try {
        Statement stm = conexion.createStatement();
        stm.executeUpdate(sql);
        System.out.println("Transacción exitosa....Commit");
    } catch (SQLException e) {
        System.out.println("Error de la transacción...RollBack" + e.toString());
    }
}

public ResultSet ConsultaDB(String sql) throws SQLException {
    ResultSet cursor;
    Statement stm = conexion.createStatement();
    cursor = stm.executeQuery(sql);
    return cursor;
}

public void CerrarDB() throws SQLException {
    conexion.close();
}
}