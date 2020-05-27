/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VistaBase;
import conjunto.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import Vista.VistaRegistroResid;

/**
 *
 * @author Jairo
 */
public class RegistoResidente implements ActionListener {

    private conexion con;
    private VistaBase VistaBase;
    private VistaRegistroResid vistarr;

    public RegistoResidente(VistaBase VistaBase, conexion con, VistaRegistroResid vistarr) {
        this.VistaBase = VistaBase;
        this.vistarr = vistarr;
        this.con = con;
        this.vistarr.jButton1.addActionListener(this);
        this.vistarr.jButton2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistarr.jButton2) {
            String id = vistarr.jTextField1.getText();
            String nombre = vistarr.jTextField2.getText();
            String apellidos = vistarr.jTextField3.getText();
            String telefono = vistarr.jTextField4.getText();
            String id_apto = "";
            for (int i = 1; i < 6; i++) {
                for (int j = 1; j < 6; j++) {
                    for (int k = 0; k < 6; k++) {
                        if (("" + i + "").equals(vistarr.jComboBox1.getSelectedItem().toString()) && ("" + j + "0" + k + "").equals(vistarr.jComboBox2.getSelectedItem().toString())) {
                            id_apto = "T" + i + "A" + j + "0" + k;
                        }
                    }
                }
            }
            PreparedStatement ps;
            try {

                if (!id.equals(null) && !nombre.equals(null) && !apellidos.equals(null) && !telefono.equals(null) && !id_apto.equals(null)) {
                    ps = con.conexion().prepareStatement("insert into residentes(id_residente,nombre,apellidos,telefono,id_apto)values('" + id + "','" + nombre + "','" + apellidos + "','" + telefono + "','" + id_apto + "')");
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Dato Registrado Correctamente");
                    vistarr.jTextField1.setText("");
                    vistarr.jTextField2.setText("");
                    vistarr.jTextField3.setText("");
                    vistarr.jTextField4.setText("");

                } else {
                    JOptionPane.showMessageDialog(null, "Campos vacios");

                }
            } catch (Exception x) {

                JOptionPane.showMessageDialog(null, "Datos erroneos Dato no registrado"+ x.getMessage());
            }

        }
        if (e.getSource() == vistarr.jButton1) {
            vistarr.setVisible(false);
            VistaBase.setVisible(true);
            vistarr.jTextField1.setText("");
            vistarr.jTextField2.setText("");
            vistarr.jTextField3.setText("");
            vistarr.jTextField4.setText("");

        }

    }

}
