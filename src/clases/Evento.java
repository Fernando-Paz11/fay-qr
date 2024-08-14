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
    private String fecha;
    private String nombre;
    private String hora_inicio;
    private String hora_fin;
    private String lugar;
    private String capacidad;
    //private FileInputStream foto;
    
    Conexion conBD= new Conexion("localhost", "root", "","bd_fayqr");
    
    //Constructor por defecto
    public Evento(){
        this.id_evento=0;
        this.fecha="";
        this.nombre="";
        this.hora_inicio="";
        this.hora_fin="";
        this.lugar="";
        this.capacidad="";
       
    }
   
    //Constrluctor que recibe parametros
    public Evento(int id_evento,String fecha,String nombre,String hora_inicio,String hora_fin,String lugar,String capacidad){
        
        this.id_evento=id_evento;
        this.fecha=fecha;
        this.nombre=nombre;
        this.hora_inicio=hora_inicio;
        this.hora_fin=hora_fin;
        this.lugar=lugar;
        this.capacidad=capacidad;
        //this.foto=foto;
    }
   
    //TAREA HACER SETs/GETs

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public void setConBD(Conexion conBD) {
        this.conBD = conBD;
    }

    public int getId_evento() {
        return id_evento;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public String getLugar() {
        return lugar;
    }

    public String getCapacidad() {
        return capacidad;
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
    public boolean insertarevento() throws SQLException{
        String query;
        boolean respuesta=false;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
       
        query = "INSERT INTO evento (id_evento, fecha, nombre, hora_inicio, hora_fin, lugar, capacidad) "
             + "VALUES ('"+(getId_evento())+"', '"+getFecha()+"', '"+ getNombre()+"', '"+ getHora_inicio()+"', '"+getHora_fin()+"', '"+getLugar() +"', '"+getCapacidad()+"');";
       
        //EJECUTAR LA CONSULTA
        if (sql.executeUpdate(query)>0) {
            respuesta= true;
        }
        conBD.desconectar();
        return respuesta;
    }
   
    //Metodo para buscar un registro
     public String[] buscarevento(int id_evento) throws SQLException {
        String query;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
        ResultSet rs=null;
        String[] registro = new String[7];
        query = "SELECT * FROM evento WHERE id_evento ='" + id_evento + "'";
       
        //System.out.println(query);
        try{
            rs=sql.executeQuery(query);
            if (rs.next()) {
                registro[0] = rs.getString("id_evento");
                registro[1] = rs.getString("fecha");
                registro[2] = rs.getString("nombre");
                registro[3] = rs.getString("hora_inicio");
                registro[4] = rs.getString("hora_fin");
                registro[5] = rs.getString("lugar");
                registro[6] = rs.getString("capacidad");
            }
           
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        conBD.desconectar();
        return registro;

    }

    //Metodo para actualizar un usuario
    public boolean actualizarevento() throws SQLException{
        String query;
        boolean respuesta=false;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
        query="UPDATE evento \n" +
                " SET id_evento='"+getId_evento()+"'," +
                " fecha='"+getFecha()+"'," +
                " nombre='"+getNombre()+"'," +
                " hora_inicio='"+getHora_inicio()+"'," +
                " hora_fin='"+getHora_fin()+"'," +
                " lugar='"+getLugar()+"'," +
                " capacidad='"+getCapacidad()+"'," +
                " WHERE id_evento="+getId_evento()+";";
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
    public boolean eliminarevento(int id_evento) throws SQLException{
        boolean respuesta;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
       
        String query="DELETE FROM evento WHERE id_evento="+id_evento+";";
       
        try{            
            sql.execute(query);
            respuesta=true;
            autonumericoIdevento();
        }catch (SQLException e) {
            respuesta=false;
            System.out.println(e.getMessage());
        }
        conBD.desconectar();
        return respuesta;
    } 
    
    //Metodo para buscar un registro devuelve un resulset
    public ResultSet buscareventoRS(int id_evento) throws SQLException {
        String query;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
        ResultSet rs=null;
        query = "SELECT * FROM evento WHERE id_evento ='" + id_evento + "'";
       
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
    public boolean autonumericoIdevento() throws SQLException{
        boolean respuesta;
        conBD.conectar();
        Statement sql=conBD.smtSQL();
       
        String query="ALTER TABLE evento AUTO_INCREMENT=1;";
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
    private List<String[]> consultarevento() {
        List<String[]> evento = new ArrayList<>();
        String query = "SELECT * FROM evento";
        conBD.conectar();
        Statement sql=conBD.smtSQL(); //variable que permitira ejecutar una consulta
       
         try {
            ResultSet rs = sql.executeQuery(query); //resulset es para variables que almaceanaran un conjunto de registros
            while (rs.next()) {
                String[] registros = new String[7];
                registros[0] = rs.getString("id_evento");
                registros[1] = rs.getString("fecha");
                registros[2] = rs.getString("nombre");
                registros[3] = rs.getString("hora_inicio");
                registros[4] = rs.getString("hora_fin");
                registros[5] = rs.getString("lugar");
                registros[6] = rs.getString("capacidad");
                evento.add(registros);
            }
            return evento;  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
           return null;
        }
    }
   
    public ResultSet consultareventoRS() {
        String query = "SELECT * FROM evento";
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
    public void mostrarevento() {                                                  
        List<String[]> evento = consultarevento();
        for (String[] data : evento) {
             System.out.print(data[0] + " , " + data[1]+ " , " + data[2]+ " , " + data[3]+ " , " + data[4]+ " , " + data[5]+" , "+data[6]+"\n");
        }  
       
    }
    
}