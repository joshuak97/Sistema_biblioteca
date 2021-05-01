package Vistas;


import Conexion.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rojeru San
 */
public class FrmLogin extends javax.swing.JFrame {

    
    int x, y;
    public static Conexion cc = new Conexion();
    Connection cn = cc.conectar();

    
   
    public FrmLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.msj.setVisible(false);
         Image icon = new ImageIcon(getClass().getResource("/Imagenes/key.png")).getImage();
        this.setIconImage(icon);
        this.usuario.requestFocus();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        usuario = new app.bolivia.swing.JCTextField();
        passw = new jpass.JRPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        salir = new javax.swing.JButton();
        entrar = new javax.swing.JButton();
        msj = new javax.swing.JLabel();
        min = new javax.swing.JButton();
        aqui = new javax.swing.JLabel();
        msj1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panel1.setBackground(new java.awt.Color(255, 153, 0));
        panel1.setColorPrimario(new java.awt.Color(0, 102, 51));
        panel1.setColorSecundario(new java.awt.Color(0, 102, 51));
        ImageIcon iconFondoLogin=new ImageIcon(getClass().getResource("/Imagenes/fondoL.png")); 
        panel1.setIcon(iconFondoLogin); // NOI18N
        panel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panel1MouseDragged(evt);
            }
        });
        panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panel1MousePressed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImageIcon iconAbout=new ImageIcon(getClass().getResource("/Imagenes/about.png")); 
        jLabel1.setIcon(iconAbout); // NOI18N

        jPanel1.setBackground(new java.awt.Color(33, 89, 104));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usuario.setBackground(new java.awt.Color(183, 222, 232));
        usuario.setBorder(null);
        usuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usuario.setOpaque(false);
        usuario.setPlaceholder("INGRESAR USUARIO");
        jPanel1.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 38, 180, 30));

        passw.setBackground(new java.awt.Color(183, 222, 232));
        passw.setBorder(null);
        passw.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        passw.setOpaque(false);
        passw.setPlaceholder("INGRESAR CONTRASEÑA");
        passw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwActionPerformed(evt);
            }
        });
        passw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwKeyTyped(evt);
            }
        });
        jPanel1.add(passw, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 107, 170, 30));
        ImageIcon iconIconoB=new ImageIcon(getClass().getResource("/Imagenes/icono_b.png")); 
        jLabel3.setIcon(iconIconoB); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 120));
        ImageIcon iconCampoPass=new ImageIcon(getClass().getResource("/Imagenes/campoPass.png"));
        jLabel2.setIcon(iconCampoPass); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 240, -1));
        ImageIcon iconCampoUser=new ImageIcon(getClass().getResource("/Imagenes/campoUser.png"));
        jLabel4.setIcon(iconCampoUser); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 240, -1));
        ImageIcon iconSalir1=new ImageIcon(getClass().getResource("/Imagenes/btn_salir1.png"));
        salir.setIcon(iconSalir1); // NOI18N
        salir.setToolTipText("<html> <head> <style> #contenedor{background:#00688B;color:white; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Salir</h4> </body> </html>");
        salir.setBorder(null);
        salir.setBorderPainted(false);
        salir.setContentAreaFilled(false);
        salir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ImageIcon iconSalir2=new ImageIcon(getClass().getResource("/Imagenes/btn_salir2.png"));
        salir.setRolloverIcon(iconSalir2); // NOI18N
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel1.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, -1, -1));
        ImageIcon iconEntrar1=new ImageIcon(getClass().getResource("/Imagenes/btn_entrar1.png"));
        entrar.setIcon(iconEntrar1); // NOI18N
        entrar.setToolTipText("<html> <head> <style> #contenedor{background:#00688B;color:white; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Entrar</h4> </body> </html>");
        entrar.setBorder(null);
        entrar.setBorderPainted(false);
        entrar.setContentAreaFilled(false);
        entrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ImageIcon iconEntrar2=new ImageIcon(getClass().getResource("/Imagenes/btn_entrar2.png"));
        entrar.setRolloverIcon(iconEntrar2); // NOI18N
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });
        jPanel1.add(entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 160, 110, -1));

        msj.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        msj.setForeground(new java.awt.Color(255, 255, 153));
        msj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj.setText("¡Datos incorrectos, intente nuevamente!");
        jPanel1.add(msj, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 400, 20));
        ImageIcon iconMin1=new ImageIcon(getClass().getResource("/Imagenes/btn_min1.png"));
        min.setIcon(iconMin1); // NOI18N
        min.setToolTipText("<html> <head> <style> #contenedor{background:#00688B;color:white; padding-left:10px;padding-right:10px;margin:0; padding-top:5px;padding-bottom:5px;} </style> </head> <body> <h4 id=\"contenedor\">Minimizar</h4> </body> </html>");
        min.setBorder(null);
        min.setBorderPainted(false);
        min.setContentAreaFilled(false);
        min.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ImageIcon iconMin2=new ImageIcon(getClass().getResource("/Imagenes/btn_min2.png"));
        min.setRolloverIcon(iconMin2); // NOI18N
        min.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minActionPerformed(evt);
            }
        });

        aqui.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        aqui.setForeground(new java.awt.Color(51, 153, 255));
        aqui.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aqui.setText("aquí");
        aqui.setToolTipText("<html>\n<head>\n<style>\n#contenedor{background:#00688B;color:white;\npadding-left:10px;padding-right:10px;margin:0;\npadding-top:5px;padding-bottom:5px;}\n</style>\n</head>\n<body>\n<h4 id=\"contenedor\">Recuperar</h4>\n</body>\n</html>");
        aqui.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        aqui.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                aquiMouseMoved(evt);
            }
        });
        aqui.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aquiMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aquiMouseExited(evt);
            }
        });

        msj1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        msj1.setForeground(new java.awt.Color(255, 255, 255));
        msj1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        msj1.setText("¿Olvidaste tú usuario o contraseña?, has clic");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addComponent(min, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(msj1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(aqui, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(min)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(msj1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aqui, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void minActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minActionPerformed
        this.setExtendedState(ICONIFIED);
       
    }//GEN-LAST:event_minActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
        String us = usuario.getText();
        String pass =String.valueOf(passw.getPassword());
        if (us.equals("") || pass.equals("")) {
            this.msj.setVisible(true);
            this.msj.setText("¡Ingrese usuario y contraseña!");
            this.usuario.requestFocus();
        } else { 
            ingresar(us,pass);
       }
    }//GEN-LAST:event_entrarActionPerformed

    private void aquiMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aquiMouseMoved
        this.aqui.setForeground(new Color(224, 255, 255));
    }//GEN-LAST:event_aquiMouseMoved

    private void aquiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aquiMouseClicked
       // new Recupera(this, true).setVisible(true);
    }//GEN-LAST:event_aquiMouseClicked

    private void aquiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aquiMouseExited
        this.aqui.setForeground(new Color(51, 153, 255));
    }//GEN-LAST:event_aquiMouseExited

    private void passwKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwKeyTyped
        char num = evt.getKeyChar();
        char letras = evt.getKeyChar();
        if ((num < '0' || num > '9') && ((letras < 'a' || letras > 'z') && (letras < 'A' | letras > 'Z'))) {
            if ((letras != 'ñ') && (letras != 'Ñ') && (letras != ' ')) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_passwKeyTyped

    private void panel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_panel1MousePressed

    private void panel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MouseDragged
        Point mueve = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(mueve.x - x, mueve.y - y);
    }//GEN-LAST:event_panel1MouseDragged

    private void passwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwActionPerformed
      
    }//GEN-LAST:event_passwActionPerformed

    private void passwKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwKeyReleased
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
          String us = usuario.getText();
        String pass =String.valueOf(passw.getPassword());
        if (us.equals("") || pass.equals("")) {
            this.msj.setVisible(true);
            this.msj.setText("¡Ingrese usuario y contraseña!");
            this.usuario.requestFocus();
        } else { 
            ingresar(us,pass);
       }                    
        }
    }//GEN-LAST:event_passwKeyReleased



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aqui;
    private javax.swing.JButton entrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton min;
    private javax.swing.JLabel msj;
    private javax.swing.JLabel msj1;
    private org.edisoncor.gui.panel.Panel panel1;
    private jpass.JRPasswordField passw;
    private javax.swing.JButton salir;
    private app.bolivia.swing.JCTextField usuario;
    // End of variables declaration//GEN-END:variables

    private void ingresar(String usuario, String pas) {
       String user = "", pass = "", perfil="";
        try {
            String sql = "SELECT usuario,contrasena,perfil FROM usuarios WHERE usuario = '" + usuario + "' AND estado!='BAJA'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                user = rs.getString(1);
                pass = rs.getString(2);
                perfil=rs.getString(3);
            }

            if (user.equals(usuario) && pass.equals(pas) && perfil.equals("ADMINISTRADOR")) {
                this.dispose();
                new FrmPrincipalAdmin(usuario).setVisible(true);
            }
            
            else if(user.equals(usuario) && pass.equals(pass) && perfil.equals("ENCARGADO")){
                
                this.dispose();
                new FrmPrincipalEncargado(usuario).setVisible(true);
                
            }
            else if(user.equals(usuario) && pass.equals(pass) && perfil.equals("SERVICIO")){
                this.dispose();
                new FrmPrincipalEstandar(usuario).setVisible(true);

            }
            else {
                this.msj.setVisible(true);
                this.msj1.setVisible(true);
                this.aqui.setVisible(true);
                this.msj.setText("¡Usuario/Contraseña incorrectos, intente nuevamente!");
                this.usuario.setText("");
                this.passw.setText("");
                this.usuario.requestFocus();
            }

        } catch (SQLException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info:javax.swing.UIManager.getInstalledLookAndFeels()) {
              
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level
                    .SEVERE, null, ex);
            
        }
           
        File f=new File("C:\\BIBIOTEC\\FotoAlumnos"); 
       if(f.exists()){
       JOptionPane.showMessageDialog(null,"Ficheros en Orden","Verificación de Ficheros",JOptionPane.INFORMATION_MESSAGE);
       }else{
       f.mkdirs();
       }    
           FrmLogin o=new FrmLogin();
           o.setVisible(true);
       }
    
}
