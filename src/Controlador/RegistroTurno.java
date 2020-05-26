/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VistaBase;
import Vista.VistaRegistroturno;
import conjunto.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author migue
 */
public class RegistroTurno implements ActionListener {

    private VistaBase VistaBase;
    private VistaRegistroturno vistarp;
    private conexion con;

    public RegistroTurno(VistaBase VistaBase, VistaRegistroturno vistarp, conexion con) {
        this.vistarp = vistarp;
        this.VistaBase = VistaBase;
        this.con = con;
        this.vistarp.jButton1.addActionListener(this);
        this.vistarp.jButton2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistarp.jButton1) {
            if (vistarp.jTextField1.getText().length() != 0 && vistarp.jTextField2.getText().length() != 0 && vistarp.jTextField3.getText().length() != 0 && vistarp.jTextField4.getText().length() != 0&& vistarp.jTextField5.getText().length() != 0&& vistarp.jTextField6.getText().length() != 0) {
                try {
                    int id_turno = Integer.parseInt(vistarp.jTextField1.getText());
                    String pago_hora = vistarp.jTextField2.getText();
                    String tipo = vistarp.jTextField3.getText();
                    String dias = vistarp.jTextField4.getText();
                    String horarioE = vistarp.jTextField5.getText();
                    String horarioS = vistarp.jTextField6.getText();
                    
                  

                    PreparedStatement ps;
                    try {
                        ps = con.conexion().prepareStatement("insert into turnos(id_turno,pago_hora,tipo,dias,horario_entrada,horario_salida)values('" + Integer.toString(id_turno) + "','" + pago_hora + "','" + tipo + "','" + dias + "','" + horarioE + "','" + horarioS + "')");
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Registro Almacenado correctamete");
                        vistarp.jTextField1.setText(null);
                        vistarp.jTextField2.setText(null);
                        vistarp.jTextField3.setText(null);
                        vistarp.jTextField4.setText(null);
                        vistarp.jTextField5.setText(null);
                        vistarp.jTextField6.setText(null);

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
            vistarp.jTextField1.setText(null);
                        vistarp.jTextField2.setText(null);
                        vistarp.jTextField3.setText(null);
                        vistarp.jTextField4.setText(null);
                        vistarp.jTextField5.setText(null);
                        vistarp.jTextField6.setText(null);
           
            vistarp.dispose();
            VistaBase.setVisible(true);
        }

    }
}

