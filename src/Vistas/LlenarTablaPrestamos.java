/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Conexion.Conexion;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */

public class LlenarTablaPrestamos {
    public static Conexion cc = new Conexion();
 
    
    public boolean llenar_tabla(String idUnico,DefaultTableModel modelo, JTable tabla){
        boolean g=false;
        int numCol=2,columBoolean=3;
        try{String query="SELECT id_unico,titulo,autor,editorial,edicion from inventario_Libros inner join Libro ON inventario_Libros.libro_id=Libro.libro_id WHERE id_unico='"+idUnico+"'";
            ResultSet rs;
            rs = cc.ejecutarSQLSelect(query);
            //cantidad de columnas=2 contando la columna checkbox
            Object[] filas = new Object[numCol];
            
            while(rs.next()){
//                filas[0]=rs.getString(1);
                for(int i=1;i<=numCol;i++)
                {/*Lavariable columBoolean indica
                 * el número de columna que tendrá los checkbox
                 * es decir la booleana
                 */
                    //si i es igual a la columna checkbox
                   //if(i==columBoolean){
                        //por defecto saldrán sin seleccionar, es decir como FALSE
                     //   filas[columBoolean-1]=Boolean.TRUE;
                     if(i==2){
                        //si no rellenará la tabla con los datos normalmente
                        filas[i-1]=rs.getObject("titulo")+" "+rs.getObject("autor")+" "+rs.getObject("editorial")+" "+rs.getObject("edicion")+" Edicion";
                        g=true;
                   }else{
                       filas[i-1]=rs.getString("id_unico");
                   }
                }
                //añade las filas
                modelo.addRow(filas);
            }tabla.updateUI();//actualiza
            rs.close();
           
        }catch(SQLException | HeadlessException e)
        {System.err.println(e);}
    return g;
    }
}
