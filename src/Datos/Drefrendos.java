/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Conexion.Conexion;
import Logica.Lrefrendo;
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
public class Drefrendos {
    
    public static Conexion cc = new Conexion();
    Connection cn = cc.conectar();
    int resultados=0;

    public int getResultados() {
        return resultados;
    }

    public void setResultados(int resultados) {
        this.resultados = resultados;
    }
    public void agregarRefrendo(Lrefrendo l){

try {
        String sql = "insert into refrendo(folioR,fecha_refrendo,folioP,usuario_receptor)values('"+l.getFolioR()+"',"
                +"'"+l.getFechaRefrendo()+"','"+l.getFolioPrestamo()+"','"+l.getUsuario()+"')";
                Statement st= (Statement) cn.createStatement();
                st.executeUpdate(sql);
                refrendarPrestamo(l.getFolioPrestamo());
                ImageIcon icon=new ImageIcon(getClass().getResource("/imagenes/bien.png"));
                JOptionPane.showMessageDialog(null,"Se Ha Registrado nuevo refrendo","Operación Exitosa",JOptionPane.INFORMATION_MESSAGE,icon);
           
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Error al agregar Prestamo "+e,"Error",JOptionPane.ERROR_MESSAGE);
                  
        }  
      
}
    
public void refrendarPrestamo(String folioP){
   try{
   String sql= "update prestamo set estadoP=? WHERE folioP=?";
   com.mysql.jdbc.PreparedStatement pst = (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
   int refrendos=verificarRefrendos(folioP);
   if(refrendos<=2){
   int refrendoActual=refrendos+1;    
   System.out.println(refrendoActual);
   pst.setString(1,"REFRENDADO");
   pst.setString(2,folioP);
   pst.executeUpdate();
   }else{
   JOptionPane.showMessageDialog(null,"El numero maximo de refrendos ha sido alcanzado, por favor de entregar el libro","No se puede refrendar",JOptionPane.ERROR_MESSAGE);
   }
   }catch(SQLException e){
   JOptionPane.showMessageDialog(null,"Error al refrendar el Prestamo "+e,"Error",JOptionPane.ERROR_MESSAGE);
   }
   }

 public int verificarRefrendos(String folioP){
 int i=0;
 try{
       String sql="SELECT count(folioR) FROM refrendo WHERE folioP='"+folioP+"'";
       com.mysql.jdbc.PreparedStatement pst= (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();           
            if(rst.next()){
                i=rst.getInt("count(folioR)");
            }
    }catch(SQLException ex){
      JOptionPane.showMessageDialog(null,"Error al Verificar refrendos" +ex,"ERROR", JOptionPane.ERROR_MESSAGE);
     
    }
 return i;
 }
     
public DefaultTableModel mostrarPrestamos(String alumnoId){
   DefaultTableModel modelo=null;
   Object datos[]=new Object[6];
   boolean prestamos=false;
    try{
       String sql="SELECT folioP,id_unico,tipo_prestamo,fecha_prestamo,usuario_receptor FROM prestamo WHERE alumno_id='"+alumnoId+"' AND estadoP!='BAJA' AND estadoP!='ENTREGADO' AND estadoP!='ADEUDO'";
       String titulos[]= {"Folio Prestamo","Libro","Tipo de Prestamo","Fecha de Prestamo","Recargos:","Aprueba:"};
       modelo=new DefaultTableModel(null,titulos);
       com.mysql.jdbc.PreparedStatement pst= (com.mysql.jdbc.PreparedStatement) cn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
            prestamos=true;
            String folio=rst.getString("folioP");    
            datos[0]=folio;
            datos[1]=rst.getString("id_unico");
            datos[2]=rst.getString("tipo_prestamo");
            datos[3]=rst.getString("fecha_prestamo");
            datos[4]=obtenerRecargos(folio);
            datos[5]=rst.getString("usuario_receptor");
            modelo.addRow(datos);
            resultados++;
            }
            System.out.println(resultados);
            if(!prestamos){
                JOptionPane.showMessageDialog(null,"El alumno no tiene prestamos pendientes");
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

  
}
