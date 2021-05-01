/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Logica.MainDesktopPane2;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
/**
 *
 * @author USUARIO
 */
public final class FrmPrincipalAdmin extends JFrame{    
    JMenuBar barra;
    JMenu alumnos,libros,prestamos,refrendos,multas,opciones,salir;
    JMenuItem consultaAlumnos,altaBajaAlumnos,consultaLibros,altaBajaLibros,altaBajaTesis,consultarTesis,nuevoPrestamo,consultarPrestamos,entregaLibros,nuevoRefrendo,consultarRefrendos,consultarMultas,usuarios,acercaDe,cerrarSesion,ayuda,areas,carreras,respaldos;
    int contadorAltaBajaAlumnos=0;
    MainDesktopPane2 panel;
    String user;
    
    public FrmPrincipalAdmin(String usuario){
        setTitle("BIBLIOTECA ITSAT (Administrador)");
        setSize(980,680);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        user=usuario;
        iniciar();
        
        
    }
    
    public void iniciar(){
        
        
        
        barra= new JMenuBar();
      
        alumnos=new JMenu("Alumnos");
        libros=new JMenu("Libros");
        prestamos=new JMenu("Prestamos");
        refrendos=new JMenu("Refrendos");
        multas=new JMenu("Multas");
        opciones=new JMenu("Opciones");
        salir=new JMenu("Salir");
        ayuda=new JMenuItem("Ayuda");
        altaBajaAlumnos=new JMenuItem("Alta/Baja Alumnos");
        consultaAlumnos=new JMenuItem("Consultar Alumnos");
        altaBajaLibros=new JMenuItem("Alta/Baja Libros");
        altaBajaTesis=new JMenuItem("Alta/Baja Tesis y Residencias");
        consultaLibros=new JMenuItem("Consultar Libros");
        consultarTesis=new JMenuItem("Consultar Tesis/Residencias");
        nuevoPrestamo=new JMenuItem("Nuevo Prestamo");
        consultarPrestamos=new JMenuItem("Consultar Prestamos");
        entregaLibros=new JMenuItem("Entregar Libros");
        nuevoRefrendo=new JMenuItem("Nuevo Refrendo");
        consultarRefrendos=new JMenuItem("Consultar Refrendos");
        consultarMultas=new JMenuItem("Consultar Multas");
        acercaDe=new JMenuItem("Acerca De");
        areas=new JMenuItem("Areas");
        carreras=new JMenuItem("Carreras");
        respaldos=new JMenuItem("Opciones de Respaldo");
        usuarios=new JMenuItem("Usuarios");
        cerrarSesion=new JMenuItem("Cerrar Sesión");
       
        
       Image icon = new ImageIcon(getClass().getResource("/Imagenes/iconos1.png")).getImage();
       setIconImage(icon); 
       
       ImageIcon iconAlumnos=new ImageIcon(getClass().getResource("/Imagenes/alumnos.png"));
       ImageIcon iconLibros=new ImageIcon(getClass().getResource("/Imagenes/libros.png"));
       ImageIcon iconPrestamos=new ImageIcon(getClass().getResource("/Imagenes/prestamos.png"));
       ImageIcon iconRefrendos=new ImageIcon(getClass().getResource("/Imagenes/refrendos.png"));
       ImageIcon iconMultas=new ImageIcon(getClass().getResource("/Imagenes/multas.png"));
       ImageIcon iconOpciones=new ImageIcon(getClass().getResource("/Imagenes/opciones.png"));
       ImageIcon iconSalir=new ImageIcon(getClass().getResource("/Imagenes/salir.png"));
       
       ImageIcon iconABA=new ImageIcon(getClass().getResource("/Imagenes/alumnos2.png"));
       ImageIcon iconConAlu=new ImageIcon(getClass().getResource("/Imagenes/consultaAlu.png"));
       ImageIcon iconABL=new ImageIcon(getClass().getResource("/Imagenes/ABlibro.png"));
       ImageIcon iconConLi=new ImageIcon(getClass().getResource("/Imagenes/iconConLi.png"));
       ImageIcon iconABT=new ImageIcon(getClass().getResource("/Imagenes/tesis.png"));
       ImageIcon iconConTe=new ImageIcon(getClass().getResource("/Imagenes/conTe.png"));
       ImageIcon iconNP=new ImageIcon(getClass().getResource("/Imagenes/nuevoPrestamo.png"));
       ImageIcon iconCP=new ImageIcon(getClass().getResource("/Imagenes/consPre.png"));
       ImageIcon iconEntregar=new ImageIcon(getClass().getResource("/Imagenes/lblEntregar.png"));
       ImageIcon iconNR=new ImageIcon(getClass().getResource("/Imagenes/nuevoRe.png"));
       ImageIcon iconCR=new ImageIcon(getClass().getResource("/Imagenes/consultaRe.png"));
       ImageIcon iconCM=new ImageIcon(getClass().getResource("/Imagenes/consultarMultas.png"));
       ImageIcon iconRes=new ImageIcon(getClass().getResource("/Imagenes/res2.png"));
       ImageIcon iconUsers=new ImageIcon(getClass().getResource("/Imagenes/users.png"));
       ImageIcon iconCar=new ImageIcon(getClass().getResource("/Imagenes/c.png"));
       ImageIcon iconArea=new ImageIcon(getClass().getResource("/Imagenes/areas.png"));
       ImageIcon iconAD=new ImageIcon(getClass().getResource("/Imagenes/acercaD.png"));
       ImageIcon iconAyuda=new ImageIcon(getClass().getResource("/Imagenes/ayuda.png"));
       ImageIcon iconOff=new ImageIcon(getClass().getResource("/Imagenes/off.png"));
       
       
       alumnos.setIcon(iconAlumnos);
       libros.setIcon(iconLibros);
       prestamos.setIcon(iconPrestamos);
       refrendos.setIcon(iconRefrendos);
       multas.setIcon(iconMultas);
       opciones.setIcon(iconOpciones);
       salir.setIcon(iconSalir);
       
       altaBajaAlumnos.setIcon(iconABA);
       consultaAlumnos.setIcon(iconConAlu);
       altaBajaLibros.setIcon(iconABL);
       consultaLibros.setIcon(iconConLi);
       altaBajaTesis.setIcon(iconABT);
       consultarTesis.setIcon(iconConTe);
       nuevoPrestamo.setIcon(iconNP);
       consultarPrestamos.setIcon(iconCP);
       entregaLibros.setIcon(iconEntregar);
       nuevoRefrendo.setIcon(iconNR);
       consultarRefrendos.setIcon(iconCR);
       consultarMultas.setIcon(iconCM);
       respaldos.setIcon(iconRes);
       usuarios.setIcon(iconUsers);
       carreras.setIcon(iconCar);
       areas.setIcon(iconArea);
       acercaDe.setIcon(iconAD);
       ayuda.setIcon(iconAyuda);
       cerrarSesion.setIcon(iconOff);
       
       
        altaBajaAlumnos.addActionListener((ActionEvent e) -> {
            try {
                mostrarAltaBajaAlumnos(e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmPrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });        
        consultaAlumnos.addActionListener((ActionEvent e) -> {
            try {
                consultarAlumnos(e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmPrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        altaBajaLibros.addActionListener(this::altaBajaLibros);
        
        consultaLibros.addActionListener(this::consultarLibros);
        
        altaBajaTesis.addActionListener(this::altaBajaTesis);
        
        consultarTesis.addActionListener(this::consultarTesis);
        
        nuevoPrestamo.addActionListener(this::nuevoPrestamo);
        
        consultarPrestamos.addActionListener(this::consultarPrestamos);
        
        entregaLibros.addActionListener(this::entregarLibros);
        
        nuevoRefrendo.addActionListener(this::nuevoRefrendo);
        
        consultarRefrendos.addActionListener(this::consultarRefrendos);
        
        consultarMultas.addActionListener(this::consultarMultas);
        
        respaldos.addActionListener(this::respaldos);
        
        
        
        usuarios.addActionListener((ActionEvent e) -> {
            try {
                mostrarUsuarios(e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmPrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        carreras.addActionListener(this::carreras);
        
        areas.addActionListener(this::areas);
        
        acercaDe.addActionListener(this::acercaDe);
        
        ayuda.addActionListener(this::ayuda);
        
        cerrarSesion.addActionListener(this::cerrarSesion);
        
        
        salir.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
               int i=JOptionPane.showConfirmDialog(null,"Desea Salir de la aplicación?","Confirmación",JOptionPane.YES_NO_OPTION);
        
        if(i==JOptionPane.YES_OPTION){
            
        JOptionPane.showMessageDialog(null,"Que pase bonito día¡","Gracias por su visita¡",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
        }

            }
        
        });
        
        
        
        
        alumnos.add(altaBajaAlumnos);
        alumnos.add(consultaAlumnos);
        libros.add(altaBajaLibros);
        libros.add(altaBajaTesis);
        libros.add(consultaLibros);
        libros.add(consultarTesis);
        prestamos.add(nuevoPrestamo);
        prestamos.add(consultarPrestamos);
        prestamos.add(entregaLibros);
        refrendos.add(nuevoRefrendo);
        refrendos.add(consultarRefrendos);
        multas.add(consultarMultas);
        opciones.add(respaldos);
        opciones.add(usuarios);
        opciones.add(carreras);
        opciones.add(areas);
        opciones.add(acercaDe);
        opciones.add(ayuda);
        opciones.add(cerrarSesion);
        barra.add(alumnos);
        barra.add(libros);
        barra.add(prestamos);
        barra.add(refrendos);
        barra.add(multas);
        barra.add(opciones);
        barra.add(salir);
        setJMenuBar(barra);  
        panel=new MainDesktopPane2();
        getContentPane().add(panel); 
       this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
     public void mostrarAltaBajaAlumnos(ActionEvent e) throws ClassNotFoundException{
      
         FrmAltaBajaAlumnos us=new FrmAltaBajaAlumnos();
            panel.setSize(980,610);
            panel.add(us);
            us.show();
        
  
    }  
    
     public void mostrarUsuarios(ActionEvent e) throws ClassNotFoundException{
        
         FrmUsuarios us=new FrmUsuarios();
            panel.setSize(980,610);
            panel.add(us);
            us.show();
        
  
    }
     
     public void salir(){

         this.dispose();
}
     
     public void consultarAlumnos(ActionEvent e) throws ClassNotFoundException{
        
         FrmConsultaAlumnos us=new FrmConsultaAlumnos();
            panel.setSize(980,610);
            panel.add(us);
            us.show();
        
  
    }

     
     public void altaBajaLibros(ActionEvent e){
     
         FrmAltaBajaLibros us=new FrmAltaBajaLibros();
            panel.setSize(980,610);
            panel.add(us);
            us.show();
         
     }
     
     public void consultarLibros(ActionEvent e){
     
         FrmConsultaLibros us=new FrmConsultaLibros();
            panel.setSize(980,610);
            panel.add(us);
            us.show();
         
     }
     
     public void altaBajaTesis(ActionEvent e){
     
     FrmAltaBajaTesis us=new FrmAltaBajaTesis();
            panel.setSize(980,610);
            panel.add(us);
            us.show();
         
     }
     
     public void consultarTesis(ActionEvent e){
     
         FrmConsultarTesisResidencias us=new FrmConsultarTesisResidencias();
            panel.setSize(980,610);
            panel.add(us);
            us.show();
     
     }
     
     public void nuevoPrestamo(ActionEvent e){
     
         FrmNuevoPrestamo us=new FrmNuevoPrestamo(user);
            panel.setSize(980,610);
            panel.add(us);
            us.show();
         
     }
     
     public void consultarPrestamos(ActionEvent e){
     
     FrmConsultaPrestamos us=new FrmConsultaPrestamos();
            panel.setSize(980,610);
            panel.add(us);
            us.show();
     }
     
     public void entregarLibros(ActionEvent e){
     
     EntregarLibro us=new EntregarLibro(user);
            panel.setSize(980,610);
            panel.add(us);
            us.show();
     }
     
     public void nuevoRefrendo(ActionEvent e){
     
         FrmNuevoRefrendo us=new FrmNuevoRefrendo(user);
            panel.setSize(980,610);
            panel.add(us);
            us.show();
         
     }
     
    public void consultarRefrendos(ActionEvent e){
    
        FrmConsultarRefrendos us=new FrmConsultarRefrendos();
            panel.setSize(980,610);
            panel.add(us);
            us.show();
    
    } 
    
    public void consultarMultas(ActionEvent e){
    
        FrmConsultarMultas us=new FrmConsultarMultas();
            panel.setSize(980,610);
            panel.add(us);
            us.show();
    
    }
    
    public void respaldos(ActionEvent e){
    
    FrmRespaldos us=new FrmRespaldos();
            panel.setSize(980,610);
            panel.add(us);
            us.show();
    
    }
    
    public void carreras(ActionEvent e){
    
        FrmGestionCarreras us=new FrmGestionCarreras();
            panel.setSize(980,610);
            panel.add(us);
            us.show();
    
    }
    
    public void areas(ActionEvent e){
    
        FrmGestionAreas us=new FrmGestionAreas();
            panel.setSize(980,610);
            panel.add(us);
            us.show();
    
    }
    
    public void acercaDe(ActionEvent e){
    
        AcercaDe us=new AcercaDe();
            panel.setSize(980,610);
            panel.add(us);
            us.show();
        
    
    }
    
    public void ayuda(ActionEvent e){
    
           Ayuda us=new Ayuda();
            panel.setSize(980,610);
            panel.add(us);
            us.show();
        
    }
    
    public void cerrarSesion(ActionEvent e){
    
       int i=JOptionPane.showConfirmDialog(null,"Desea cerrar sesión?","Confirmación",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION){            
       new FrmLogin().setVisible(true);
        this.dispose();
        }

        
    }
}


    

