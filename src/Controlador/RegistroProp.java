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
public class RegistroProp {

    private VistaBase VistaBase;
    private VistaRegistroP vistarp;
    private conexion con;

    public RegistroProp(VistaBase VistaBase, VistaRegistroP vistarp, conexion con) {
        this.VistaBase = VistaBase;
        this.vistarp = vistarp;
        this.con = con;
        this.vistarp.jButton1.addActionListener((ActionListener) this);

    }

    public void actionPerformed(ActionEvent x) {

        if (x.getSource() == vistarp.jButton1) {
            String id = vistarp.jTextField1.getText();
            String nombre = vistarp.jTextField2.getText();
            String apellido = vistarp.jTextField3.getText();
            String telefono = vistarp.jTextField4.getText();
            String torre = vistarp.jComboBox2.getActionCommand();
            String apartamento = vistarp.jComboBox3.getActionCommand();
            String tipo = vistarp.jTextField5.getText();
            
            System.out.println(""+id);
            System.out.println(""+nombre);
            System.out.println(""+apellido);
            System.out.println(""+torre);
            System.out.println(""+apartamento);
            System.out.println(""+id);
            
            try {
                String sql = "insert into tblnotas (codigo_materia,identificacion_es,identificacion_pro,nota,fecha_nota) values (?,?,?,?,?)";
                PreparedStatement pst = con.conexion().prepareStatement(sql);
                pst.setString(1, id);
                pst.setString(2, nombre);
                pst.setString(3, apellido);
                pst.setString(4, telefono);
                //pst.setString(5, torre);
                int registro = pst.executeUpdate();
                if (registro > 0) {
                    JOptionPane.showMessageDialog(null, "Registro Almacenamiento correctamete");
                    
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "registro no actulizado" + e.getMessage());
            }

        }

    }

}
