/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author migue
 */
import Vista.VistaBase;
import Vista.VistaRegistroUser;
import Vista.VistaRegistroZona;
import conjunto.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author migue
 */
public class RegistroUser implements ActionListener {

    private VistaBase VistaBase;
    private VistaRegistroUser vistarp;
    private conexion con;

    public RegistroUser(VistaBase VistaBase, VistaRegistroUser vistarp, conexion con) {
        this.vistarp = vistarp;
        this.VistaBase = VistaBase;
        this.con = con;
        this.vistarp.jButton1.addActionListener(this);
        this.vistarp.jButton2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistarp.jButton1) {
            if (vistarp.jTextField1.getText().length() != 0 && vistarp.jTextField2.getText().length() != 0 && vistarp.jTextField3.getText().length() != 0) {
                try {

                    String usuario = vistarp.jTextField1.getText();
                    String clave = vistarp.jTextField2.getText();
                    String tipo = vistarp.jTextField3.getText();

                    PreparedStatement ps;
                    try {
                        ps = con.conexion().prepareStatement("insert into usuario(usuario,clave,tipo)values('" + usuario + "','" + clave + "','" + tipo + "')");
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Registro Almacenado correctamete");
                        vistarp.jTextField1.setText(null);
                        vistarp.jTextField2.setText(null);
                        vistarp.jTextField3.setText(null);

                    } catch (Exception x) {
                        JOptionPane.showMessageDialog(null, "Registro no Almacenado " + x.getMessage());
                        System.out.println("" + x);
                    }
                } catch (NumberFormatException a) {
                    JOptionPane.showMessageDialog(null, " El ID debe ser un numero ");
                }

            } else {
                JOptionPane.showMessageDialog(null, " Complete los campos ");
            }
        }
        if (e.getSource() == vistarp.jButton2) {
            vistarp.setVisible(false);
            vistarp.dispose();
            VistaBase.setVisible(true);
        }

    }
}
