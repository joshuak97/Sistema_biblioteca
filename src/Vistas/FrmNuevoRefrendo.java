/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Datos.Drefrendos;
import Logica.Lrefrendo;
import com.sun.glass.events.KeyEvent;
import java.awt.HeadlessException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class FrmNuevoRefrendo extends javax.swing.JInternalFrame {
    String user;
    int resultados=0;
    /**
     * Creates new form FrmNuevoRefrendo
     * @param usuario
     */
    public FrmNuevoRefrendo(String usuario) {
        user=usuario;
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        txtAlumnoR = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRefrendos = new javax.swing.JTable();
        btnRefrendar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Nuevo Refrendo");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Folio Alumno:");

        txtAlumnoR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlumnoRActionPerformed(evt);
            }
        });
        txtAlumnoR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAlumnoRKeyPressed(evt);
            }
        });

        tblRefrendos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Prestamo Id", "Libro_id", "Tipo de Prestamo", "Fecha de Prestamo", "Recargos", "Aprueba"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRefrendos);

        btnRefrendar.setText("Refrendar");
        btnRefrendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrendarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnRefrendar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAlumnoR, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(437, 437, 437))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlumnoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRefrendar)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
      borrarTabla();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtAlumnoRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlumnoRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlumnoRActionPerformed

    private void txtAlumnoRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlumnoRKeyPressed
        try{
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
          
          
      consultarPrestamos(txtAlumnoR.getText());
      txtAlumnoR.setText("");
     
         }
        }catch(HeadlessException e){
         JOptionPane.showMessageDialog(this,"Introduzca un alumno_id valido");
         txtAlumnoR.setText("");
         }
    }//GEN-LAST:event_txtAlumnoRKeyPressed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        consultarPrestamos(txtAlumnoR.getText());
        txtAlumnoR.setText("");
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnRefrendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrendarActionPerformed
    Drefrendos dr=new Drefrendos();
    Lrefrendo l=new Lrefrendo();
    for(int i=0;i<resultados;i++){
    l.setFolioR(generarFolioR());
    l.setFolioPrestamo(tblRefrendos.getValueAt(i,0).toString());
    l.setFechaRefrendo(generarFechaRefrendo());
    l.setUsuario(user);
    dr.agregarRefrendo(l);
    }
    borrarTabla();
    }//GEN-LAST:event_btnRefrendarActionPerformed
     
    public void consultarPrestamos(String alumnoId){
    Drefrendos dp=new Drefrendos();
    DefaultTableModel modelo=dp.mostrarPrestamos(alumnoId);
    tblRefrendos.setModel(modelo);
    resultados=dp.getResultados();
    }
    
    public void borrarTabla(){
    String titulos[]= {"Folio Prestamo","Libro","Tipo de Prestamo","Fecha de Prestamo","Recargos:","Aprueba:"};
    DefaultTableModel modelo=new DefaultTableModel(null,titulos);    
    tblRefrendos.setModel(modelo);
    }
    
    public String generarFolioR(){
        
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
    
     public String generarFechaRefrendo(){
        
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
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRefrendar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRefrendos;
    private javax.swing.JTextField txtAlumnoR;
    // End of variables declaration//GEN-END:variables
}
