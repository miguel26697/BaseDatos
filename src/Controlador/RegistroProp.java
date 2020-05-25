/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.VistaBase;
import Vista.VistaPropietarios;
import Vista.VistaRegistoTrab;
import Vista.VistaRegistroP;
import Vista.VistaRegistroResid;
import Vista.VistaResS;
import Vista.VistaTraRes;
import Vista.VistaTrab;
import Vista.VistaZonas;
import Vista.vistaingreso;
import conjunto.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author migue
 */
public class RegistroProp implements ActionListener {

    private VistaBase VistaBase;
    private VistaRegistroP vistarp;
    private conexion con;

    public RegistroProp(VistaBase VistaBase,VistaRegistroP vistarp, conexion con) {
        this.vistarp = vistarp;
        this.VistaBase = VistaBase;
        this.con = con;
        this.vistarp.jButton1.addActionListener(this);
        this.vistarp.jButton2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistarp.jButton1) {
        if (vistarp.jTextField1.getText().length() != 0 && vistarp.jTextField2.getText().length() != 0 && vistarp.jTextField3.getText().length() != 0 && vistarp.jTextField4.getText().length() != 0) {
            try{
            int id = Integer.parseInt(vistarp.jTextField1.getText());
            String nombre = vistarp.jTextField2.getText();
            String apellido = vistarp.jTextField3.getText();
            String telefono = vistarp.jTextField4.getText();
            PreparedStatement ps;
                try {
                    ps = con.conexion().prepareStatement("insert into propietarios(id_propietarios,nombres,apellidos,telefono)values('" + Integer.toString(id) + "','" + nombre + "','" + apellido + "','" + telefono + "')");
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Registro Almacenado correctamete");
                    vistarp.jTextField1.setText(null);
                    vistarp.jTextField2.setText(null);
                    vistarp.jTextField3.setText(null);
                    vistarp.jTextField4.setText(null);

                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null, "Registro no Almacenado " + x.getMessage());
                    System.out.println(""+x);
                } 
            }catch(NumberFormatException a){
                JOptionPane.showMessageDialog(null, " El ID debe ser un numero ");
            }
                   
            } else {
                JOptionPane.showMessageDialog(null, " Complete los campos ");
            }
        }
        if(e.getSource() == vistarp.jButton2){
            vistarp.setVisible(false);
            vistarp.dispose();
            VistaBase.setVisible(true);
     }

    }

}
