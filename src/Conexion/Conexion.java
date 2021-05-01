/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;  

public class Conexion {
boolean acceso;
private final Connection conexion=conectar();
    public Connection conectar()  {
        Connection link = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            link = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/basebiblioteca","root", "");
            acceso=true;
            
        } catch (ClassNotFoundException | SQLException e) {
           int opcion=JOptionPane.showConfirmDialog(null, "Error al Conectar con la Base de Datos, Desea ejecutar XAMPP?","ERROR",JOptionPane.YES_NO_OPTION); 
           if(opcion==JOptionPane.YES_OPTION){
           ejecutarXampp();
           }else{
           JOptionPane.showMessageDialog(null, "Error al Conectar con la Base de Datos","ERROR",JOptionPane.ERROR_MESSAGE);
           System.exit(0);
           }
           }
        
        return link;
    }

public boolean getAcceso(){

return acceso;
}

public ResultSet ejecutarSQLSelect(String sql)
    {
       ResultSet resultado;
       try {
          PreparedStatement sentencia = conexion.prepareStatement(sql);
          resultado = sentencia.executeQuery();
          return resultado;
       } catch (SQLException ex) {
          System.err.println("Error "+ex);
          return null;
       }
    }


public boolean ejecutarSQL(String sql)
    {
       try {
           PreparedStatement sentencia = conexion.prepareStatement(sql);
          sentencia.execute(sql);
          return true;
       } catch (SQLException ex) {
            return false;
       }
    }



public void ejecutarXampp(){

try 
{ 
   /* directorio/ejecutable es el path del ejecutable y un nombre */ 
   Process p = Runtime.getRuntime().exec ("C:\\xampp\\xampp-control.exe");
  acceso=true;
} 
   catch (IOException e) 
{ 
   
   JOptionPane.showMessageDialog(null, "Error al Ejecutar xampp, Favor de Ejecutar el panel de control de XAMPP ","ERROR",JOptionPane.ERROR_MESSAGE);
            acceso=false; 
}
   
    
}
    
}
