/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Vistacel;
import Vista.VistaRegistoTrab;
import Vista.VistaRegistroVisi;
import conjunto.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author migue
 */
public class RegistroVisitante implements ActionListener {

    private Vistacel VistaBase;
    private VistaRegistroVisi vistarp;
    private conexion con;

    public RegistroVisitante(Vistacel VistaBase, VistaRegistroVisi vistarp, conexion con) {
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
                    && vistarp.jTextField6.getText().length() != 0 && vistarp.jTextField7.getText().length() != 0) {
                try {
                    int id_vis = Integer.parseInt(vistarp.jTextField1.getText());
                    String nombre = vistarp.jTextField2.getText();
                    String apellidos = vistarp.jTextField3.getText();
                    String carro = vistarp.jTextField4.getText();
                    String placa = vistarp.jTextField5.getText();
                    String fecha = vistarp.jTextField6.getText();
                    String id_apto = vistarp.jTextField7.getText();

                    PreparedStatement ps;
                    try {
                        ps = con.conexion().prepareStatement("insert into visitante(id_visitante,nombre,apellidos,carro,placa,fecha,id_apto)values('"
                                + Integer.toString(id_vis) + "','" + nombre + "','" + apellidos + "','" + carro + "','" + placa + "','" + fecha + "','" + id_apto+ "')");
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Registro Almacenado correctamete");
                        vistarp.jTextField1.setText(null);
                        vistarp.jTextField2.setText(null);
                        vistarp.jTextField3.setText(null);
                        vistarp.jTextField4.setText(null);
                        vistarp.jTextField5.setText(null);
                        vistarp.jTextField6.setText(null);
                        vistarp.jTextField7.setText(null);

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
