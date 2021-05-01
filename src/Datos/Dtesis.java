/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Conexion.Conexion;
import Logica.Ltesis;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class Dtesis {
   public static Conexion cc = new Conexion();
       Connection cn = cc.conectar();
       int totalTesis=0;
       
       public Dtesis(){
    
    }
          
       
    public DefaultTableModel mostrarTesis(){
       
       totalTesis=0;
       String titulos[]={"Folio","Titulo","Alumno","Obs","Carrera","Formato","Estado"};
       DefaultTableModel modelo=new DefaultTableModel(null,titulos);
       try{
       String sql="SELECT residencia_id,titulo,alumno,obs,carrera,formato_documento,estado FROM Residencias_Tesis WHERE estado!='BAJA' ORDER BY residencia_id asc";
       String datos[]=new String[7];
       
       PreparedStatement pst= (PreparedStatement) cn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                
                datos[0]=rst.getString("residencia_id");
                datos[1]=rst.getString("titulo");
                datos[2]=rst.getString("alumno");
                datos[3]=rst.getString("obs");
                datos[4]=rst.getString("carrera");
                datos[5]=rst.getString("formato_documento");
                datos[6]=rst.getString("estado");
                
                modelo.addRow(datos);
                totalTesis++;
            }
    }catch(SQLException ex){
      JOptionPane.showMessageDialog(null,"Error al realizar la consulta","ERROR", JOptionPane.ERROR_MESSAGE);   
    }
     return modelo;      
       
       }
       
    public DefaultTableModel consultar(String consulta,String atributo){

     try{
     String sql="Select residencia_id,titulo,alumno,obs,carrera,formato_documento,estado from residencias_tesis WHERE "+consulta+" like '%"+atributo+"%' AND estado!='BAJA' ORDER BY titulo asc";
     String titulos[]={"Folio","Titulo","Alumno","Obs","Carrera","Formato","Estado"};
     Object datos[]=new Object[7];
     DefaultTableModel modelo=new DefaultTableModel(null,titulos);
     
     java.sql.PreparedStatement pst=cn.prepareStatement(sql);
     ResultSet rs=pst.executeQuery();
     totalTesis=0;
     
         while(rs.next()){
       
         datos[0] = rs.getString("residencia_id");
         datos[1] = rs.getString("titulo");
         datos[2] = rs.getString("alumno");
         datos[3] = rs.getString("obs");
         datos[4] = rs.getString("carrera");
         datos[5] = rs.getString("formato_documento");
         datos[6]=rs.getString("estado");
        
               
         totalTesis = totalTesis + 1;
         
               
            modelo.addRow(datos);
     }
     return modelo;
     }catch(SQLException s){
         JOptionPane.showMessageDialog(null,"Error al Consultar los Datos" +s,"ERROR",JOptionPane.ERROR_MESSAGE);
         
         return null;
     }
     
}
    //Este libro nos permitira añadir una nueva Tesis a la base de datos:
    public void agregarTesis(Ltesis l){
     
     try {
        String sql = "insert into Residencias_Tesis(titulo,alumno,obs,carrera,formato_documento,estado,id_documento)values"
               + "( '"+ l.getTitulo()+"','" + l.getAlumno()+"','" +l.getObs()+"','"+ l.getCarrera()+"','" + l.getFormato()+
               "','" + l.getEstado()+"',2)";
                Statement st= (Statement) cn.createStatement();
                st.executeUpdate(sql);
                ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/bien.png"));
                JOptionPane.showMessageDialog(null,"Se Registro Nuevo Libro","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
           
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Error al Registrar Nueva Tesis","Error",JOptionPane.ERROR_MESSAGE);
                    
        }
        
    
    }
   
   // Este metodo nos permitite cambiar el estadoLibro a "BAJA" de manera que el ejemplar ya no aparezca visible en la aplicacion.   
   public void bajaTesis(String id){
   try{
   String sql= "update residencias_tesis set estado =? WHERE residencia_id=?";
   com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
   pst.setString(1,"BAJA");
   pst.setString(2,id);
   pst.executeUpdate();
   ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/bien.png"));
   JOptionPane.showMessageDialog(null, "Actualizacion Exitosa","Error",JOptionPane.INFORMATION_MESSAGE,icon);
   }catch(SQLException e){
   JOptionPane.showMessageDialog(null,"Error al dar de baja este Ejemplar","Error",JOptionPane.ERROR_MESSAGE);
   }
   }
  //Este metodo nos permitira editar los datos, puesto que el ejemplar no tiene tales atributos, lo que se edita es el libro en general:
 //los cambios en la informacion dicho libro se reflejaran en todos los ejemplares 
   public void editarTesis(Ltesis u){
   try {
String sql= "update residencias_tesis set titulo=?,alumno=?,obs=?,carrera=?,formato_documento=? WHERE residencia_id=?";
com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
pst.setString(1, u.getTitulo());
pst.setString(2, u.getAlumno());
pst.setString(3, u.getObs());
pst.setString(4, u.getCarrera());
pst.setString(5, u.getFormato());
pst.setInt(6, u.getTesisId());


pst.executeUpdate();
ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/bien.png"));
JOptionPane.showMessageDialog(null, "Actualizacion Exitosa","Datos editados",JOptionPane.INFORMATION_MESSAGE,icon);
}catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Ocurrio un problema al editar los datos","Error",JOptionPane.ERROR_MESSAGE);

    }
   }   
  public DefaultTableModel mostrarConsultaTesis(){
       
       totalTesis=0;
       String titulos[]={"Folio","Titulo","Alumno","Obs","Carrera","Formato"};
       DefaultTableModel modelo=new DefaultTableModel(null,titulos);
       try{
       String sql="SELECT residencia_id,titulo,alumno,obs,carrera,formato_documento FROM Residencias_Tesis WHERE estado!='BAJA' ORDER BY residencia_id asc";
       String datos[]=new String[6];
       
       PreparedStatement pst= (PreparedStatement) cn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                
                datos[0]=rst.getString("residencia_id");
                datos[1]=rst.getString("titulo");
                datos[2]=rst.getString("alumno");
                datos[3]=rst.getString("obs");
                datos[4]=rst.getString("carrera");
                datos[5]=rst.getString("formato_documento");
                
                
                modelo.addRow(datos);
                totalTesis++;
            }
    }catch(SQLException ex){
      JOptionPane.showMessageDialog(null,"Error al realizar la consulta","ERROR", JOptionPane.ERROR_MESSAGE);   
    }
     return modelo;      
       
       }
       
    public int getTotalTesis() {
        return totalTesis;
    }

    public void setTotalTesis(int totalTesis) {
        this.totalTesis = totalTesis;
    }

    public boolean isValidarRegistoTesis() {
        return validarRegistoTesis;
    }

    public void setValidarRegistoTesis(boolean validarRegistoTesis) {
        this.validarRegistoTesis = validarRegistoTesis;
    }

    public boolean isValidarRegistroEjemplar() {
        return validarRegistroEjemplar;
    }

    public void setValidarRegistroEjemplar(boolean validarRegistroEjemplar) {
        this.validarRegistroEjemplar = validarRegistroEjemplar;
    }
       //Variables boolean que validara si una Tesis fue registrado:
       boolean validarRegistoTesis=false;
       boolean validarRegistroEjemplar=false; 
}
