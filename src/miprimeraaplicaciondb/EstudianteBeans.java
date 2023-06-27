/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miprimeraaplicaciondb;

import java.sql.*;
/**
 *
 * @author Usuario
 */
public class EstudianteBeans {
    private int ID_Estudiante;
    private String Cedula; 
    private String Nombre; 
    private String Apellido; 
    private String Observacion;
    AccesoDB db;


    public EstudianteBeans() throws SQLException {
        db=new AccesoDB("localhost:3306","root","root","Institucion");
        db.ConectarDB();

    }

    public void setID_Estudiante(int ID_Estudiante) {
        this.ID_Estudiante = ID_Estudiante;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public int getID_Estudiante() {
        return ID_Estudiante;
    }

    public String getCedula() {
        return Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getObservacion() {
        return Observacion;
    }
    
        public int Incremento_Estudiante() throws SQLException {
        int inc = 0;
        ResultSet rs;
        rs = db.ConsultaDB("SELECT MAX(ID_Estudiante) AS num FROM Estudiante;");
        if (rs.next()) {
            inc = rs.getInt("num") + 1;
        } else {
            inc = 1;
        }
        return inc;
    }

    public void Insertar_Estudiante() throws SQLException {
        String cadena = "INSERT INTO Estudiante VALUES ('" + Incremento_Estudiante() + "', '" + getCedula() + "', '" + getNombre() + "', '" + getApellido() + "', '" + getObservacion() + "')";
        db.ActualizarDB(cadena);
    }
    
    public void Actualizar_Estudiante(){
        
    }
    
    public void Eliminar_Estudiante(){
        
    }
    public ResultSet ConsultarTabla(String sql)throws SQLException{
        return db.ConsultaDB(sql);

    }
    
    public void Consultar_Estudiante() throws SQLException {
    ResultSet rs;
    rs = db.ConsultaDB("SELECT * FROM Estudiante");
    while (rs.next()) {
        System.out.print(rs.getInt(1) + " ");
        System.out.print(rs.getString(2) + " ");
        System.out.print(rs.getString(3) + " ");
        System.out.print(rs.getString(4) + " ");
        System.out.print(rs.getString(5) + " ");
        System.out.println("");
    }
    }
}
 