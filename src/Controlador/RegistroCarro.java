/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VistaBase;
import Vista.VistaRegistroCarro;
import Vista.VistaRegistroP;
import conjunto.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author migue
 */
public class RegistroCarro implements ActionListener {

    private VistaBase VistaBase;
    private VistaRegistroCarro vistarp;
    private conexion con;

    public RegistroCarro(VistaBase VistaBase, VistaRegistroCarro vistarp, conexion con) {
        this.vistarp = vistarp;
        this.VistaBase = VistaBase;
        this.con = con;
        this.vistarp.jButton1.addActionListener(this);
        this.vistarp.jButton2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistarp.jButton1) {
            if (vistarp.jTextField1.getText().length() != 0 && vistarp.jTextField2.getText().length() != 0 && vistarp.jTextField3.getText().length() != 0 && vistarp.jTextField4.getText().length() != 0 && vistarp.jTextField5.getText().length() != 0) {
                try {
                    int placa = Integer.parseInt(vistarp.jTextField1.getText());
                    String color = vistarp.jTextField2.getText();
                    String marca = vistarp.jTextField3.getText();
                    String modelo = vistarp.jTextField4.getText();
                    int id_residente = Integer.parseInt(vistarp.jTextField5.getText());
                    int id_parqueadero = Integer.parseInt(vistarp.jTextField6.getText());
                    PreparedStatement ps;
                    try {
                        ps = con.conexion().prepareStatement("insert into carro(placa,color,marca,modelo,id_residente,id_parqueadero)values('" + Integer.toString(placa) + "','" + color + "','" + marca + "','" + modelo + "','"
                                + Integer.toString(id_residente) + "','" + Integer.toString(id_parqueadero) + "')");
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Registro Almacenado correctamete");
                        vistarp.jTextField1.setText(null);
                        vistarp.jTextField2.setText(null);
                        vistarp.jTextField3.setText(null);
                        vistarp.jTextField4.setText(null);
                        vistarp.jTextField5.setText(null);

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
