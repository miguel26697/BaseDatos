/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author david
 */
public class VistaBase extends javax.swing.JFrame {

    /**
     * Creates new form VistaBase
     */
    public VistaBase() {
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

        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        resitrab = new javax.swing.JButton();
        zonas = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        Propietario = new javax.swing.JMenu();
        actpro = new javax.swing.JMenuItem();
        actures = new javax.swing.JMenuItem();
        propietarios = new javax.swing.JMenuItem();
        registropro = new javax.swing.JMenuItem();
        registroresi = new javax.swing.JMenuItem();
        residentes = new javax.swing.JMenuItem();
        registrotrab = new javax.swing.JMenuItem();
        trabajadores = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        jMenuItem1.setText("jMenuItem1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Miguel companys asociados J.S.");

        resitrab.setText("Residiarios/Trabajdores");
        resitrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resitrabActionPerformed(evt);
            }
        });

        zonas.setText("Zonas");
        zonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zonasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(resitrab)
                        .addGap(43, 43, 43)
                        .addComponent(zonas, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(286, 286, 286))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addGap(187, 187, 187)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(zonas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resitrab, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        Propietario.setText("File");

        actpro.setText("Actualizar o eliminar un  propietario");
        actpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actproActionPerformed(evt);
            }
        });
        Propietario.add(actpro);

        actures.setText("Actualizar o eliminar un  residente");
        actures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acturesActionPerformed(evt);
            }
        });
        Propietario.add(actures);

        propietarios.setText("Visualizar Propietarios");
        propietarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propietariosActionPerformed(evt);
            }
        });
        Propietario.add(propietarios);

        registropro.setText("Registro Porpietarios");
        Propietario.add(registropro);

        registroresi.setText("Registro Residentes");
        Propietario.add(registroresi);

        residentes.setText("Visualizar Residentes");
        Propietario.add(residentes);

        registrotrab.setText("Registro Trabajador");
        registrotrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrotrabActionPerformed(evt);
            }
        });
        Propietario.add(registrotrab);

        trabajadores.setText("Visualizar Trabajadores");
        Propietario.add(trabajadores);

        jMenuBar1.add(Propietario);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 491, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resitrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resitrabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resitrabActionPerformed

    private void zonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zonasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zonasActionPerformed

    private void actproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actproActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_actproActionPerformed

    private void acturesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acturesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acturesActionPerformed

    private void propietariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propietariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_propietariosActionPerformed

    private void registrotrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrotrabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registrotrabActionPerformed

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
            java.util.logging.Logger.getLogger(VistaBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaBase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenu Propietario;
    public javax.swing.JMenuItem actpro;
    public javax.swing.JMenuItem actures;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JMenuItem propietarios;
    public javax.swing.JMenuItem registropro;
    public javax.swing.JMenuItem registroresi;
    public javax.swing.JMenuItem registrotrab;
    public javax.swing.JMenuItem residentes;
    public javax.swing.JButton resitrab;
    public javax.swing.JMenuItem trabajadores;
    public javax.swing.JButton zonas;
    // End of variables declaration//GEN-END:variables
}
