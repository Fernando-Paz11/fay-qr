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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Yair
 */
public class Evento {
    private int id_evento;
    private String nombre_completo;
    private String usuario;
    private String tipo_usuario;
    private String telefono;
    private String correo;
    private String contraseña;
    //private FileInputStream foto;
    
    Conexion conBD= new Conexion("localhost", "root", "","bd_fayqr");
    
    //Constructor por defecto
    public Evento(){
        this.id_evento=0;
        this.nombre_completo="";
        this.usuario="";
        this.tipo_usuario="";
        this.telefono="";
        this.correo="";
        this.contraseña="";
       
    }
   
    //Constrluctor que recibe parametros
    public Evento(int id_usuario,String clave,String nombre_completo,String usuario,String tipo_usuario,String correo,String telefono,String contraseña){
        
        this.id_usuario=id_usuario;
        this.clave=clave;
        this.nombre_completo=nombre_completo;
        this.usuario=usuario;
        this.tipo_usuario=tipo_usuario;
        this.telefono=telefono;
        this.correo=correo;
        this.contraseña=contraseña;
        //this.foto=foto;
    }
   
    //TAREA HACER SETs/GETs
    public void setIdUsuario(int id_usuario){
           this.id_usuario=id_usuario;
    }
    
    public void setClave(String clave){
        this.clave=clave;
    }
   
    public void setNombreCompleto(String nombre_completo){
           this.nombre_completo=nombre_completo;
    }
    
    public void setUsuario(String usuario){
        this.usuario=usuario;
    }
   
    public void setTipoUsuario(String tipo_usuario){
           this.tipo_usuario=tipo_usuario;
    }
   
    public void setTelefono(String telefono){
           this.telefono=telefono;
    }
   
    public void setCorreo(String correo){
           this.correo=correo;
    }
    
    public void setContraseña(String contraseña){
           this.contraseña=contraseña;
    }
    
    
    public int getIdUsuario(){
        return this.id_usuario;
    }
    
    public String getClave(){
        return this.clave;
    }
   
    public String getNombreCompleto(){
        return this.nombre_completo;
    }
    
    public String getUsuario(){
        return this.usuario;
    }
   
    public String getTipoUsuario(){
        return this.tipo_usuario;
    }
   
    public String getTelefono(){
        return this.telefono;
    }
   
    public String getCorreo(){
        return this.correo;
    }
    
    public String getContraseña(){
        return this.contraseña;
    }
   
    /*public FileInputStream getFoto() {
        return foto;
    }

    public void setFoto(FileInputStream foto) {
        this.foto = foto;
    }*/
   
    //METODO INSERTAR
    public boolean insertarUsuario() throws SQLException{
        String query;
        boolean respuesta=false;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
       
        query = "INSERT INTO registro_usuario (clave, usuario, nombre_completo, tipo_usuario, correo, telefono, contraseña) "
             + "VALUES ('"+getClave()+"', '"+getUsuario()+"', '"+ getNombreCompleto()+"', '"+ getTipoUsuario()+"', '"+getCorreo()+"', '"+getTelefono() +"', '"+getContraseña()+"');";
       
        //EJECUTAR LA CONSULTA
        if (sql.executeUpdate(query)>0) {
            respuesta= true;
        }
        conBD.desconectar();
        return respuesta;
    }
   
    //Metodo para buscar un registro
     public String[] buscarUsuario(int id_usuario) throws SQLException {
        String query;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
        ResultSet rs=null;
        String[] registro = new String[7];
        query = "SELECT * FROM registro_usuario WHERE id_usuario ='" + id_usuario + "'";
       
        //System.out.println(query);
        try{
            rs=sql.executeQuery(query);
            if (rs.next()) {
                registro[0] = rs.getString("id_usuario");
                registro[1] = rs.getString("clave");
                registro[2] = rs.getString("nombre_completo");
                registro[3] = rs.getString("tipo_usuario");
                registro[4] = rs.getString("telefono");
                registro[5] = rs.getString("correo");
                registro[6] = rs.getString("contraseña");
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
        query="UPDATE registro_usuario\n" +
                " clave='"+getClave()+"'," +
                " SET nombre_completo='"+getNombreCompleto()+"'," +
                " tipo_usuario='"+getTipoUsuario()+"'," +
                " telefono='"+getTelefono()+"'," +
                " correo='"+getCorreo()+"'," +
                " contrseña='"+getContraseña()+"'," +
                " WHERE id_usuario="+getIdUsuario()+";";
       
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
    public boolean eliminarUsuario(int id_usuario) throws SQLException{
        boolean respuesta;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
       
        String query="DELETE FROM registro_usuario WHERE id_usuario="+id_usuario+";";
       
        try{            
            sql.execute(query);
            respuesta=true;
            autonumericoIdUsuario();
        }catch (SQLException e) {
            respuesta=false;
            System.out.println(e.getMessage());
        }
        conBD.desconectar();
        return respuesta;
    } 
    
    //Metodo para buscar un registrodevuelve un resulset
    public ResultSet buscarUsuarioRS(int id_usuario) throws SQLException {
        String query;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
        ResultSet rs=null;
        query = "SELECT * FROM registro_usuario WHERE id_usuario ='" + id_usuario + "'";
       
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
    public int validarUsuario(String usuario, String contraseña) throws SQLException{
        int id=0;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
        ResultSet rs=null;
        String query="SELECT id_usuario FROM registro_usuario WHERE usuario =? AND contraseña=?";
        try{
            rs=sql.executeQuery(query);
            id=rs.getInt("id_usuario");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return id;
    }
   
    //Metodo para inicializar a id_usuario
    public boolean autonumericoIdUsuario() throws SQLException{
        boolean respuesta;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
       
        String query="ALTER TABLE registro_usuario AUTO_INCREMENT=1;";
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
    private List<String[]> consultarUsuarios() {
        List<String[]> usuarios = new ArrayList<>();
        String query = "SELECT * FROM registro_usuario";
        conBD.conectar();
        Statement sql=conBD.smtSQL(); //variable que permitira ejecutar una consulta
       
         try {
            ResultSet rs = sql.executeQuery(query); //resulset es para variables que almaceanaran un conjunto de registros
            while (rs.next()) {
                String[] registros = new String[7];
                registros[0] = rs.getString("id_usuario");
                registros[1] = rs.getString("clave");
                registros[2] = rs.getString("nombre_completo");
                registros[3] = rs.getString("tipo_usuario");
                registros[4] = rs.getString("telefono");
                registros[5] = rs.getString("correo");
                registros[6] = rs.getString("contraseña");
                usuarios.add(registros);
            }
            return usuarios;  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
           return null;
        }
    }
   
    public ResultSet consultarUsuariosRS() {
        String query = "SELECT * FROM registro_usuario";
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
        List<String[]> usuarios = consultarUsuarios();
        for (String[] data : usuarios) {
             System.out.print(data[0] + " , " + data[1]+ " , " + data[2]+ " , " + data[3]+ " , " + data[4]+ " , " + data[5]+" , "+data[6]+"\n");
        }  
       
    }
    
}
