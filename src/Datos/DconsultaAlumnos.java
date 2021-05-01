/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */



public class DconsultaAlumnos {
     public static Conexion cc = new Conexion();
    static Connection cn = cc.conectar();
  
    int totalRegistros=1;

   

    

    public int getTotalRegistros() {
        return totalRegistros;
    }

    public void setTotalRegistros(int totalRegistros) {
        this.totalRegistros = totalRegistros;
    }
    //Este metodo nos ayudará a ejecutar la consulta a la base de datos: 
    public ResultSet visualizar(){
        
    ResultSet rst=null;
    try{
        
        PreparedStatement pst=cn.prepareStatement("Select no_control,nombre,apellidoP,apellidoM,telefono,email,semestre,nombre_carrera,modalidad,plantel from Alumno inner join Carrera on Alumno.carrera_id=Carrera.carrera_id WHERE estadoAlumno!='BAJA'");
        rst=pst.executeQuery();
    }catch(SQLException ex){
    JOptionPane.showMessageDialog(null,"Error de Consulta","ERROR",JOptionPane.ERROR_MESSAGE);
    
    }    
    return rst;
    }
    
    public DefaultTableModel mostrarAlumnos(){
     String foto="";
     ResultSet rs=visualizar();
     String titulos[]= {"No.Control","Nombre","Telefono","Correo","Semestre","Ingeniería","Sistema","Plantel"};
     Object datos[]=new Object[8];
     DefaultTableModel modelo=new DefaultTableModel(null,titulos);
     totalRegistros=0;
     try{
     while(rs.next()){
         
         datos[0] = rs.getString("no_control");
         datos[1] = rs.getString("nombre")+" "+rs.getString("apellidoP")+" "+rs.getString("apellidoM");
         datos[2] = rs.getString("email");
         datos[3] = rs.getString("telefono");
         datos[4] = rs.getInt("semestre");
         String carrera = rs.getString("nombre_carrera");
         
         if(carrera.equals("INGENIERIA EN SISTEMAS COMPUTACIONALES")){
         datos[5]="SISTEMAS";
         }
         if(carrera.equals("INGENIERIA INDUSTRIAL")){
         datos[5]="INDUSTRIAL";
         }
         if(carrera.equals("INGENIERIA EN ADMINISTRACION")){
         datos[5]="ADMINISTRACION";
         }if(carrera.equals("INGENIERIA INDUSTRIAS ALIMENTARIAS")){
         datos[5]="ALIMENTOS";
         }if(carrera.equals("INGENIERIA AMBIENTAL")){
         datos[5]="AMBIENTAL";
         }if(carrera.equals("INGENIERIA EN TECNOLOGIAS DE LA INFORMACION Y COMUNICACIONES")){
         datos[5]="TIC'S";
         }         
         datos[6] = rs.getString("modalidad");
         datos[7] =rs.getString("plantel");
         
         totalRegistros = totalRegistros + 1;
               
            modelo.addRow(datos);
     }
     return modelo;
     }catch(SQLException s){
         JOptionPane.showMessageDialog(null,"Error al Consultar los Datos","ERROR",JOptionPane.ERROR_MESSAGE);
         
         return null;
     }
    }
    
    
    public DefaultTableModel consultar(String consulta,String atributo){

     try{
     String sql="Select no_control,nombre,apellidoP,apellidoM,telefono,email,semestre,nombre_carrera,modalidad,plantel from Alumno inner join Carrera on Alumno.carrera_id=Carrera.carrera_id WHERE "+consulta+" like '%"+atributo+"%'"+" AND estadoAlumno!='BAJA'";
     String titulos[]= {"No.Control","Nombre","Telefono","Correo","Semestre","Carrera","Sistema","Plantel"};
     Object datos[]=new Object[8];
     DefaultTableModel modelo=new DefaultTableModel(null,titulos);
     
     PreparedStatement pst=cn.prepareStatement(sql);
     ResultSet rs=pst.executeQuery();
     totalRegistros=0;
         while(rs.next()){
       
       
         datos[0] = rs.getString("no_control");
         datos[1] = rs.getString("nombre")+" "+rs.getString("apellidoP")+" "+rs.getString("apellidoM");
         datos[2] = rs.getString("telefono");
         datos[3] = rs.getString("email");
         datos[4] = "    "+rs.getInt("semestre");
         String carrera = rs.getString("nombre_carrera");
         if(carrera.equals("INGENIERIA EN SISTEMAS COMPUTACIONALES")){
         datos[5]="SISTEMAS";
         }
         if(carrera.equals("INGENIERIA INDUSTRIAL")){
         datos[5]="INDUSTRIAL";
         }
         if(carrera.equals("INGENIERIA EN ADMINISTRACION")){
         datos[5]="ADMINISTRACION";
         }if(carrera.equals("INGENIERIA INDUSTRIAS ALIMENTARIAS")){
         datos[5]="ALIMENTOS";
         }if(carrera.equals("INGENIERIA AMBIENTAL")){
         datos[5]="AMBIENTAL";
         }if(carrera.equals("INGENIERIA EN TECNOLOGIAS DE LA INFORMACION Y COMUNICACIONES")){
         datos[5]="TIC'S";
         }         
         datos[6] = rs.getString("modalidad");
         datos[7] =rs.getString("plantel");
         totalRegistros = totalRegistros + 1;
         
               
            modelo.addRow(datos);
     }
     return modelo;
     }catch(SQLException s){
         JOptionPane.showMessageDialog(null,"Error al Consultar los Datos","ERROR",JOptionPane.ERROR_MESSAGE);
         
         return null;
     }
}
}
