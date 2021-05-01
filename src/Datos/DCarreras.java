/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Conexion.Conexion;
import Logica.Lcarreras;
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
public class DCarreras {
    
    public int totalCarreras;

    
    public static Conexion cc = new Conexion();
    Connection cn = cc.conectar();
    
    public DCarreras(){
    
    }
    
     public DefaultTableModel mostrarCarreras() {
    
    ResultSet rs;
    DefaultTableModel modelo=null;  
    
    try{
    
    Object datos[]=new Object[4];
    String titulos[]={"Carrera Id","Carrera","Plantel","Modalidad"};
    String sql="SELECT carrera_id,nombre_carrera,plantel,modalidad FROM carrera WHERE estado!='BAJA'";
    modelo=new DefaultTableModel(null,titulos);     
    PreparedStatement pst=cn.prepareStatement(sql);
       rs=pst.executeQuery();
       while(rs.next()){
       datos[0]=rs.getObject("carrera_id");
       datos[1]=rs.getObject("nombre_carrera");
       datos[2]=rs.getObject("plantel");
       datos[3]=rs.getObject("modalidad");
       
       modelo.addRow(datos);
       totalCarreras++;
       }       
    
    }catch(SQLException ex){
    
   JOptionPane.showMessageDialog(null,"Error al consultar Carreras "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
   
   }
    
    return modelo;    
    }
     
    public void agregarCarreras(Lcarreras l){
     
        try{
        String sql="INSERT INTO carrera(nombre_carrera,plantel,modalidad,estado) VALUES('"+l.getNombreCarrera()+"','"+l.getPlantel()+"','"+l.getModalidad()+"','"+l.getEstado()+"')";
        Statement st=cn.createStatement();
        st.executeUpdate(sql);
        ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/bien.png"));
        JOptionPane.showMessageDialog(null,"Se Registro Nueva Carrera","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error al Registrar Nueva Carrera "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    public void editarCarreras(Lcarreras l){
    
    try{
        String sql="UPDATE carrera SET nombre_carrera=?, plantel=?, modalidad=? WHERE carrera_id=?";
        PreparedStatement pst=cn.prepareStatement(sql);
        pst.setString(1,l.getNombreCarrera());
        pst.setString(2,l.getPlantel());
        pst.setString(3, l.getModalidad());
        pst.setInt(4, l.getCarreraId());
        pst.executeUpdate();
        ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/bien.png"));
        JOptionPane.showMessageDialog(null,"Carrera Actualizada","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error al Editar Carrera "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }    
        
    }
    public void bajaCarrera(int carreraId){
    
    try{
        String sql="UPDATE carrera set estado=? Where carrera_id=?";
        PreparedStatement pst=cn.prepareStatement(sql);
        pst.setString(1,"BAJA");
        pst.setInt(2,carreraId);
        pst.executeUpdate();
        ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/bien.png"));
        JOptionPane.showMessageDialog(null,"La Carrera "+carreraId+" ha sido Dada de baja","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error al dar de baja esta Carrera "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }    
        
    }
    
     public DefaultTableModel consultar(String consulta,String atributo){

     try{
     String sql="SELECT carrera_id,nombre_carrera,plantel,modalidad FROM carrera WHERE "+consulta+" like '%"+atributo+"%' AND estado!='BAJA' ORDER BY nombre_carrera asc";
     String titulos[]={"Carrera Id","Carrera","Plantel","Modalidad"};
     Object datos[]=new Object[4];
     DefaultTableModel modelo=new DefaultTableModel(null,titulos);
     
     java.sql.PreparedStatement pst=cn.prepareStatement(sql);
     ResultSet rs=pst.executeQuery();
    
     
         while(rs.next()){
       
         datos[0] = rs.getString("carrera_id");
         datos[1] = rs.getString("nombre_carrera");
         datos[2] = rs.getString("plantel");
         datos[3]= rs.getString("modalidad");
                         
         totalCarreras = totalCarreras + 1;
         
               
            modelo.addRow(datos);
     }
     return modelo;
     }catch(SQLException s){
         JOptionPane.showMessageDialog(null,"Error al Consultar los Datos" +s,"ERROR",JOptionPane.ERROR_MESSAGE);
         
         return null;
     }
     
} 

     public int getTotalCarreras() {
        return totalCarreras;
    }

    public void setTotalCarreras(int totalCarreras) {
        this.totalCarreras = totalCarreras;
    }
    
     
     
}
