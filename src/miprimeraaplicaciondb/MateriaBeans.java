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
public class MateriaBeans {
    
    private int ID_Materia;
    private String NombreMat; 
    private String NivelMat; 
    AccesoDB db;
    
    public MateriaBeans() throws SQLException {
        db=new AccesoDB("localhost:3306","root","root","Institucion");
        db.ConectarDB();
    }
    
    public void setID_Materia(int ID_Materia){
        this.ID_Materia = ID_Materia;
    }
    
    public void setNombreMat(String NombreMat){
        this.NombreMat = NombreMat;
    }
    
    public void setNivelMat(String NivelMat){
        this.NivelMat = NivelMat;
    }
    
    public int getID_Materia(){
        return ID_Materia;
    }
    
    public String getNombreMat(){
        return NombreMat;
    }
    
    public String getNivelMat(){
        return NivelMat;
    }
  
        public int Incremento_Materia() throws SQLException {
        int inc = 0;
        ResultSet rs;
        rs = db.ConsultaDB("SELECT MAX(ID_Materia) AS num FROM Materia;");
        if (rs.next()) {
            inc = rs.getInt("num") + 1;
        } else {
            inc = 1;
        }
        return inc;
    }
    
    public void Insertar_Materia() throws SQLException {
        String cadena = "INSERT INTO Materia VALUES ('" + Incremento_Materia() + "', '" + getNombreMat() + "', '" + getNivelMat() + "')";
        db.ActualizarDB(cadena);
    }
    public void Actualizar_Materia(){
        
    }
    
    public void Eliminar_Materia(){
        
    }
    public ResultSet ConsultarTabla(String sql)throws SQLException{
        return db.ConsultaDB(sql);

    }
    
    public void Consultar_Materia() throws SQLException {
    ResultSet rs;
    rs = db.ConsultaDB("SELECT * FROM Materia");
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
