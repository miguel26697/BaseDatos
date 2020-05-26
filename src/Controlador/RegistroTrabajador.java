/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VistaBase;
import Vista.VistaRegistoTrab;
import conjunto.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author migue
 */
public class RegistroTrabajador implements ActionListener {

    private VistaBase VistaBase;
    private VistaRegistoTrab vistarp;
    private conexion con;

    public RegistroTrabajador(VistaBase VistaBase, VistaRegistoTrab vistarp, conexion con) {
        this.vistarp = vistarp;
        this.VistaBase = VistaBase;
        this.con = con;
        this.vistarp.jButton1.addActionListener(this);
        this.vistarp.jButton2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistarp.jButton1) {
            if (vistarp.jTextField1.getText().length() != 0 && vistarp.jTextField2.getText().length() != 0 && vistarp.jTextField3.getText().length() != 0 && vistarp.jTextField4.getText().length() != 0 && vistarp.jTextField5.getText().length() != 0
                    && vistarp.jTextField6.getText().length() != 0 && vistarp.jTextField7.getText().length() != 0 && vistarp.jTextField8.getText().length() != 0 && vistarp.jTextField9.getText().length() != 0 && vistarp.jTextField10.getText().length() != 0) {
                try {
                    int id_trab = Integer.parseInt(vistarp.jTextField1.getText());
                    String nombre = vistarp.jTextField2.getText();
                    String apellidos = vistarp.jTextField3.getText();
                    String direccion = vistarp.jTextField4.getText();
                    String fecha_inicio = vistarp.jTextField5.getText();
                    String telefono = vistarp.jTextField6.getText();
                    String eps = vistarp.jTextField7.getText();
                    String caja_com = vistarp.jTextField8.getText();
                    int id_tipo = Integer.parseInt(vistarp.jTextField9.getText());
                    int id_turno = Integer.parseInt(vistarp.jTextField10.getText());
                    PreparedStatement ps;
                    try {
                        ps = con.conexion().prepareStatement("insert into trabajadores(id_trabajdor,nombre,apellidos,direccion,fecha_inicio,telefono,eps,caja_com,id_tipo,id_turno)values('" 
                                + Integer.toString(id_trab) + "','" + nombre + "','" + apellidos + "','" + direccion + "','" + fecha_inicio + "','" + telefono + "','" + eps + "','"+ caja_com + "','"
                                + Integer.toString(id_tipo) + "','" + Integer.toString(id_turno) + "')");
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Registro Almacenado correctamete");
                        vistarp.jTextField1.setText(null);
                        vistarp.jTextField2.setText(null);
                        vistarp.jTextField3.setText(null);
                        vistarp.jTextField4.setText(null);
                        vistarp.jTextField5.setText(null);
                        vistarp.jTextField6.setText(null);
                        vistarp.jTextField7.setText(null);
                        vistarp.jTextField8.setText(null);
                        vistarp.jTextField9.setText(null);
                        vistarp.jTextField10.setText(null);
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
