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
public class Organizador {
    private int id_organizador;
    private String nombre;
    private String puesto;
    private String clave;
    private String correo;
    private String telefono;
    //private FileInputStream foto;
    
    Conexion conBD= new Conexion("localhost", "root", "","bd_fayqr");
    
    //Constructor por defecto
    public Organizador(){
       
        this.id_organizador=0;
        this.nombre="";
        this.puesto="";
        this.clave="";
        this.correo="";
        this.telefono="";
 
       
    }
   
    //Constrluctor que recibe parametros
    public Organizador(int id_organizador,String nombre,String puesto,String clave,String correo,String telefono){
        
        this.id_organizador=id_organizador;
  
        this.nombre=nombre;
        this.puesto=puesto;
        this.clave=clave; 
        this.correo=correo;
        this.telefono=telefono;
        //this.foto=foto;
    }
    public void setId_organizador(int id_organizador){   
        this.id_organizador = id_organizador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //TAREA HACER SETs/GETs
    public void setConBD(Conexion conBD) {
        this.conBD = conBD;
    }

    public int getId_organizador() {
        return id_organizador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public String getClave() {
        return clave;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public Conexion getConBD() {
        return conBD;
    }
    /*public FileInputStream getFoto() {
    return foto;
    }
    public void setFoto(FileInputStream foto) {
    this.foto = foto;
    }*/
    //METODO INSERTAR
    public boolean insertarOrganizador() throws SQLException {
        String query;
        boolean respuesta=false;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
       
        query = "INSERT INTO organizador (nombre,puesto,clave,correo, telefono) "
                + "VALUES ('"+getNombre()+"', '"+getPuesto()+"', '"+ getClave()+"', '"+getCorreo()+"', '"+getTelefono()+"');";
        
        //EJECUTAR LA CONSULTA
        if (sql.executeUpdate(query)>0) {
            respuesta= true;
        }
        conBD.desconectar();
        return respuesta;
    }
   
    //Metodo para buscar un registro
     public String[] buscarOrganizador(int id_organizador) throws SQLException {
        String query;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
        ResultSet rs=null;
        String[] registro = new String[7];
        query = "SELECT * FROM organizador WHERE id_organizador ='" + id_organizador + "'";
       
        //System.out.println(query);
        try{
            rs=sql.executeQuery(query);
            if (rs.next()) {
                registro[0] = rs.getString("id_organizador");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("puesto");
                registro[3] = rs.getString("clave");
                registro[4] = rs.getString("correo");
                registro[5] = rs.getString("telefono");
            }
           
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        conBD.desconectar();
        return registro;

    }

    //Metodo para actualizar un usuario
    public boolean actualizarorganizador() throws SQLException{
        String query;
        boolean respuesta=false;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
        query="UPDATE organizador\n" +
                " SET nombre='"+getNombre()+"'," +
                " puesto='"+getPuesto()+"'," +
                " clsave='"+getClave()+"'," +
                " correo='"+getCorreo()+"'," +
                " telefono='"+getTelefono()+"'," +
                " WHERE id_organizador="+getId_organizador()+";";
       
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
    public boolean eliminarorganizador(int id_organizador ) throws SQLException{
        boolean respuesta;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
       
        String query="DELETE FROM organizador WHERE id_organizador="+id_organizador+";";
       
        try{            
            sql.execute(query);
            respuesta=true;
            autonumericoIdorganizador();
        }catch (SQLException e) {
            respuesta=false;
            System.out.println(e.getMessage());
        }
        conBD.desconectar();
        return respuesta;
    } 
    
    //Metodo para buscar un registrodevuelve un resulset
    public ResultSet buscarOrganizadorRS(int id_organizador) throws SQLException {
        String query;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
        ResultSet rs=null;
        query = "SELECT * FROM organizador WHERE id_organizador ='" + id_organizador + "'";
       
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
    public boolean autonumericoIdorganizador() throws SQLException{
        boolean respuesta;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
       
        String query="ALTER TABLE organizador AUTO_INCREMENT=1;";
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
    private List<String[]> consultarorganizador() {
        List<String[]> organizador = new ArrayList<>();
        String query = "SELECT * FROM orgnizador ";
        conBD.conectar();
        Statement sql=conBD.smtSQL(); //variable que permitira ejecutar una consulta
       
         try {
            ResultSet rs = sql.executeQuery(query); //resulset es para variables que almaceanaran un conjunto de registros
            while (rs.next()) {
                String[] registros = new String[7];
                registros[0] = rs.getString("id_organizador");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("puesto");
                registros[3] = rs.getString("clave");
                registros[4] = rs.getString("correo");
                registros[5] = rs.getString("telefono");
                organizador.add(registros);
            }
            return organizador;  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
           return null;
        }
    }
   
    public ResultSet consultarorganizadorRS() {
        String query = "SELECT * FROM organizador";
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
    public void mostrarorganizador() {                                                  
        List<String[]> organizador = consultarorganizador();
        for (String[] data : organizador) {
             System.out.print(data[0] + " , " + data[1]+ " , " + data[2]+ " , " + data[3]+ " , " + data[4]+ " , " + data[5]+" , "+data[6]+"\n");
        }  
       
    }
    
}
