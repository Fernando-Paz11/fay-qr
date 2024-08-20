/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import clases.Conexion;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.glxn.qrgen.QRCode;//Genera el codigo

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
    private byte[] foto;
    
    Conexion conBD= new Conexion("localhost", "root", "","bd_fayqr");
    
    //Constructor por defecto
    public Alumnos(){    
        this.id_alumno=0;
        this.matricula="";
        this.nombre_completo="";
        this.telefono="";
        this.correo="";
        this.carrera="";
        this.foto=null;
    }
   
    //Constrluctor que recibe parametros
    public Alumnos(int id_alumno,String matricula,String nombre_completo,String correo,String telefono,String carrera,byte[] foto){
        
        this.id_alumno=id_alumno;
        this.matricula=matricula;
        this.nombre_completo=nombre_completo;
        this.telefono=telefono;
        this.correo=correo;
        this.carrera=carrera;
        this.foto=foto;
    }
   
    //TAREA HACER SETs/GETs
    public void setIdAlumno(int id_alumno){
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
    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
    public static String bytesToHexString(byte[] bytes) {
    StringBuilder hexString = new StringBuilder();
    for (byte b : bytes) {
        String hex = Integer.toHexString(0xFF & b);
        if (hex.length() == 1) {
            hexString.append('0');
        }
        hexString.append(hex);
        }
        return hexString.toString();
    }
   
    //METODO INSERTAR
   public boolean insertarAlumno() throws SQLException{
        String query;
        boolean respuesta=false;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
        System.out.println(getFoto());
        query = "INSERT INTO alumno (matricula, nombre_completo, correo, telefono, carrera, foto) "
           + "VALUES ('"+getMatricula()+"', '"+ getNombreCompleto()+"', '"+getCorreo()+"', '"+getTelefono() +"', '"+getCarrera()+"', X'"+bytesToHexString(getFoto())+"');";
        System.out.println(query);
        //EJECUTAR LA CONSULTA
        if (sql.executeUpdate(query)>0) {
            respuesta= true;
        }
        conBD.desconectar();
        return respuesta;
    }
   
    //Metodo para buscar un regist
     public String[] buscarAlumno(String matricula) throws SQLException {
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
                registro[6] = rs.getString("foto");
            }
           
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        conBD.desconectar();
        return registro;

    }

    //Metodo para actualizar un usuario
    public boolean actualizarAlumno() throws SQLException{
        String query;
        boolean respuesta=false;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
        query="UPDATE almuno\n"+
                "SET matricula ='"+getMatricula()+"',"+
                "nombre_completo ='"+getNombreCompleto()+"'"+
                "correo ='"+getCorreo()+"',"+
                "telefono ='"+getTelefono()+"',"+
                "carrera ='"+getCarrera()+"',"+
                "foto ='"+getFoto()+"'"+
                "WHERE id_alumno='"+getIdAlumno()+";";
        System.out.println(query);
       
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
    public boolean eliminarAlumno(int id_alumno) throws SQLException{
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
        List<String[]> alumno = new ArrayList<>();
        String query = "SELECT * FROM alumno";
        conBD.conectar();
        Statement sql=conBD.smtSQL(); //variable que permitira ejecutar una consulta
       
         try {
            ResultSet rs = sql.executeQuery(query); //resulset es para variables que almaceanaran un conjunto de registros
            while (rs.next()) {
                String[] registros = new String[6];
                
                registros[1] = rs.getString("matricula");
                registros[2] = rs.getString("nombre_completo");
                
                registros[5] = rs.getString("carrera");
                
                alumno.add(registros);
            }
            return alumno;  
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
    public void mostrarAlumno() {                                                  
        List<String[]> alumnos = consultarAlumno();
        for (String[] data : alumnos) {
             System.out.print(data[1]+ " , " + data[2]+ " , " + data[6]+"\n");
        }  
    }
}
