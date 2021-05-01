/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Conexion.Conexion;
import Logica.Lprestamo;
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
public class Dprestamo {
       public static Conexion cc = new Conexion();
       Connection cn = cc.conectar();
       int totalPrestamos=0;
    public Dprestamo(){
    
    }

    public int getTotalPrestamos() {
        return totalPrestamos;
    }

    public void setTotalPrestamos(int totalPrestamos) {
        this.totalPrestamos = totalPrestamos;
    }
    
    
public DefaultTableModel mostrarPrestamos(){
   DefaultTableModel modelo=null;
   Object datos[]=new Object[8];
    try{
       String sql="SELECT folioP,id_unico,no_control,tipo_prestamo,fecha_prestamo,estadoP,usuario_receptor FROM prestamo INNER JOIN Alumno ON Alumno.alumno_id=Prestamo.alumno_id WHERE estadoP!='BAJA'";
       String titulos[]= {"Folio","Libro","Alumno","Tipo de Prestamo","Fecha de Prestamo","Estado","Aprueba:","Recargos:"};
       modelo=new DefaultTableModel(null,titulos);
       com.mysql.jdbc.PreparedStatement pst= (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
            String folio=rst.getString("folioP");    
            datos[0]=folio;
            datos[1]=rst.getString("id_unico");
            datos[2]=rst.getString("no_control");
            datos[3]=rst.getString("tipo_prestamo");
            datos[4]=rst.getString("fecha_prestamo");
            datos[5]=rst.getString("estadoP");
            datos[6]=rst.getString("usuario_receptor");
            datos[7]=obtenerRecargos(folio);
            totalPrestamos++;
            modelo.addRow(datos);
            }
            }
       
    catch(SQLException ex){
      JOptionPane.showMessageDialog(null,"Error al consultar Prestamos" +ex,"ERROR", JOptionPane.ERROR_MESSAGE);   
    }
    
    
return modelo;
}    
    
public double obtenerRecargos(String folioP){
double recargos=0;

try{
       String sql="SELECT monto FROM Multas WHERE estado!='PAGADO' AND folioP='"+folioP+"'";
       com.mysql.jdbc.PreparedStatement pst= (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            if(rst.next()){
            recargos=rst.getDouble("monto");
            }
    }catch(SQLException ex){
      JOptionPane.showMessageDialog(null,"Error al consultar Recargos" +ex,"ERROR", JOptionPane.ERROR_MESSAGE);   
    }


return recargos;
}

public void agregarPrestamo(Lprestamo l){

try {
        String sql = "insert into prestamo(folioP,tipo_prestamo,fecha_prestamo,alumno_id,id_unico,usuario_receptor,estadoP)values"
               + "( '"+ l.getFolioP()+"','" + l.getTipoPrestamo()+"','" +l.getFechaPrestamo()+"','"+ l.getAlumnoId()+"','" + l.getIdUnico()+
               "','" + l.getUsuarioReceptor()+"','"+l.getEstadoP()+"')";
                Statement st= (Statement) cn.createStatement();
                st.executeUpdate(sql);
                prestarEjemplar(l.getIdUnico());
                ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/bien.png"));
                JOptionPane.showMessageDialog(null,"Se Ha Registrado Prestamo Nuevo","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
           
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Error al Realizar el Prestamo "+e,"Error",JOptionPane.ERROR_MESSAGE);
                    
        }  
      
}

public void prestarEjemplar(String idUnico){
   try{
   String sql= "update inventario_Libros set disponibilidad =? WHERE id_unico=?";
   com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
   pst.setString(1,"PRESTADO");
   pst.setString(2,idUnico);
   pst.executeUpdate();
   }catch(SQLException e){
   JOptionPane.showMessageDialog(null,"Error al prestar este Ejemplar "+e,"Error",JOptionPane.ERROR_MESSAGE);
   }
   }

public void recibirEjemplar(String idUnico){
   try{
   String sql= "update inventario_Libros set disponibilidad =? WHERE id_unico=?";
   com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
   pst.setString(1,"DISPONIBLE");
   pst.setString(2,idUnico);
   pst.executeUpdate();
   }catch(SQLException e){
   JOptionPane.showMessageDialog(null,"Error al recibir este Ejemplar "+e,"Error",JOptionPane.ERROR_MESSAGE);
   }
   }

public void liberarPrestamo(String folioP,String usuarioR){
   try{
   String sql= "update prestamo set estadoP=?, usuario_receptor=? WHERE folioP=?";
   com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
   pst.setString(1,"ENTREGADO");
   pst.setString(2,usuarioR);
   pst.setString(3,folioP);
   pst.executeUpdate();
   }catch(SQLException e){
   JOptionPane.showMessageDialog(null,"Error al recibir este Ejemplar "+e,"Error",JOptionPane.ERROR_MESSAGE);
   }
   }
  public void liberarConAdeudo(String folioP,String usuarioR){
   try{
   String sql= "update prestamo set estadoP=? WHERE folioP=?";
   com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
   pst.setString(1,"ADEUDO");
   pst.setString(2,usuarioR);
   pst.setString(3,folioP);
   pst.executeUpdate();
   }catch(SQLException e){
   JOptionPane.showMessageDialog(null,"Error al recibir este Ejemplar "+e,"Error",JOptionPane.ERROR_MESSAGE);
   }
   }
  
public boolean consultarExistencias(int libroId,String libro){
boolean g=false;
try{
       String sql="SELECT count(id_unico)FROM inventario_Libros WHERE estadoLibro!='BAJA' AND libro_id="+libroId;
       com.mysql.jdbc.PreparedStatement pst= (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            if(rst.next()){
            int existencias=rst.getInt("count(id_unico)");
            if(existencias>=2){
            g=true;                                    
            }else{
            g=false;
            JOptionPane.showMessageDialog(null,"El libro "+libro+" Solo esta disponible para consulta interna","Error de Prestamo",JOptionPane.WARNING_MESSAGE);
            }
            }
            
    }catch(SQLException ex){
      JOptionPane.showMessageDialog(null,"Error al consultar existencias" +ex,"ERROR", JOptionPane.ERROR_MESSAGE);   
    }
    
    return g;
}

public boolean verificarRecargos(String folioP){
    boolean e=false;
    try{
       String sql="SELECT folioM, monto FROM multas WHERE folioP='"+folioP+"' AND estado='ADEUDO'";
       com.mysql.jdbc.PreparedStatement pst= (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            if(rst.next()){
             JOptionPane.showMessageDialog(null,"Este prestamo posee recargos por $"+rst.getDouble("monto"),"Aviso de Multa",JOptionPane.WARNING_MESSAGE);
             e=true;
            }else{
            e=false;
            }
            
    }catch(SQLException ex){
      JOptionPane.showMessageDialog(null,"Error al Verificar recargos" +ex,"ERROR", JOptionPane.ERROR_MESSAGE);
     
    }
    return e;
}

public boolean verificarMultas(String alumnoId){
    boolean e=false;
    try{
       String sql="SELECT count(folioM) FROM multas INNER JOIN Prestamo ON multas.folioP=prestamo.folioP WHERE alumno_id='"+alumnoId+"' AND estado='ADEUDO'";
       com.mysql.jdbc.PreparedStatement pst= (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            if(rst.next()){
             int monto=rst.getInt("count(folioM)");
             if(monto>0){
             JOptionPane.showMessageDialog(null,"Este alumno posee "+monto+" recargos"+JOptionPane.ERROR_MESSAGE);
             e=true;
             }
             }
            
    }catch(SQLException ex){
      JOptionPane.showMessageDialog(null,"Error al Verificar Multas" +ex,"ERROR", JOptionPane.ERROR_MESSAGE);   
    }
    return e;
}

public int consultarNumeroPrestamos(String alumnoId){

    int e=0;
    try{
       String sql="SELECT count(alumno_id) FROM prestamo WHERE alumno_id='"+alumnoId+"' AND estadoP!='ENTREGADO'";
       com.mysql.jdbc.PreparedStatement pst= (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            if(rst.next()){
             e=rst.getInt("count(alumno_id)");
             }
            
    }catch(SQLException ex){
      JOptionPane.showMessageDialog(null,"Error al Verificar prestamos existentes del alumno" +ex,"ERROR", JOptionPane.ERROR_MESSAGE); 
      e=-1;
    }
    return e;
    
}

public DefaultTableModel consultar(String consulta,String atributo){

     try{
     String sql="Select folioP,id_unico,no_control,tipo_prestamo,fecha_prestamo,estadoP,usuario_receptor FROM Prestamo INNER JOIN Alumno ON Alumno.alumno_id=Prestamo.alumno_id WHERE "+consulta+" like '%"+atributo+"%' AND estadoP!='BAJA' ORDER BY folioP asc";
     String titulos[]= {"Folio","Libro","Alumno","Tipo de Prestamo","Fecha de Prestamo","Estado","Aprueba:","Recargos:"};
     Object datos[]=new Object[8];
     DefaultTableModel modelo=new DefaultTableModel(null,titulos);
     
     java.sql.PreparedStatement pst=cn.prepareStatement(sql);
     ResultSet rs=pst.executeQuery();
     totalPrestamos=0;
     
         while(rs.next()){
         String folio=rs.getString("folioP");
         datos[0] =folio;
         datos[1] = rs.getString("id_unico");
         datos[2] = rs.getString("no_control");
         datos[3] = rs.getString("tipo_prestamo");
         datos[4] = rs.getString("fecha_prestamo");
         datos[5] = rs.getString("estadoP");
         datos[6]=rs.getString("usuario_receptor");
         datos[7]=obtenerRecargos(folio);
         totalPrestamos++;
                  
            modelo.addRow(datos);
     }
     return modelo;
     }catch(SQLException s){
         JOptionPane.showMessageDialog(null,"Error al Consultar los Datos" +s,"ERROR",JOptionPane.ERROR_MESSAGE);
         
         return null;
     }
     
}
    public void entregar(String libroId,String usuarioR){
    
    try{
       String sql="SELECT folioP FROM prestamo WHERE id_unico='"+libroId+"' AND estadoP='ACTIVO'";
       com.mysql.jdbc.PreparedStatement pst= (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            if(rst.next()){
             String folio=rst.getString("folioP");
             if(!verificarRecargos(folio)){   
             recibirEjemplar(libroId);
             liberarPrestamo(folio,usuarioR);
             ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/bien.png"));
             JOptionPane.showMessageDialog(null,"Libro Entregado","Entrega exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
             }else{
             int pago=JOptionPane.showConfirmDialog(null,"Se ha pagado el recargo?","Confirmación",JOptionPane.YES_NO_CANCEL_OPTION);
                 switch (pago) {
                     case JOptionPane.YES_OPTION:
                         recibirEjemplar(libroId);
                         liberarPrestamo(folio,usuarioR);
                         ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/bien.png"));
                         JOptionPane.showMessageDialog(null,"Libro Entregado","Entrega exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
                         break;
                     case JOptionPane.NO_OPTION:
                         int con=JOptionPane.showConfirmDialog(null,"desea liberar con adeudo?","Confirmación",JOptionPane.YES_NO_OPTION);
                         if(con==JOptionPane.YES_OPTION){
                         recibirEjemplar(libroId);
                         liberarConAdeudo(folio,usuarioR);
                         JOptionPane.showMessageDialog(null,"Se entrega con adeudo","Entrega Realizada",JOptionPane.WARNING_MESSAGE);
                         }
                         break;
                     default:
                         break;
                 }
             }
             }else{
            JOptionPane.showMessageDialog(null,"Este libro no se encuentra prestado");
            }           
            
    }catch(SQLException ex){
      JOptionPane.showMessageDialog(null,"Error al Entregar Libro" +ex,"ERROR", JOptionPane.ERROR_MESSAGE);   
    }        
         
     }
     



public boolean validarPrestamo(String idUnico){
 boolean g=false;
 try{
       String sql="SELECT libro_id,disponibilidad FROM inventario_Libros WHERE estadoLibro!='BAJA' AND id_unico='"+idUnico+"'";
       com.mysql.jdbc.PreparedStatement pst= (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            if(rst.next()){
            int libroId=rst.getInt("libro_id");
            String estado=rst.getString("disponibilidad");
            if(!estado.endsWith("PRESTADO")){
            String libro=nombreLibro(idUnico);
            g=consultarExistencias(libroId,libro);
            }else{
            JOptionPane.showMessageDialog(null,"Este libro ya se encuentra prestado");
            }
            }
            
            
    }catch(SQLException ex){
      JOptionPane.showMessageDialog(null,"Error al Validar Prestamo" +ex,"ERROR", JOptionPane.ERROR_MESSAGE);   
    }
 
 
 return g;
}

public String nombreLibro(String idUnico){
 String libro="";
 try{
       String sql="SELECT titulo,autor,editorial,edicion FROM inventario_Libros inner join Libro on inventario_Libros.libro_id=Libro.libro_id WHERE estadoLibro!='BAJA' AND id_unico='"+idUnico+"'";
       com.mysql.jdbc.PreparedStatement pst= (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            if(rst.next()){
            libro=rst.getString("titulo")+" "+rst.getString("autor")+" "+rst.getString("editorial")+" "+rst.getString("edicion")+" Edicion";
            
            }
            
            
    }catch(SQLException ex){
      JOptionPane.showMessageDialog(null,"Error al Validar Prestamo" +ex,"ERROR", JOptionPane.ERROR_MESSAGE);   
    }
 

 return libro;
}

}
