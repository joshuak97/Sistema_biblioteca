/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Conexion.Conexion;
import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Datos.Dprestamo;
import Logica.Lprestamo;
import java.awt.HeadlessException;
import java.util.Calendar;
import javax.swing.table.TableModel;
/**
 *
 * @author USUARIO
 */
public class FrmNuevoPrestamo extends javax.swing.JInternalFrame {
    
    String titulos[]={"Libro Id","Libro:"};
    DefaultTableModel modelo = new DefaultTableModel(null,titulos);
     LlenarTablaPrestamos llenarTabla = new LlenarTablaPrestamos();
    int contadorLibros=0;
    String user;
     
   
    /**
     * Creates new form NuevoPrestamo
     * @param usuario
     */
    public FrmNuevoPrestamo(String usuario) {
        initComponents();
        user=usuario;
        comboPrestamo.setSelectedIndex(-1);
        comboPrestamo.setSelectedItem(-1);
        tblPrestamo.setModel(modelo);
        //se crea el JCheckBox en la columna indicada en getColum(cuenta desde 0) cada vez que hagamos una consulta:
        //tblPrestamo.getColumnModel().getColumn(2).setCellEditor( new Clase_CellEditor() );
        //tblPrestamo.getColumnModel().getColumn(2).setCellRenderer(new Clase_CellRender() );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtAlumno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtLibro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboPrestamo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrestamo = new javax.swing.JTable();
        btnPrestar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Nuevo Prestamo");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevoPrestamo.png"))); // NOI18N
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 102));

        jPanel2.setBackground(new java.awt.Color(0, 204, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Datos del Prestamo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 102, 51))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 51));
        jLabel1.setText("Folio del Alumno: ");

        txtAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAlumnoKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 51));
        jLabel2.setText("Folio del Libro:");

        txtLibro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLibroKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLibroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLibroKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 51));
        jLabel3.setText("Tipo de Prestamo:");

        comboPrestamo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboPrestamo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prestamo a Domicilio", "Consulta Interna", "Fotocopia" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLibro)
                    .addComponent(txtAlumno)
                    .addComponent(comboPrestamo, 0, 161, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(40, 40, 40))
        );

        tblPrestamo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblPrestamo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Libro Id", " Libro:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPrestamo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPrestamoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPrestamo);

        btnPrestar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPrestar.setText("Prestar");
        btnPrestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1073, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnPrestar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(386, 386, 386))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrestar)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalir))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
