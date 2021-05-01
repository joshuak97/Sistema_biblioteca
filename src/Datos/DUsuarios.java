/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Conexion.Conexion;
import Logica.Lusuarios;
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
public class DUsuarios {

    public int totalUsuarios;

    public static Conexion cc = new Conexion();
    Connection cn = cc.conectar();
    
    
    public DefaultTableModel mostrarUsuarios() {
    ResultSet rs;
    DefaultTableModel modelo=null;  
    try{
    Object datos[]=new Object[11];
    String titulos[]={"Id Usuario:","Nombre","Ap. Paterno","Ap. Materno","Usuario","Contraseña","Correo","Telefono","Perfil","Pregunta de S","Respuesta"};
    String sql="SELECT idusuario,nombre,apaterno,amaterno,usuario,contrasena,correo,telefono,perfil,preguntadeseguridad,respuestaps FROM usuarios WHERE estado!='BAJA' AND perfil!='ADMINISTRADOR'";
    modelo=new DefaultTableModel(null,titulos);     
    PreparedStatement pst=cn.prepareStatement(sql);
       rs=pst.executeQuery();
       while(rs.next()){
       datos[0]=rs.getObject("idusuario");
       datos[1]=rs.getObject("nombre");
       datos[2]=rs.getObject("apaterno");
       datos[3]=rs.getObject("amaterno");
       datos[4]=rs.getObject("usuario");
       datos[5]=rs.getObject("contrasena");
       datos[6]=rs.getObject("correo");
       datos[7]=rs.getObject("telefono");
       datos[8]=rs.getObject("perfil");
       datos[9]=rs.getObject("preguntadeseguridad");
       datos[10]=rs.getObject("respuestaps");
      
       
       modelo.addRow(datos);
       totalUsuarios++;
       }
       
       
    
    }catch(SQLException ex){
    
   JOptionPane.showMessageDialog(null,"Error al consultar el prestamo "+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
    }
   
    
    return modelo;    
    }
    
    public boolean consultarUsuario(String usuario){
    boolean e=true;
    try{
    String sql = "SELECT usuario FROM usuarios WHERE usuario = '" + usuario + "' AND estado!='BAJA'";
            java.sql.Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()) {
              e=false; 
            }
    }catch(SQLException ex){
     JOptionPane.showMessageDialog(null,"No se pudo verificar la existencia del usuario "+ex);
    }
    
    return e;
    }
    
    public DefaultTableModel consultar(String consulta,String atributo){

     try{
     String sql="SELECT idusuario,nombre,apaterno,amaterno,usuario,contrasena,correo,telefono,perfil,preguntadeseguridad,respuestaps FROM usuarios WHERE "+consulta+" like '%"+atributo+"%' AND estado!='BAJA' AND perfil!='ADMINISTRADOR' ORDER BY nombre asc";
     String titulos[]={"Id Usuario:","Nombre","Ap. Paterno","Ap. Materno","Usuario","Contraseña","Correo","Telefono","Perfil","Pregunta de S","Respuesta"};
     Object datos[]=new Object[11];
     DefaultTableModel modelo=new DefaultTableModel(null,titulos);
     
     java.sql.PreparedStatement pst=cn.prepareStatement(sql);
     ResultSet rs=pst.executeQuery();
     totalUsuarios=0;
     
         while(rs.next()){
       
         datos[0] = rs.getString("idusuario");
         datos[1] = rs.getString("nombre");
         datos[2] = rs.getString("apaterno");
         datos[3] = rs.getString("amaterno");
         datos[4] = rs.getString("usuario");
         datos[5] = rs.getString("contrasena");
         datos[6]=rs.getString("correo");
         datos[7]=rs.getString("telefono");
         datos[8]=rs.getString("perfil");
         datos[9]=rs.getString("preguntadeseguridad");
         datos[10]=rs.getString("respuestaps");
                 
         totalUsuarios = totalUsuarios + 1;
         
               
            modelo.addRow(datos);
     }
     return modelo;
     }catch(SQLException s){
         JOptionPane.showMessageDialog(null,"Error al Consultar los Datos" +s,"ERROR",JOptionPane.ERROR_MESSAGE);
         
         return null;
     }
     
}
    
    public int getTotalUsuarios() {
        return totalUsuarios;
    }

    public void setTotalUsuarios(int totalUsuarios) {
        this.totalUsuarios = totalUsuarios;
    }
    
    public void agregarUsuario(Lusuarios x) {
      try {
                    String sql = "insert into usuarios(nombre,apaterno,amaterno,usuario,contrasena,correo,telefono,perfil,preguntadeseguridad,respuestaps,estado)values"
                            + "( '"+ x.getNombre()+"','" + x.getaPaterno()+"','" +x.getaMaterno()+"','"+ x.getUsuario()+"','" + x.getClave()+"','" + x.getCorreo()+"','"+x.getTelefono()+"','"+x.getPerfil()+"','"+x.getPreguntaSeguridad()+"','"+x.getRespuestaPS()+"','ALTA')";
                Statement st= (Statement) cn.createStatement();
                st.executeUpdate(sql);
                ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/bien.png"));
                JOptionPane.showMessageDialog(null,"Se Registro Nuevo Usuario","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
           
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Error al Registrar Nuevo Usuario","Error",JOptionPane.ERROR_MESSAGE);
                    
        }   
    }

    public void editarUsuarios(Lusuarios l) {
        
   try{
   String sql= "update usuarios set nombre=?, apaterno=?, amaterno=?,usuario=?,contrasena=?,correo=?,telefono=?,perfil=?,preguntadeseguridad=?,respuestaps=? WHERE idUsuario=?";
   com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
   pst.setString(1,l.getNombre());
   pst.setString(2, l.getaPaterno());
   pst.setString(3,l.getaMaterno());
   pst.setString(4,l.getUsuario());
   pst.setString(5, l.getClave());
   pst.setString(6,l.getCorreo());
   pst.setString(7, l.getTelefono());
   pst.setString(8, l.getPerfil());
   pst.setString(9, l.getPreguntaSeguridad());
   pst.setString(10, l.getRespuestaPS());
   pst.setInt(11, l.getIdUsuario());
   pst.executeUpdate();
   ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/bien.png"));
   JOptionPane.showMessageDialog(null, "Actualizacion Exitosa","Error",JOptionPane.INFORMATION_MESSAGE,icon);
   }catch(SQLException e){
   JOptionPane.showMessageDialog(null,"Error al Actualizar Usuario"+e,"Error",JOptionPane.ERROR_MESSAGE);
   }
      
    
    }
    
    public void bajaUsuarios(int id){
   try{
   String sql= "update usuarios set estado =? WHERE idUsuario=?";
   com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
   pst.setString(1,"BAJA");
   pst.setInt(2,id);
   pst.executeUpdate();
   ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/bien.png"));
   JOptionPane.showMessageDialog(null, "Actualizacion Exitosa","Error",JOptionPane.INFORMATION_MESSAGE,icon);
   }catch(SQLException e){
   JOptionPane.showMessageDialog(null,"Error al dar de baja este Usuario","Error",JOptionPane.ERROR_MESSAGE);
   }
   }
    }
    

