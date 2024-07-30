/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Yair
 */
public class Conexion {
    private String usuario;
    private String password;
    private String bd;
    private String host;
    private String url;
    private Connection con = null;
    private Statement sql;
    private ResultSet rs;
   
    public Conexion(){
        this.url = "jdbc:mysql://localhost:3306/bd_fayqr";
    }
   
    public Conexion (String server, String usuario, String contraseña, String bd){
        this.usuario = usuario;
        this.password = contraseña;
        this.bd = bd;
        this.host = server;
        this.url = "jdbc:mysql://"+server+"/"+bd;
    }
   
     public Connection getCon(){
        return con;
    }
     
    public Statement smtSQL(){
        return sql; //Sentencia que permitira ejecutar una consulta mysql como insert, update,etc
    }
   
    public void conectar(){
        try {
            con = (Connection) DriverManager.getConnection(url, usuario, password);
           
            if (con != null){
                System.out.println("Conexión a base de datos "+url+" correcta.");
                sql = (Statement) con.createStatement();
            }
        }
       
        catch(SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos "+url);
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
   
    public void desconectar() throws SQLException{
        if (con != null) {
            con.close();
        }
    }
   
   
   
    //Metodo para consultar TODOS los registros de una tabla
    public ResultSet consultar(String tabla) throws SQLException{
        rs = sql.executeQuery("SELECT * FROM " + tabla);
        return rs;
    }
   
    //Metodo para ejecutar una consulta especifica
    public ResultSet consultaSQL(String query) throws SQLException{
        rs = sql.executeQuery(query);
        return rs;
    }
    
}
