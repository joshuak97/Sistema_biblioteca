/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Conexion.Conexion;
import Logica.Libros;
import Logica.Linventario;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Dlibros {
       
       public static Conexion cc = new Conexion();
       Connection cn = cc.conectar();
       int totalLibros=0;
       //Variables boolean que validara si un libro fue registrado:
       boolean validarRegistoLibro=false;
       boolean validarRegistroEjemplar=false;
       public Dlibros(){
       
       }
   
       
       public DefaultTableModel mostrarLibros(){
       
       totalLibros=0;
       String titulos[]={"Folio","Titulo","Autor","ISBN","Editorial","Edición","Area","Estado","Disponibilidad"};
       DefaultTableModel modelo=new DefaultTableModel(null,titulos);
       try{
       String sql="SELECT id_unico,titulo,autor,isbn,editorial,edicion,nombre_area,estadoLibro,disponibilidad FROM inventario_Libros inner join Libro on inventario_Libros.libro_id=Libro.libro_id inner join Areas on Libro.area_id=Areas.area_id WHERE estadoLibro!='BAJA' ORDER BY id_unico asc";
       String datos[]=new String[9];
       
       PreparedStatement pst= (PreparedStatement) cn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                datos[0]=rst.getString("id_unico");
                datos[1]=rst.getString("titulo");
                datos[2]=rst.getString("autor");
                datos[3]=rst.getString("isbn");
                datos[4]=rst.getString("editorial");
                datos[5]=rst.getString("edicion");
                datos[6]=rst.getString("nombre_area");
                datos[7]=rst.getString("estadoLibro");
                datos[8]=rst.getString("disponibilidad");
                modelo.addRow(datos);
                totalLibros++;
            }
    }catch(SQLException ex){
      JOptionPane.showMessageDialog(null,"Error al realizar la consulta "+ex,"ERROR", JOptionPane.ERROR_MESSAGE);   
    }
     return modelo;      
       
       }
       
    public DefaultTableModel consultar(String consulta,String atributo){

     try{
     String sql="Select id_unico,titulo,autor,isbn,editorial,edicion,nombre_area,estadoLibro,disponibilidad from inventario_Libros inner join Libro on inventario_Libros.libro_id=Libro.libro_id inner join Areas on Libro.area_id=Areas.area_id WHERE "+consulta+" like '%"+atributo+"%' AND estadoLibro!='BAJA' ORDER BY titulo asc";
     String titulos[]= {"Folio","Titulo","Autor","ISBN","Editorial","Edicion","Area","Estado","Disponibilidad"};
     Object datos[]=new Object[8];
     DefaultTableModel modelo=new DefaultTableModel(null,titulos);
     
     java.sql.PreparedStatement pst=cn.prepareStatement(sql);
     ResultSet rs=pst.executeQuery();
     totalLibros=0;
     
         while(rs.next()){
       
         datos[0] = rs.getString("id_unico");
         datos[1] = rs.getString("titulo");
         datos[2] = rs.getString("autor");
         datos[3] = rs.getString("isbn");
         datos[4] = rs.getString("editorial");
         datos[5] = rs.getString("edicion");
         datos[6]=rs.getString("nombre_area");
         datos[7]= rs.getString("estadoLibro");
         datos[8]=rs.getString("disponibilidad");
         totalLibros = totalLibros + 1;
         modelo.addRow(datos);
     }
     return modelo;
     }catch(SQLException s){
         JOptionPane.showMessageDialog(null,"Error al Consultar los Datos" +s,"ERROR",JOptionPane.ERROR_MESSAGE);
         
         return null;
     }
     
}
    //Este libro nos permitira añadir un nuejo Libro a la base de datos:
    public void agregarLibroNuevo(Libros l){
     
     try {
                    String sql = "insert into Libro(titulo,autor,isbn,editorial,edicion,area_id,id_documento)values"
                            + "( '"+ l.getTitulo()+"','" + l.getAutor()+"','" +l.getIsbn()+"','"+ l.getEditorial()+"','" + l.getEdicion()+
                            "','" + l.getAreaId()+"','" + l.getDocumentoId()+"')";
                Statement st= (Statement) cn.createStatement();
                st.executeUpdate(sql);
                ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/bien.png"));
                JOptionPane.showMessageDialog(null,"Se Registro Nuevo Libro","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
                this.validarRegistoLibro=true;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Error al Registrar Nuevo Libro","Error",JOptionPane.ERROR_MESSAGE);
            this.validarRegistoLibro=false;            
        }
        
    
    }
    public void agregarEjemplar(Linventario i){
    try{    
    String sql="insert into inventario_Libros(id_unico,estadoLibro,disponibilidad,libro_id) values('"+i.getIdUnico()+"','"+i.getEstado()+"','DISPONIBLE',"+i.getIdLibro()+")";
        Statement st= (Statement) cn.createStatement();
        st.executeUpdate(sql);
        this.validarRegistroEjemplar=true;
    }catch(SQLException e){
        
        JOptionPane.showMessageDialog(null,"Error al registrar Ejemplar","ERROR",JOptionPane.ERROR_MESSAGE);
        this.validarRegistroEjemplar=false;
    }
    }
   //Este metodo cambiara al estado del ejemplar al reportado que introduciremos como parametro:
   public void reporteEjemplar(String nuevoEstado,String id){
   try{
   String sql= "update inventario_Libros set estadoLibro =? WHERE id_unico=?";
   com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
   pst.setString(1,nuevoEstado);
   pst.setString(2,id);
   pst.executeUpdate();
   ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/bien.png"));
   JOptionPane.showMessageDialog(null, "Reporte Exitoso","Error",JOptionPane.INFORMATION_MESSAGE,icon);
   }catch(SQLException e){
   JOptionPane.showMessageDialog(null,"Error al reportar este Ejemplar","Error",JOptionPane.ERROR_MESSAGE);
   }
   }

   // Este metodo nos permitite cambiar el estadoLibro a "BAJA" de manera que el ejemplar ya no aparezca visible en la aplicacion.   
   public void bajaEjemplar(String id){
   try{
   String sql= "update inventario_Libros set estadoLibro =? WHERE id_unico=?";
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
   public void editarLibro(Libros u){
   try {
String sql= "update Libro set titulo=?,autor=?,isbn=?,editorial=?,edicion=?,area_id=?, id_documento=? WHERE libro_id=?";
com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
pst.setString(1, u.getTitulo());
pst.setString(2, u.getAutor());
pst.setString(3, u.getIsbn());
pst.setString(4, u.getEditorial());
pst.setString(5, u.getEdicion());
pst.setInt(6, u.getAreaId());
pst.setInt(7, u.getDocumentoId());
pst.setInt(8, u.getLibroId());

pst.executeUpdate();
ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/bien.png"));
JOptionPane.showMessageDialog(null, "Actualizacion Exitosa","Datos Guardados",JOptionPane.INFORMATION_MESSAGE,icon);
}catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Ocurrio un problema al editar los datos","Error",JOptionPane.ERROR_MESSAGE);

    }
   }
    
    public int getTotalLibros() {
        return totalLibros;
    }

    public void setTotalLibros(int totalLibros) {
        this.totalLibros = totalLibros;
    }
    public boolean isValidarRegistoLibro() {
        return validarRegistoLibro;
    }

    public void setValidarRegistoLibro(boolean validarRegistoLibro) {
        this.validarRegistoLibro = validarRegistoLibro;
    }     
    public boolean isValidarRegistroEjemplar() {
        return validarRegistroEjemplar;
    }

    public void setValidarRegistroEjemplar(boolean validarRegistroEjemplar) {
        this.validarRegistroEjemplar = validarRegistroEjemplar;
    }
}
