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
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author migue
 */
public class RegistroUsozo implements ActionListener {

    private VistaApar VistaBase;
    private VistaRegistroUsozo vistarp;
    private conexion con;


    public RegistroUsozo(VistaApar VistaBase, VistaRegistroUsozo vistarp, conexion con) {
        this.vistarp = vistarp;
        this.VistaBase = VistaBase;
        this.con = con;
        this.vistarp.jButton1.addActionListener(this);
        this.vistarp.jButton2.addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistarp.jButton1) {
            if (vistarp.jTextField2.getText().length() != 0 && vistarp.jTextField3.getText().length() != 0 && vistarp.jTextField4.getText().length() != 0 && vistarp.jTextField5.getText().length() != 0) {
                try {
       
              
                    String fecha = vistarp.jTextField2.getText();
                    String hora = vistarp.jTextField3.getText();
                    int id_residente = Integer.parseInt(vistarp.jTextField4.getText());
                    int id_zona = Integer.parseInt(vistarp.jTextField5.getText());
                    PreparedStatement ps,pp;
                    ResultSet rs;
                    try {
                        
                        ps = con.conexion().prepareStatement("insert into usozona(fecha,dia,id_residente,id_zona)values('" + fecha + "','"
                                + hora + "','" + Integer.toString(id_residente) + "','" + id_zona + "')");
                         ps.executeUpdate();
                    
                        JOptionPane.showMessageDialog(null, "Registro Almacenado correctamete");
                       
                
                        vistarp.jTextField2.setText(null);
                        vistarp.jTextField3.setText(null);
                        vistarp.jTextField4.setText(null);
                        vistarp.jTextField5.setText(null);

                    } catch (Exception x) {
               
                   
                         JOptionPane.showMessageDialog(null, "HORA NO DISPONIBLE"+x.getMessage());
                   
                      
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
