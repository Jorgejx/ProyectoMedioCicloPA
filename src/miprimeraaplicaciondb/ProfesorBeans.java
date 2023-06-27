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
public class ProfesorBeans {
    private int ID_Profesor;
    private String Cedula; 
    private String Nombre; 
    private String Apellido; 
    private String Telefono;
    AccesoDB db;

    public ProfesorBeans() throws SQLException {
        db = new AccesoDB("localhost:3306", "root", "root", "Institucion");
        db.ConectarDB();
    }

    public void setID_Profesor(int ID_Profesor) {
        this.ID_Profesor = ID_Profesor;
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

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public int getID_Profesor() {
        return ID_Profesor;
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

    public String getTelefono() {
        return Telefono;
    }

    public int Incremento_Profesor() throws SQLException {
        int inc = 0;
        ResultSet rs;
        rs = db.ConsultaDB("SELECT MAX(ID_Profesor) AS num FROM Profesor;");
        if (rs.next()) {
            inc = rs.getInt("num") + 1;
        } else {
            inc = 1;
        }
        return inc;
    }

    public void Insertar_Profesor() throws SQLException {
        String cadena = "INSERT INTO Profesor VALUES ('" + Incremento_Profesor() + "', '" + getCedula() + "', '" + getNombre() + "', '" + getApellido() + "', '" + getTelefono() + "')";
        db.ActualizarDB(cadena);
    }

    public void Actualizar_Profesor() {
        // Implementar lógica de actualización del profesor
    }

    public void Eliminar_Profesor() {
        // Implementar lógica de eliminación del profesor
    }

    public ResultSet ConsultarTabla(String sql) throws SQLException {
        return db.ConsultaDB(sql);
    }

    public void Consultar_Profesor() throws SQLException {
        ResultSet rs;
        rs = db.ConsultaDB("SELECT * FROM Profesor");
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