dispose();        
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtLibroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLibroKeyTyped
     

    }//GEN-LAST:event_txtLibroKeyTyped

    private void txtLibroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLibroKeyPressed
        try{
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
          if(contadorLibros<3){ 
             if(!txtLibro.getText().equals("")){
          
      consultarPrestamo(txtLibro.getText());
      txtLibro.setText("");
      }
      }else{
          JOptionPane.showMessageDialog(null,"El maximo de libros a prestar es 3");          
          txtLibro.setText("");
          }
         }}catch(HeadlessException e){
         JOptionPane.showMessageDialog(this,"Introduzca un numero valido");
         txtLibro.setText("");
         }
    }//GEN-LAST:event_txtLibroKeyPressed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
        borrarPrestamo();
        txtAlumno.setText("");
        txtLibro.setText("");
        comboPrestamo.setSelectedIndex(-1);
        comboPrestamo.setSelectedItem(-1);
        contadorLibros=0;
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnPrestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestarActionPerformed
        // TODO add your handling code here:
        
                
        if(txtAlumno.getText().equals("") || contadorLibros==0){
         JOptionPane.showMessageDialog(null,"Favor de verificar los campos o seleccione un tipo de prestamo","No se puede realizar prestamo",JOptionPane.ERROR_MESSAGE);
        }else{
        int libros=modelo.getRowCount();
        String alumnoId=txtAlumno.getText();
         for(int x=0;x<libros;x++){
            
         String idUnico=tblPrestamo.getValueAt(x,0).toString();
         prestar(idUnico,alumnoId);     
                
                
        }
          borrarPrestamo();
        }
    }//GEN-LAST:event_btnPrestarActionPerformed

    private void tblPrestamoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPrestamoMouseClicked
        //Al hacer click en y vaciar la palomita de prestar se eliminara toda la fila:
        int columna=tblPrestamo.columnAtPoint(evt.getPoint());
        if(columna==2){
            TableModel nuevoModelo=tblPrestamo.getModel();
            
        }
    }//GEN-LAST:event_tblPrestamoMouseClicked

    private void txtLibroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLibroKeyReleased
        

        
    }//GEN-LAST:event_txtLibroKeyReleased

    private void txtAlumnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlumnoKeyReleased
        
    }//GEN-LAST:event_txtAlumnoKeyReleased
    
    //Este metodo nos permite visualizar los libros a prestar en la tabla:
    public void consultarPrestamo(String idUnico){
    Dprestamo dp=new Dprestamo();
    
    if(llenarTabla.llenar_tabla(idUnico, modelo, tblPrestamo)){    
    contadorLibros++;
    }else{
    JOptionPane.showMessageDialog(null,"Libro no encontrado","Error",JOptionPane.ERROR_MESSAGE);
    }
    }
    
    public void borrarPrestamo(){
    
    modelo=new DefaultTableModel(null,titulos);
    tblPrestamo.setModel(modelo);
    txtAlumno.setText("");
    txtLibro.setText("");
    comboPrestamo.setSelectedIndex(-1);
    comboPrestamo.setSelectedItem(-1);
    contadorLibros=0;
    }
    
    public void prestar(String idUnico,String alumnoId){
    
    Dprestamo dp=new Dprestamo();    
    Lprestamo l=new Lprestamo();    
    if(dp.validarPrestamo(idUnico)){
    if(!dp.verificarMultas(alumnoId)){
        int numPrestamos=dp.consultarNumeroPrestamos(alumnoId);
        int prestamosDisponibles=3-numPrestamos;
        if(prestamosDisponibles==0){
           JOptionPane.showMessageDialog(this,"El alumno ya cuenta con el maximo de sus prestamos disponibles","No se puede Realizar el Prestamo",JOptionPane.ERROR_MESSAGE);
        }else if(contadorLibros>prestamosDisponibles){
            JOptionPane.showMessageDialog(this,"El alumno ya cuenta con "+numPrestamos+" libros prestados, solo se le pueden prestar "+prestamosDisponibles+" mas.");
        }else if(contadorLibros<=prestamosDisponibles){        
    l.setFolioP(generarFolioP());
    l.setTipoPrestamo(comboPrestamo.getSelectedItem().toString());
    l.setFechaPrestamo(generarFechaPrestamo());
    l.setAlumnoId(txtAlumno.getText());
    l.setIdUnico(idUnico);
    l.setUsuarioReceptor(user);
    l.setEstadoP("ACTIVO");
    dp.agregarPrestamo(l);
        }else{
        JOptionPane.showMessageDialog(null,"no se ha podido realizar el prestamo","Fallo de Prestamo",JOptionPane.ERROR_MESSAGE);
        }
    }
    }
    }
    
    public void consultarExistencias(String idUnico){
        
        
    
    }
    
    public String generarFolioP(){
        
    String id;
    Calendar fecha=Calendar.getInstance();
    int a=fecha.get(Calendar.YEAR)-1000,m=fecha.get(Calendar.MONTH)+1,d=fecha.get(Calendar.DATE),h=fecha.get(Calendar.HOUR),
    mn=fecha.get(Calendar.MINUTE),s=fecha.get(Calendar.SECOND),n=fecha.get(Calendar.MILLISECOND);
    String ano=Integer.toString(a),mes=Integer.toString(m),dia=Integer.toString(d),hora=Integer.toString(h),
    minuto=Integer.toString(mn),segundo=Integer.toString(s),milisegundo=Integer.toString(n);
    if(m<10){
     mes="0"+mes;
    }
    if(d<10){
     dia="0"+dia;   
    }
    if(h<10){
     hora="0"+hora;   
    }
    if(mn<10){
     minuto="0"+minuto;   
    }
    if(s<10){
     segundo="0"+segundo;   
    }
    if(n<10){
     milisegundo="0"+milisegundo;
    }
    id=ano+mes+dia+hora+minuto+segundo+milisegundo;    
    
    return id;
    
    }
    
     public String generarFechaPrestamo(){
        
    String fechaP=null;
    Calendar fecha=Calendar.getInstance();
    int a=fecha.get(Calendar.YEAR),m=fecha.get(Calendar.MONTH)+1,d=fecha.get(Calendar.DATE),h=fecha.get(Calendar.HOUR),
    mn=fecha.get(Calendar.MINUTE),s=fecha.get(Calendar.SECOND),n=fecha.get(Calendar.MILLISECOND);
    String ano=Integer.toString(a),mes=Integer.toString(m),dia=Integer.toString(d),hora=Integer.toString(h),
    minuto=Integer.toString(mn),segundo=Integer.toString(s),milisegundo=Integer.toString(n);
    if(m<10){
     mes="0"+mes;
    }
    if(d<10){
     dia="0"+dia;   
    }
    if(h<10){
     hora="0"+hora;   
    }
    if(mn<10){
     minuto="0"+minuto;   
    }
    if(s<10){
     segundo="0"+segundo;   
    }
    
    
    fechaP=ano+"-"+mes+"-"+dia+"-"+hora+"-"+minuto+"-"+segundo;    
    
    return fechaP;
    
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPrestar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> comboPrestamo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPrestamo;
    private javax.swing.JTextField txtAlumno;
    private javax.swing.JTextField txtLibro;
    // End of variables declaration//GEN-END:variables
}
