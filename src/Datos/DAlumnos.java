/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Conexion.Conexion;
import Logica.Lalumnos;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author USUARIO
 */
public class DAlumnos {
    
    public static Conexion cc = new Conexion();
    Connection cn = cc.conectar();
    int totalRegistros;
    String foto;
    public boolean agregarAlumno(Lalumnos u){
                try { //alumno_id,no_control,nombre,apellidoP,apellidoM,semestre,foto,eestado;
                String sql = "insert into Alumno(alumno_id,no_control,nombre,apellidoP,apellidoM,semestre,foto,telefono,email,carrera_id,estadoAlumno) values"+
                          "( '"+ u.getAlumnoId()+"','" + u.getNoControl()+"','" +u.getNombre()+"','"+ u.getaPaterno()+"','" + u.getaMaterno()+
                            "',"+u.getSemestre() +",'" +u.getFoto()+"','" + u.getTelefono()+"','" + u.getEmail()+"'," +u.getCarreraId()+",'"+u.getEstado()+"')";
                Statement st= (Statement) cn.createStatement();
                
                st.executeUpdate(sql);
                ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/bien.png"));
                JOptionPane.showMessageDialog(null,"Se Registro de Forma Correcta","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
                return true;
        } catch (SQLException e){
           JOptionPane.showMessageDialog(null,e,"ERROR",JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null,"Ha Ocurrido un error al Guardar los Datos","ERROR",JOptionPane.ERROR_MESSAGE);
        return false;
        }
                
    }
    
    public ResultSet visualizar(){
    ResultSet rst=null;
    try{
        
        PreparedStatement pst=cn.prepareStatement("Select alumno_id,no_control,nombre,apellidoP,apellidoM,foto,telefono,email,semestre,nombre_carrera,modalidad,plantel from Alumno inner join Carrera on Alumno.carrera_id=Carrera.carrera_id WHERE estadoAlumno!='BAJA' order by no_control asc");
        rst=pst.executeQuery();
    }catch(SQLException ex){
    JOptionPane.showMessageDialog(null,"Error de Consulta","ERROR",JOptionPane.ERROR_MESSAGE);
    
    }
    return rst;
    }
    
    //El metodo baja alumno permite cambiar el estado de un alumno a Baja para que este deje de aparecer en el sistema,
    //sin embargo su registro quedara marcado en la base de daros a no ser que la base  sea reiniciada:
    public void bajaAlumno(String idAlumno){
        
    try {
String sql= "update Alumno set estadoAlumno=? WHERE alumno_id=?";
com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
pst.setString(1, "BAJA");
pst.setString(2,idAlumno);
pst.executeUpdate();
ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/bien.png"));
JOptionPane.showMessageDialog(null, "Actualizacion Exitosa","Error",JOptionPane.INFORMATION_MESSAGE,icon);
}catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Ocurrio un problema al Dar de baja al Alumno","Error",JOptionPane.ERROR_MESSAGE);

    }
    }
    public void EditarAlumno(Lalumnos u){
try {
String sql= "update Alumno set no_control=?,nombre=?,apellidoP=?,apellidoM=?,semestre=?,telefono=?, email=?, carrera_id=? WHERE alumno_id=?";
com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
pst.setString(1, u.getNoControl());
pst.setString(2, u.getNombre());
pst.setString(3, u.getaPaterno());
pst.setString(4, u.getaMaterno());
pst.setInt(5, u.getSemestre());
pst.setString(6, u.getTelefono());
pst.setString(7, u.getEmail());
pst.setInt(8, u.getCarreraId());
pst.setString(9, u.getAlumnoId());
pst.executeUpdate();
ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/bien.png"));
JOptionPane.showMessageDialog(null, "Actualizacion Exitosa","Error",JOptionPane.INFORMATION_MESSAGE,icon);
}catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Ocurrio un problema al editar los datos","Error",JOptionPane.ERROR_MESSAGE);

    }
       
    

    }
    /* Este metodo se utilizara para realizar la consulta que será utilizada para visualizar en los campos de texto de la clase FrmAlumnos
    los datos completos del alumno al seleccionar */
    
    public ResultSet visualizarAlumno(String idAlumno){
    ResultSet rst=null;
    String sql="Select no_control,nombre,apellidoP,apellidoM,telefono,email,semestre,nombre_carrera,modalidad,plantel from Alumno inner join Carrera on Alumno.carrera_id=Carrera.carrera_id WHERE alumno_id='"+idAlumno+"'";
    try{
        
        java.sql.Statement s = cn.createStatement();
        rst = s.executeQuery(sql);
        
    }catch(SQLException ex){
    JOptionPane.showMessageDialog(null,"Error de Consulta","ERROR",JOptionPane.ERROR_MESSAGE);
    
    }
    return rst;
    }
     
       
    
        
    
 public DefaultTableModel mostrarAlumnos(){
     
     ResultSet rs=visualizar();
     String titulos[]= {"Alumno Id","No.Control","Nombre","Telefono","Correo","Semestre","Ingeniería","Sistema"};
     Object datos[]=new Object[8];
     DefaultTableModel modelo=new DefaultTableModel(null,titulos);
     totalRegistros=0;
     try{
     while(rs.next()){
         datos[0] = rs.getString("Alumno_id");
         datos[1] = rs.getString("no_control");
         datos[2] = rs.getString("nombre")+" "+rs.getString("apellidoP")+" "+rs.getString("apellidoM");
         datos[3] = rs.getString("telefono");
         datos[4] = rs.getString("email");
         datos[5] = rs.getInt("semestre");
         String carrera = rs.getString("nombre_carrera");
         
         if(carrera.equals("INGENIERIA EN SISTEMAS COMPUTACIONALES")){
         datos[6]="SISTEMAS";
         }
         if(carrera.equals("INGENIERIA INDUSTRIAL")){
         datos[6]="INDUSTRIAL";
         }
         if(carrera.equals("INGENIERIA EN ADMINISTRACION")){
         datos[6]="ADMINISTRACION";
         }if(carrera.equals("INGENIERIA INDUSTRIAS ALIMENTARIAS")){
         datos[6]="ALIMENTOS";
         }if(carrera.equals("INGENIERIA AMBIENTAL")){
         datos[6]="AMBIENTAL";
         }if(carrera.equals("INGENIERIA EN TECNOLOGIAS DE LA INFORMACION Y COMUNICACIONES")){
         datos[6]="TIC'S";
         }         
         datos[7] = rs.getString("modalidad");
         foto=rs.getString("foto");
         setFoto(foto);
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
     String sql="Select alumno_id,no_control,nombre,apellidoP,apellidoM,telefono,email,semestre,nombre_carrera,modalidad from Alumno inner join Carrera on Alumno.carrera_id=Carrera.carrera_id WHERE "+consulta+" like '%"+atributo+"%'"+"AND estadoAlumno!='BAJA'";
     String titulos[]= {"Alumno Id","No.Control","Nombre","Telefono","Correo","Semestre","Carrera","Sistema"};
     Object datos[]=new Object[8];
     DefaultTableModel modelo=new DefaultTableModel(null,titulos);
     
     PreparedStatement pst=cn.prepareStatement(sql);
     ResultSet rs=pst.executeQuery();
     totalRegistros=0;
         while(rs.next()){
       
         datos[0] = rs.getString("Alumno_id");
         datos[1] = rs.getString("no_control");
         datos[2] = rs.getString("nombre")+" "+rs.getString("apellidoP")+" "+rs.getString("apellidoM");
         datos[3] = rs.getString("telefono");
         datos[4] = rs.getString("email");
         datos[5] = "    "+rs.getInt("semestre");
         String carrera = rs.getString("nombre_carrera");
         if(carrera.equals("INGENIERIA EN SISTEMAS COMPUTACIONALES")){
         datos[6]="SISTEMAS";
         }
         if(carrera.equals("INGENIERIA INDUSTRIAL")){
         datos[6]="INDUSTRIAL";
         }
         if(carrera.equals("INGENIERIA EN ADMINISTRACION")){
         datos[6]="ADMINISTRACION";
         }if(carrera.equals("INGENIERIA INDUSTRIAS ALIMENTARIAS")){
         datos[6]="ALIMENTOS";
         }if(carrera.equals("INGENIERIA AMBIENTAL")){
         datos[6]="AMBIENTAL";
         }if(carrera.equals("INGENIERIA EN TECNOLOGIAS DE LA INFORMACION Y COMUNICACIONES")){
         datos[6]="TIC'S";
         }         
         datos[7] = rs.getString("modalidad");
         totalRegistros = totalRegistros + 1;
         
               
            modelo.addRow(datos);
     }
     return modelo;
     }catch(SQLException s){
         JOptionPane.showMessageDialog(null,"Error al Consultar los Datos","ERROR",JOptionPane.ERROR_MESSAGE);
         
         return null;
     }
     
}
    public int getTotalRegistros() {
        return totalRegistros;
    }
 
 public void setFoto(String foto){
   
     this.foto=foto;
     
 }
public String getFoto(){

return foto;
}
}
