/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import clases.Conexion;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Yair
 */
public class Alumnos {
    private int id_alumno;
    private String matricula;
    private String nombre_completo;
    private String telefono;
    private String correo;
    private String carrera;
    //private FileInputStream foto;
    
    Conexion conBD= new Conexion("localhost", "root", "","bd_fayqr");
    
    //Constructor por defecto
    public Alumnos(){
       
        this.id_alumno=0;
        this.matricula="";
        this.nombre_completo="";
        this.telefono="";
        this.correo="";
        this.carrera="";
       
    }
   
    //Constrluctor que recibe parametros
    public Alumnos(int id_alumno,String matricula,String nombre_completo,String correo,String telefono,String carrera){
        
        this.id_alumno=id_alumno;
        this.matricula=matricula;
        this.nombre_completo=nombre_completo;
        this.telefono=telefono;
        this.correo=correo;
        this.carrera=carrera;
        //this.foto=foto;
    }
   
    //TAREA HACER SETs/GETs
    public void setIdUsuario(int id_alumno){
           this.id_alumno=id_alumno;
    }
    
    public void setClave(String matricula){
        this.matricula=matricula;
    }
   
    public void setNombreCompleto(String nombre_completo){
           this.nombre_completo=nombre_completo;
    }
   
    public void setTelefono(String telefono){
           this.telefono=telefono;
    }
   
    public void setCorreo(String correo){
           this.correo=correo;
    }
    
    public void setContraseña(String carrera){
           this.carrera=carrera;
    }
    
    
    public int getIdAlumno(){
        return this.id_alumno;
    }
    
    public String getMatricula(){
        return this.matricula;
    }
   
    public String getNombreCompleto(){
        return this.nombre_completo;
    }
    
    public String getTelefono(){
        return this.telefono;
    }
   
    public String getCorreo(){
        return this.correo;
    }
    
    public String getCarrera(){
        return this.carrera;
    }
   
    /*public FileInputStream getFoto() {
        return foto;
    }

    public void setFoto(FileInputStream foto) {
        this.foto = foto;
    }*/
   
    //METODO INSERTAR
    public boolean insertarAlumno() throws SQLException{
        String query;
        boolean respuesta=false;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
       
        query = "INSERT INTO alumno (matricula, nombre_completo, correo, telefono, carrera) "
             + "VALUES ('"+getMatricula()+"', '"+ getNombreCompleto()+"', '"+getCorreo()+"', '"+getTelefono() +"', '"+getCarrera()+"');";
       
        //EJECUTAR LA CONSULTA
        if (sql.executeUpdate(query)>0) {
            respuesta= true;
        }
        conBD.desconectar();
        return respuesta;
    }
   
    //Metodo para buscar un registro
     public String[] buscarUsuario(String matricula) throws SQLException {
        String query;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
        ResultSet rs=null;
        String[] registro = new String[5];
        query = "SELECT * FROM alumno WHERE matricula ='" + matricula + "'";
       
        //System.out.println(query);
        try{
            rs=sql.executeQuery(query);
            if (rs.next()) {
                registro[0] = rs.getString("id_alumno");
                registro[1] = rs.getString("matricula");
                registro[2] = rs.getString("nombre_completo");
                registro[3] = rs.getString("correo");
                registro[4] = rs.getString("telefono");
                registro[5] = rs.getString("carrera");
            }
           
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        conBD.desconectar();
        return registro;

    }

    //Metodo para actualizar un usuario
    public boolean actualizarUsuario() throws SQLException{
        String query;
        boolean respuesta=false;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
        query="UPDATE alumno\n" +
                " matricula='"+getMatricula()+"'," +
                " SET nombre_completo='"+getNombreCompleto()+"'," +
                " correo'"+getCorreo()+"'," +
                " telefono='"+getTelefono()+"'," +
                " contrseña='"+getCarrera()+"'," +
                " WHERE id_usuario="+getIdAlumno()+";";
       
         try{
            sql.execute(query);
            respuesta = true;
        }catch (SQLException e) {
            respuesta=false;
            System.out.println(e.getMessage());
        }
        conBD.desconectar();
        return respuesta;
    }
   
    //Metodo para eliminar un usuario
    public boolean eliminarUsuario(int id_alumno) throws SQLException{
        boolean respuesta;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
       
        String query="DELETE FROM alumno WHERE id_alumno="+id_alumno+";";
       
        try{            
            sql.execute(query);
            respuesta=true;
            autonumericoIdAlumno();
        }catch (SQLException e) {
            respuesta=false;
            System.out.println(e.getMessage());
        }
        conBD.desconectar();
        return respuesta;
    } 
    
    //Metodo para buscar un registrodevuelve un resulset
    public ResultSet buscarAlumnoRS(int id_alumno) throws SQLException {
        String query;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
        ResultSet rs=null;
        query = "SELECT * FROM alumno WHERE id_alumno ='" + id_alumno + "'";
       
        //System.out.println(query);
        try{
            rs=sql.executeQuery(query);
            return rs;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        conBD.desconectar();
        return rs;
    }
   
    //Metodo para inicializar a id_usuario
    public boolean autonumericoIdAlumno() throws SQLException{
        boolean respuesta;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
       
        String query="ALTER TABLE alumno AUTO_INCREMENT=1;";
        //System.out.println(query);
        try{            
            sql.execute(query);
            respuesta=true;
        }catch (SQLException e) {
            respuesta=false;
            System.out.println(e.getMessage());
        }
        conBD.desconectar();
        return respuesta;
    }
   
    //Metodo para mostrar registros
    private List<String[]> consultarAlumno() {
        List<String[]> alumnos = new ArrayList<>();
        String query = "SELECT * FROM alumno";
        conBD.conectar();
        Statement sql=conBD.smtSQL(); //variable que permitira ejecutar una consulta
       
         try {
            ResultSet rs = sql.executeQuery(query); //resulset es para variables que almaceanaran un conjunto de registros
            while (rs.next()) {
                String[] registros = new String[5];
                registros[0] = rs.getString("id_alumnp");
                registros[1] = rs.getString("matricula");
                registros[2] = rs.getString("nombre_completo");
                registros[3] = rs.getString("correo");
                registros[4] = rs.getString("telefono");
                registros[5] = rs.getString("carrera");
                alumnos.add(registros);
            }
            return alumnos;  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
           return null;
        }
    }
   
    public ResultSet consultarAlumnosRS() {
        String query = "SELECT * FROM alumno";
        conBD.conectar();
        Statement sql=conBD.smtSQL(); //variable que permitira ejecutar una consulta
       
         try {
            ResultSet rs = sql.executeQuery(query); //resulset es para variables que almaceanaran un conjunto de registros
            return rs;  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
           return null;
        }
    }
   
    //METODO MOSTRAR TABLA DE USUARIOS
    public void mostrarUsuarios() {                                                  
        List<String[]> alumnos = consultarAlumno();
        for (String[] data : alumnos) {
             System.out.print(data[0] + " , " + data[1]+ " , " + data[2]+ " , " + data[3]+ " , " + data[4]+ " , " + data[5]+"\n");
        }  
    }
}
