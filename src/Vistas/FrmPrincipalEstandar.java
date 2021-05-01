
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
public final class FrmPrincipalEstandar extends JFrame{
    
    JMenuBar barra;
    JMenu alumnos,libros,prestamos,refrendos,multas,opciones,salir;
    JMenuItem consultaAlumnos,consultaLibros,consultarTesis,nuevoPrestamo,consultarPrestamos,nuevoRefrendo,consultarRefrendos,entregaLibros,consultarMultas,acercaDe,cerrarSesion,ayuda,miUsuario;
    MainDesktopPane panel;
    String user;
    
    
    public FrmPrincipalEstandar(String usuario){
        setTitle("BIBLIOTECA ITSAT");
        setSize(980,680);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        user=usuario;
        initComponents();
       
    }
    
    public void initComponents(){
        
        barra= new JMenuBar();
        alumnos=new JMenu("Alumnos");
        libros=new JMenu("Libros");
        prestamos=new JMenu("Prestamos");
        refrendos=new JMenu("Refrendos");
        multas=new JMenu("Multas");
        ayuda=new JMenuItem("Ayuda");
        opciones = new JMenu("Opciones");
        salir=new JMenu("Salir");
        consultaAlumnos=new JMenuItem("Consultar Alumnos");
        consultaLibros=new JMenuItem("Consultar Libros");
        consultarTesis=new JMenuItem("Consultar Tesis");
        nuevoPrestamo=new JMenuItem("Nuevo Prestamo");
        consultarPrestamos=new JMenuItem("Consultar Prestamos");
        nuevoRefrendo=new JMenuItem("Nuevo Refrendo");
        consultarRefrendos=new JMenuItem("Consultar Refrendos");
        entregaLibros=new JMenuItem("Entregar Libros");
        consultarMultas=new JMenuItem("Consultar Multas");
        miUsuario=new JMenuItem("Mi usuario");
        acercaDe=new JMenuItem("Acerca De");
        cerrarSesion=new JMenuItem("Cerrar Sesión");
        
        
               
        consultaAlumnos.addActionListener((ActionEvent e) -> {
            try {
                consultarAlumnos(e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmPrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

       
        consultaLibros.addActionListener((ActionEvent e) -> {
            consultarLibros(e);
        });
       
       
           consultarTesis.addActionListener((ActionEvent e) -> {
               consultarTesis(e);
        });
        
        nuevoPrestamo.addActionListener((ActionEvent e) -> {
            nuevoPrestamo(e);
        });
        
        consultarPrestamos.addActionListener((ActionEvent e) -> {
            consultarPrestamos(e);
        });
        
        entregaLibros.addActionListener((ActionEvent e) -> {
            entregarLibros(e);
        });
        
        nuevoRefrendo.addActionListener((ActionEvent e) -> {
            nuevoRefrendo(e);
        });
        
        consultarRefrendos.addActionListener((ActionEvent e) -> {
            consultarRefrendos(e);
        });
        
        consultarMultas.addActionListener((ActionEvent e) -> {
            consultarMultas(e);
        });
       
       
        acercaDe.addActionListener((ActionEvent e) -> {
            acercaDe(e);
        });
        
        ayuda.addActionListener((ActionEvent e) -> {
            ayuda(e);
        });
        
        cerrarSesion.addActionListener((ActionEvent e) -> {
            cerrarSesion(e);
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
        
        
       Image icon = new ImageIcon(getClass().getResource("/Imagenes/iconos1.png")).getImage();
       setIconImage(icon); 
        
       ImageIcon iconAlumnos=new ImageIcon(getClass().getResource("/imagenes/alumnos.png"));
       ImageIcon iconLibros=new ImageIcon(getClass().getResource("/imagenes/libros.png"));
       ImageIcon iconPrestamos=new ImageIcon(getClass().getResource("/imagenes/prestamos.png"));
       ImageIcon iconRefrendos=new ImageIcon(getClass().getResource("/imagenes/refrendos.png"));
       ImageIcon iconMultas=new ImageIcon(getClass().getResource("/imagenes/multas.png"));
       ImageIcon iconOpciones=new ImageIcon(getClass().getResource("/imagenes/opciones.png"));
       ImageIcon iconSalir=new ImageIcon(getClass().getResource("/imagenes/salir.png"));
        
       ImageIcon iconConAlu=new ImageIcon(getClass().getResource("/imagenes/consultaAlu.png")); 
       ImageIcon iconConLi=new ImageIcon(getClass().getResource("/imagenes/iconConLi.png"));
       ImageIcon iconConTe=new ImageIcon(getClass().getResource("/imagenes/conTe.png"));
       ImageIcon iconNP=new ImageIcon(getClass().getResource("/imagenes/nuevoPrestamo.png"));
       ImageIcon iconCP=new ImageIcon(getClass().getResource("/imagenes/consPre.png"));
       ImageIcon iconEntregar=new ImageIcon(getClass().getResource("/imagenes/lblEntregar.png"));
       ImageIcon iconNR=new ImageIcon(getClass().getResource("/imagenes/nuevoRe.png"));
       ImageIcon iconCR=new ImageIcon(getClass().getResource("/imagenes/consultaRe.png"));
       ImageIcon iconCM=new ImageIcon(getClass().getResource("/imagenes/consultarMultas.png"));
       ImageIcon iconAD=new ImageIcon(getClass().getResource("/imagenes/acercaD.png"));
       ImageIcon iconAyuda=new ImageIcon(getClass().getResource("/imagenes/ayuda.png"));
       ImageIcon iconOff=new ImageIcon(getClass().getResource("/imagenes/off.png"));
       ImageIcon iconNA=new ImageIcon(getClass().getResource("/imagenes/nuevoAlu.png"));
        
       alumnos.setIcon(iconAlumnos);
       libros.setIcon(iconLibros);
       prestamos.setIcon(iconPrestamos);
       refrendos.setIcon(iconRefrendos);
       multas.setIcon(iconMultas);
       opciones.setIcon(iconOpciones);
       salir.setIcon(iconSalir); 
        
       consultaAlumnos.setIcon(iconConAlu);
       consultaLibros.setIcon(iconConLi);
       consultarTesis.setIcon(iconConTe);
       nuevoPrestamo.setIcon(iconNP);
       consultarPrestamos.setIcon(iconCP);
       entregaLibros.setIcon(iconEntregar);
       nuevoRefrendo.setIcon(iconNR);
       consultarRefrendos.setIcon(iconCR);
       consultarMultas.setIcon(iconCM);
       acercaDe.setIcon(iconAD);
       ayuda.setIcon(iconAyuda);
       cerrarSesion.setIcon(iconOff);
        
        
        
        alumnos.add(consultaAlumnos);
        libros.add(consultaLibros);
        libros.add(consultarTesis);
        prestamos.add(nuevoPrestamo);
        prestamos.add(consultarPrestamos);
        prestamos.add(entregaLibros);
        refrendos.add(nuevoRefrendo);
        refrendos.add(consultarRefrendos);
        multas.add(consultarMultas);
        opciones.add(ayuda);
        opciones.add(acercaDe);
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
        int i=JOptionPane.showConfirmDialog(null,"Desea cerrar sesión?","Confirmación",JOptionPane.WARNING_MESSAGE);
        if(i==JOptionPane.YES_OPTION){
              
        new FrmLogin().setVisible(true);
        this.dispose();
        }
        
    }
    
     
    
}
