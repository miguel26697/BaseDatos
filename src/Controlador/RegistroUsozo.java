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
import Vista.VistaApar;
import Vista.VistaRegistroUsozo;
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
public class RegistroUsozo implements ActionListener {

    private VistaApar VistaBase;
    private VistaRegistroUsozo vistarp;
    private conexion con;
    private int id_uso;

    public RegistroUsozo(VistaApar VistaBase, VistaRegistroUsozo vistarp, conexion con) {
        this.vistarp = vistarp;
        this.VistaBase = VistaBase;
        this.con = con;
        this.id_uso=0;
        this.vistarp.jButton1.addActionListener(this);
        this.vistarp.jButton2.addActionListener(this);
  
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistarp.jButton1) {
            if (vistarp.jTextField1.getText().length() != 0 && vistarp.jTextField2.getText().length() != 0 && vistarp.jTextField3.getText().length() != 0 && vistarp.jTextField4.getText().length() != 0 && vistarp.jTextField5.getText().length() != 0) {
                try {
                    vistarp.jTextField1.setText(Integer.toOctalString(id_uso));
                    int id_uso = Integer.parseInt(vistarp.jTextField1.getText());
                    String fecha = vistarp.jTextField2.getText();
                    String hora = vistarp.jTextField3.getText();
                    int id_residente = Integer.parseInt(vistarp.jTextField4.getText());
                    int id_zona = Integer.parseInt(vistarp.jTextField5.getText());
                    PreparedStatement ps;
                    try {
                        ps = con.conexion().prepareStatement("insert into usozona(id_uso,fecha,dia,id_residente,id_zona)values('" + Integer.toString(id_uso) + "','" + fecha + "','"
                                + hora + "','" + Integer.toString(id_residente) + "','" + Integer.toString(id_zona) + "')");
                        ps.executeUpdate();
                        this.id_uso++;
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
