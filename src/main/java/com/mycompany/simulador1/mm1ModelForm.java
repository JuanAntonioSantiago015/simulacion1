/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.simulador1;
import static com.mycompany.simulador1.MetodosMM.*;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class mm1ModelForm extends javax.swing.JFrame {

    /**
     * Creates new form mm1ModelForm
     */
    public mm1ModelForm() {
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
        lblTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtLlegadas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        srvcTime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        srvcUse = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtProb = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtUnidadesCola = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtUnidadesSistema = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEsperaCola = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEsperaSistema = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtOcio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtN = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtOcupado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        lblTitle.setText("Modelo MM1");

        jLabel1.setText("Llegadas");

        txtLlegadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLlegadasActionPerformed(evt);
            }
        });

        jLabel2.setText("Tiempo de servicio");

        srvcTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srvcTimeActionPerformed(evt);
            }
        });

        jLabel3.setText("Uso del servidor");

        srvcUse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srvcUseActionPerformed(evt);
            }
        });

        jLabel4.setText("Pn");

        txtProb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProbActionPerformed(evt);
            }
        });

        jLabel5.setText("Lq");

        txtUnidadesCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnidadesColaActionPerformed(evt);
            }
        });

        jLabel6.setText("Ls");

        txtUnidadesSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnidadesSistemaActionPerformed(evt);
            }
        });

        jLabel7.setText("Wq");

        txtEsperaCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEsperaColaActionPerformed(evt);
            }
        });

        jLabel8.setText("Ws");

        txtEsperaSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEsperaSistemaActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(149, 182, 52));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Ocio");

        jLabel10.setText("n");

        txtN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNActionPerformed(evt);
            }
        });

        jLabel11.setText("Ocupado");

        txtOcupado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOcupadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(529, 529, 529)
                        .addComponent(lblTitle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtProb, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtLlegadas, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtN, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                    .addComponent(txtOcio))))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(81, 81, 81)
                                .addComponent(txtOcupado))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(srvcTime, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtUnidadesCola, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtEsperaCola, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEsperaSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(srvcUse, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtUnidadesSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(131, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(75, 75, 75))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLlegadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(srvcTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(srvcUse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtProb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtUnidadesCola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtUnidadesSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEsperaCola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtEsperaSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtOcio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtOcupado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(43, 43, 43))
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

    private void txtLlegadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLlegadasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLlegadasActionPerformed

    private void srvcTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srvcTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_srvcTimeActionPerformed

    private void srvcUseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srvcUseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_srvcUseActionPerformed

    private void txtProbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProbActionPerformed

    private void txtUnidadesColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnidadesColaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnidadesColaActionPerformed

    private void txtUnidadesSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnidadesSistemaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnidadesSistemaActionPerformed

    private void txtEsperaColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEsperaColaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEsperaColaActionPerformed

    private void txtEsperaSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEsperaSistemaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEsperaSistemaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        double llegadas = 0;
        double tiempoSrvc = 0;
        double usoSrvd = 0;
        double probabilidad = 0;
        double unidadesCola = 0;
        double unidadesSistema = 0;
        double esperaCola = 0;
        double esperaSistema = 0;
        double ocio = 0;
        double ocupado = 0;
        int n = 0;
        
        try{
            if(txtLlegadas.getText().trim().isEmpty()){
                
            }
            else {
                llegadas = Double.parseDouble(txtLlegadas.getText().trim());
            }
            if(srvcTime.getText().trim().isEmpty()){
                
            }
            else {
                tiempoSrvc = Double.parseDouble(srvcTime.getText().trim());
            }
            if(srvcUse.getText().trim().isEmpty()){
                
            }
            else {
                usoSrvd = Double.parseDouble(srvcUse.getText().trim());
            }
            if(txtProb.getText().trim().isEmpty()){
                
            }
            else {
                probabilidad = Double.parseDouble(txtProb.getText().trim());
            }
            if(txtUnidadesCola.getText().trim().isEmpty()){
                
            }
            else {
                unidadesCola = Double.parseDouble(txtUnidadesCola.getText().trim());
            }
            if(txtUnidadesSistema.getText().trim().isEmpty()){
                
            }
            else {
                unidadesSistema = Double.parseDouble(txtUnidadesSistema.getText().trim());
            }
            if(txtEsperaCola.getText().trim().isEmpty()){
                
            }
            else {
                esperaCola = Double.parseDouble(txtEsperaCola.getText().trim());
            }
            if(txtEsperaSistema.getText().trim().isEmpty()){
                
            }
            else {
                esperaSistema = Double.parseDouble(txtEsperaSistema.getText().trim());
            }
            if(txtOcio.getText().trim().isEmpty()){
                
            }
            else {
                ocio = Double.parseDouble(txtOcio.getText().trim());
            }
            if(txtOcupado.getText().trim().isEmpty()){
                
            }
            else {
                ocupado = Double.parseDouble(txtOcupado.getText().trim());
            }
            if(txtN.getText().trim().isEmpty()){
                
            }
            else {
                n = Integer.parseInt(txtN.getText().trim());
            }
            
            if(llegadas >= tiempoSrvc){
                JOptionPane.showMessageDialog(null, "El sistema está colapsado");
                return;
            }
            
            double tiempoPromDeLlegadas = 1 / llegadas;
            double tiempoPromDeServicio = 1 / tiempoSrvc;
            
            txtEsperaSistema.setText(String.valueOf(serviceTime(llegadas, tiempoSrvc)));
            esperaSistema = Double.parseDouble(txtEsperaSistema.getText().trim());
            txtEsperaCola.setText(String.valueOf(clientesCola(llegadas, tiempoSrvc)));
            esperaCola = Double.parseDouble(txtEsperaCola.getText().trim());
            txtUnidadesSistema.setText(String.valueOf(clientsInSystem(llegadas, tiempoSrvc)));
            unidadesSistema = Double.parseDouble(txtUnidadesSistema.getText().trim());
            txtOcio.setText(String.valueOf(probOcio(llegadas, tiempoSrvc)));
            ocio = Double.parseDouble(txtOcio.getText().trim());
            //double factorDeUtilizacion = 0;
            txtOcupado.setText(String.valueOf(probOcupado(llegadas, tiempoSrvc)));
            ocupado = Double.parseDouble(txtOcupado.getText().trim());
            txtProb.setText(String.valueOf(probN(llegadas, tiempoSrvc, n)));
            probabilidad = Double.parseDouble(txtProb.getText().trim());
            txtUnidadesCola.setText(String.valueOf(clientsInLine(llegadas, tiempoSrvc)));
            unidadesCola = Double.parseDouble(txtUnidadesCola.getText().trim());
            srvcUse.setText(String.valueOf(llegadas/tiempoSrvc));
            tiempoPromDeServicio = Double.parseDouble(srvcUse.getText().trim());
            
            
            
            
        } catch (NumberFormatException e) {
            System.out.println("TIENE NÚMEROS NO VÁLIDOS");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNActionPerformed

    private void txtOcupadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOcupadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOcupadoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mm1ModelForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mm1ModelForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mm1ModelForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mm1ModelForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mm1ModelForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField srvcTime;
    private javax.swing.JTextField srvcUse;
    private javax.swing.JTextField txtEsperaCola;
    private javax.swing.JTextField txtEsperaSistema;
    private javax.swing.JTextField txtLlegadas;
    private javax.swing.JTextField txtN;
    private javax.swing.JTextField txtOcio;
    private javax.swing.JTextField txtOcupado;
    private javax.swing.JTextField txtProb;
    private javax.swing.JTextField txtUnidadesCola;
    private javax.swing.JTextField txtUnidadesSistema;
    // End of variables declaration//GEN-END:variables
}
