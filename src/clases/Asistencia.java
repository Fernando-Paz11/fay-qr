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
import net.glxn.qrgen.QRCode;

/**
 *
 * @author Yair
 */
public class Asistencia {
    
     Conexion conBD= new Conexion("localhost", "root", "","bd_fayqr");
    
     private List<String[]> consultarasistencia () {
        List<String[]> asistencia = new ArrayList<>();
        String query = "SELECT al.nombre_completo, ev.nombre, ev.fecha FROM alumno al, evento ev, asistencia asi WHERE al.id_alumno=asi.id_alumno";
        conBD.conectar();
        Statement sql=conBD.smtSQL(); //variable que permitira ejecutar una consulta
       
         try {
            ResultSet rs = sql.executeQuery(query); //resulset es para variables que almaceanaran un conjunto de registros
            while (rs.next()) {
                String[] registros = new String[3];
                registros[1] = rs.getString("nombre_completo");
                registros[2] = rs.getString("nombre");
                registros[3] = rs.getString("fecha");
                
                asistencia.add(registros);
            }
            return asistencia;  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
           return null;
        }
     }        
         public ResultSet consultarasistenciaRS() {
        String query =  "SELECT al.nombre_completo, ev.nombre, ev.fecha FROM alumno al, evento ev, asistencia asi WHERE al.id_alumno=asi.id_alumno";
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
}
   