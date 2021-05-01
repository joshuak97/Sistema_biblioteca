package Vistas;

import Logica.MainDesktopPane;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class FrmPrincipalEncargado extends JFrame{
 
    JMenuBar barra;
    JMenu alumnos,libros,prestamos,refrendos,multas,opciones,salir;
    JMenuItem consultaAlumnos,registrarAlumnos,consultaLibros,consultarTesis,nuevoPrestamo,consultarPrestamos,entregaLibros,nuevoRefrendo,consultarRefrendos,consultarMultas,acercaDe,cerrarSesion,ayuda;
    MainDesktopPane panel;
    String user;
    
    public FrmPrincipalEncargado(String usuario){
        setTitle("BIBLIOTECA ITSAT (Encargado)");
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
        registrarAlumnos=new JMenuItem("Nuevo Alumno");
        consultaAlumnos=new JMenuItem("Consultar Alumnos");
        consultaLibros=new JMenuItem("Consultar Libros");
        consultarTesis=new JMenuItem("Consultar Tesis/Residencias");
        nuevoPrestamo=new JMenuItem("Nuevo Prestamo");
        consultarPrestamos=new JMenuItem("Consultar Prestamos");
        entregaLibros=new JMenuItem("Entregar Libros");
        nuevoRefrendo=new JMenuItem("Nuevo Refrendo");
        consultarRefrendos=new JMenuItem("Consultar Refrendos");
        consultarMultas=new JMenuItem("Consultar Multas");
        ayuda=new JMenuItem("Ayuda");
        acercaDe=new JMenuItem("Acerca De");
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
        
       ImageIcon iconConAlu=new ImageIcon(getClass().getResource("/Imagenes/consultaAlu.png")); 
       ImageIcon iconConLi=new ImageIcon(getClass().getResource("/Imagenes/iconConLi.png"));
       ImageIcon iconConTe=new ImageIcon(getClass().getResource("/Imagenes/conTe.png"));
       ImageIcon iconNP=new ImageIcon(getClass().getResource("/Imagenes/nuevoPrestamo.png"));
       ImageIcon iconCP=new ImageIcon(getClass().getResource("/Imagenes/consPre.png"));
       ImageIcon iconNR=new ImageIcon(getClass().getResource("/Imagenes/nuevoRe.png"));
       ImageIcon iconCR=new ImageIcon(getClass().getResource("/Imagenes/consultaRe.png"));
       ImageIcon iconEntregar=new ImageIcon(getClass().getResource("/Imagenes/lblEntregar.png"));
       ImageIcon iconCM=new ImageIcon(getClass().getResource("/Imagenes/consultarMultas.png"));
       ImageIcon iconAD=new ImageIcon(getClass().getResource("/Imagenes/acercaD.png"));
       ImageIcon iconAyuda=new ImageIcon(getClass().getResource("/Imagenes/ayuda.png"));
       ImageIcon iconOff=new ImageIcon(getClass().getResource("/Imagenes/off.png"));
       ImageIcon iconNA=new ImageIcon(getClass().getResource("/Imagenes/nuevoAlu.png"));
       
       
        registrarAlumnos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                nuevoAlumno(e);
            
            
            }
        });
       
       
        consultaAlumnos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {           
                    consultarAlumnos(e);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FrmPrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
            }
        });

       
        consultaLibros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                consultarLibros(e);
            
            
            }
        });
       
       
           consultarTesis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                consultarTesis(e);
            
            
            }
        });
        
        nuevoPrestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                nuevoPrestamo(e);
            
            
            }
        });
        
        consultarPrestamos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                consultarPrestamos(e);
            
            
            }
        });
        
        nuevoRefrendo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                nuevoRefrendo(e);
            
            
            }
        });
        
        consultarRefrendos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                consultarRefrendos(e);
            
            
            }
        });
        
        
        entregaLibros.addActionListener((ActionEvent e) -> {
            entregarLibros(e);
        });
        
        consultarMultas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                consultarMultas(e);
            
            
            }
        });
       
       
        acercaDe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                acercaDe(e);
            
            
            }
        });
        
        ayuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                ayuda(e);
            
            
            }
        });
        
        cerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                cerrarSesion(e);
            
            
            }
        });
       
       
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
       
       alumnos.setIcon(iconAlumnos);
       libros.setIcon(iconLibros);
       prestamos.setIcon(iconPrestamos);
       refrendos.setIcon(iconRefrendos);
       multas.setIcon(iconMultas);
       opciones.setIcon(iconOpciones);
       salir.setIcon(iconSalir);
       
       registrarAlumnos.setIcon(iconNA);
       consultaAlumnos.setIcon(iconConAlu);
       consultaLibros.setIcon(iconConLi);
       consultarTesis.setIcon(iconConTe);
       nuevoPrestamo.setIcon(iconNP);
       consultarPrestamos.setIcon(iconCP);
       nuevoRefrendo.setIcon(iconNR);
       consultarRefrendos.setIcon(iconCR);
       entregaLibros.setIcon(iconEntregar);
       consultarMultas.setIcon(iconCM);
       acercaDe.setIcon(iconAD);
       ayuda.setIcon(iconAyuda);
       cerrarSesion.setIcon(iconOff);
        
        alumnos.add(registrarAlumnos);
        alumnos.add(consultaAlumnos);
        libros.add(consultaLibros);
        libros.add(consultarTesis);
        prestamos.add(nuevoPrestamo);
        prestamos.add(consultarPrestamos);
        prestamos.add(entregaLibros);
        refrendos.add(nuevoRefrendo);
        refrendos.add(consultarRefrendos);
        multas.add(consultarMultas);
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
        panel=new MainDesktopPane();
        getContentPane().add(panel); 
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
       
    }
    
     public void nuevoAlumno(ActionEvent e) {
        
         FrmNuevoAlumno us=new FrmNuevoAlumno();
            panel.setSize(980,610);
            panel.add(us);
            us.show();
        
  
    }
    
    
    
     public void consultarAlumnos(ActionEvent e) throws ClassNotFoundException{
        
         FrmConsultaAlumnos us=new FrmConsultaAlumnos();
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
    
    public void entregarLibros(ActionEvent e){
     
     EntregarLibro us=new EntregarLibro(user);
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

