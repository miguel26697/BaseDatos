/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VistaBase;
import Vista.VistaActPar;
import conjunto.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Jairo
 */
public class actpar implements ActionListener {

    private conexion con;
    private VistaBase vistabase;
    private VistaActPar vp;
    private String id;

    public actpar(VistaBase vistabase, VistaActPar vp, conexion con) {
        this.con = con;
        this.vistabase = vistabase;
        this.vp = vp;
        this.id = "";
        this.vp.jButton1.addActionListener(this);
        this.vp.jButton2.addActionListener(this);
        this.vp.jButton3.addActionListener(this);
        this.vp.jButton2.setEnabled(false);
        this.vp.jTextField1.setEditable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vp.jButton1) {
            for (int i = 1; i < 11; i++) {
                for (int j = 1; j < 16; j++) {
                    if (("" + i + "").equals(vp.jComboBox1.getSelectedItem().toString()) && ("" + j + "").equals(vp.jComboBox2.getSelectedItem().toString())) {
                        id = "B" + i + "P" + j;
                    }

                }
            }

            try {

                String clave = "Select id_parqueadero,bahia ,pp ,id_residente  from parqueadero where id_parqueadero ='" + id + "'";
                PreparedStatement ps;
                ResultSet rs;
                ps = con.conexion().prepareStatement(clave);
                rs = ps.executeQuery();
                if (rs.next()) {
                    vp.jLabel5.setText(rs.getString("bahia"));
                    vp.jLabel7.setText(rs.getString("pp"));
                    vp.jTextField1.setText(rs.getString("id_residente"));
                    this.vp.jButton2.setEnabled(true);
                    this.vp.jTextField1.setEditable(true);

                } else {

                    JOptionPane.showMessageDialog(null, "id no encontrado");
                }
            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, "Datos incorrectos");

            }

        }
        if (e.getSource() == vp.jButton2) {
            try {
                String id_resi = vp.jTextField1.getText();
                PreparedStatement ps;
                ResultSet rs;
                if (id_resi.length() != 0) {
                    ps = con.conexion().prepareStatement("update parqueadero set id_residente='" + id_resi + "' where id_parqueadero = \'" + id + "'");
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Datos Actualizados");
                    this.vp.jButton2.setEnabled(false);
                    this.vp.jTextField1.setEditable(false);
                    this.vp.jTextField1.setText(null);
                    this.vp.jLabel5.setText(null);
                    this.vp.jLabel7.setText(null);

                } else {
                    JOptionPane.showMessageDialog(null, "Complete los datos");
                }
            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, "Datos incorrectos" + x.getMessage());

            }
        }
        if (e.getSource() == vp.jButton3) {
            vp.setVisible(false);
            vistabase.setVisible(true);

            this.vp.jButton2.setEnabled(false);
            this.vp.jTextField1.setEditable(false);
            this.vp.jTextField1.setText(null);
            this.vp.jLabel5.setText(null);
            this.vp.jLabel7.setText(null);

        }

    }

}
