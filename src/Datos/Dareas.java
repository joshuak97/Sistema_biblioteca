/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Conexion.Conexion;
import Logica.Lareas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class Dareas {
    
     public int totalAreas;

    public static Conexion cc = new Conexion();
    Connection cn = cc.conectar();
    
    public DefaultTableModel mostrarAreas() {
    ResultSet rs;
    DefaultTableModel modelo=null;  
    try{
    Object datos[]=new Object[3];
    String titulos[]={"Area Id","Nombre de Area","Estado"};
    String sql="SELECT area_id,nombre_area, estado FROM areas WHERE estado!='BAJA'";
    modelo=new DefaultTableModel(null,titulos);     
    PreparedStatement pst=cn.prepareStatement(sql);
       rs=pst.executeQuery();
       while(rs.next()){
       datos[0]=rs.getObject("area_id");
       datos[1]=rs.getObject("nombre_area");
       datos[2]=rs.getObject("estado");
       
      
       
       modelo.addRow(datos);
       totalAreas++;
       }
       
       
    
    }catch(SQLException ex){
    
   JOptionPane.showMessageDialog(null,"Error al consultar Areas "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
    }
   
    
    return modelo;    
    }
    
    public void agregarArea(Lareas l){
     
        try{
        String sql="INSERT INTO areas(nombre_area,estado) VALUES('"+l.getNombreArea()+"','"+l.getEstado()+"')";
        Statement st=cn.createStatement();
        st.executeUpdate(sql);
        ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/bien.png"));
        JOptionPane.showMessageDialog(null,"Se Registro Nueva Area","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error al Registrar Nueva Area "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    public void editarArea(Lareas l){
    
    try{
        String sql="UPDATE areas set nombre_area=? Where area_id=?";
        PreparedStatement pst=cn.prepareStatement(sql);
        pst.setString(1,l.getNombreArea());
        pst.setInt(2,l.getIdArea());
        pst.executeUpdate();
        ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/bien.png"));
        JOptionPane.showMessageDialog(null,"Informacion Actualizada","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error al Editar Area "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }    
        
    }
    public void bajaArea(int areaId){
    
    try{
        String sql="UPDATE areas set estado=? Where area_id=?";
        PreparedStatement pst=cn.prepareStatement(sql);
        pst.setString(1,"BAJA");
        pst.setInt(2,areaId);
        pst.executeUpdate();
        ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/bien.png"));
        JOptionPane.showMessageDialog(null,"El Area ha sido Dada de baja","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error al dar de baja esta Area "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }    
        
    }
    
     public DefaultTableModel consultar(String consulta,String atributo){

     try{
     String sql="SELECT area_id,nombre_area,estado FROM areas WHERE "+consulta+" like '%"+atributo+"%' AND estado!='BAJA' ORDER BY nombre_area asc";
     String titulos[]={"Area Id","Nombre de Area","Estado"};
     Object datos[]=new Object[3];
     DefaultTableModel modelo=new DefaultTableModel(null,titulos);
     
     java.sql.PreparedStatement pst=cn.prepareStatement(sql);
     ResultSet rs=pst.executeQuery();
    
     
         while(rs.next()){
       
         datos[0] = rs.getString("area_id");
         datos[1] = rs.getString("nombre_area");
         datos[2] = rs.getString("estado");
                         
         totalAreas = totalAreas + 1;
         
               
            modelo.addRow(datos);
     }
     return modelo;
     }catch(SQLException s){
         JOptionPane.showMessageDialog(null,"Error al Consultar los Datos" +s,"ERROR",JOptionPane.ERROR_MESSAGE);
         
         return null;
     }
     
}
    
    public int getTotalAreas() {
        return totalAreas;
    }

    public void setTotalAreas(int totalAreas) {
        this.totalAreas = totalAreas;
    }
    
    
}
