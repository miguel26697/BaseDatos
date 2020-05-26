/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Jairo
 */
import Vista.VistaBase;
import Vista.VistaPropietarios;
import conjunto.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author david
 */
public class VPropietarios implements ActionListener {

    VistaPropietarios vp = new VistaPropietarios();
    VistaBase vb = new VistaBase();
    private conexion con1;

    public VPropietarios(VistaPropietarios vp, VistaBase vb, conexion con1) {
        this.vp = vp;
        this.vb = vb;
        this.con1 = con1;
        this.vp.jButton1.addActionListener(this);
        this.vp.jButton2.addActionListener(this);
        this.vp.jComboBox1.addActionListener(this);
        this.vp.jTextField1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent x) {
        if (x.getSource() == vp.jButton2) {
            if ("Todos".equals(vp.jComboBox1.getSelectedItem().toString())) {
                try {

                    DefaultTableModel modelo = new DefaultTableModel();
                    vp.jTable1.setModel(modelo);

                    PreparedStatement ps = null;
                    ResultSet rs = null;

                    String clave = "select propietarios.id_propietarios, nombres, apellidos, telefono,id_apto, valor,fecha_exp, fecha_lim from propietarios, apto, recibo where\n"
                            + "propietarios.id_propietarios = apto.id_propietario and propietarios.id_propietarios= recibo.id_propietarios";
                    

                    ps = con1.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Apellido");
                    modelo.addColumn("Telefono");
                    modelo.addColumn("Apartamento");
                    modelo.addColumn("Valor recibo");
                    modelo.addColumn("Fecha exp");
                    modelo.addColumn("Fecha limite");

                    while (rs.next()) {

                        Object[] filas = new Object[cantidadColumnas];

                        for (int i = 0; i < cantidadColumnas; i++) {
                            filas[i] = rs.getObject(i + 1);
                        }

                        modelo.addRow(filas);

                        //JOptionPane.showMessageDialog(null, "Ingresa");
                    }
                } catch (SQLException ex) {
                    System.out.println("Fuck");
                }
                //JOptionPane.showMessageDialog(null, "Todos");
            } else if ("Id".equals(vp.jComboBox1.getSelectedItem().toString())) {
                try {

                    DefaultTableModel modelo = new DefaultTableModel();
                    vp.jTable1.setModel(modelo);

                    PreparedStatement ps = null;
                    ResultSet rs = null;


                    String clave = "select propietarios.id_propietarios, nombres, apellidos, telefono,id_apto, valor,fecha_exp, fecha_lim from propietarios, apto, recibo where\n"
                            + "'" + vp.jTextField1.getText() + "'=propietarios.id_propietarios and '" + vp.jTextField1.getText() + "' = apto.id_propietario and '" + vp.jTextField1.getText() + "'= recibo.id_propietarios;";
                   
                    ps = con1.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Apellido");
                    modelo.addColumn("Telefono");
                    modelo.addColumn("Apartamento");
                    modelo.addColumn("Valor recibo");
                    modelo.addColumn("Fecha exp");
                    modelo.addColumn("Fecha limite");

                    while (rs.next()) {

                        Object[] filas = new Object[cantidadColumnas];

                        for (int i = 0; i < cantidadColumnas; i++) {
                            filas[i] = rs.getObject(i + 1);
                        }

                        modelo.addRow(filas);

                    }
                } catch (SQLException ex) {
                    System.out.println("Fuck");
                };
            } else if ("Nombre".equals(vp.jComboBox1.getSelectedItem().toString())) {
                try {

                    DefaultTableModel modelo = new DefaultTableModel();
                    vp.jTable1.setModel(modelo);

                    PreparedStatement ps = null;
                    ResultSet rs = null;


                    String clave = "select propietarios.id_propietarios, nombres, apellidos, telefono,id_apto, valor,fecha_exp, fecha_lim from propietarios, apto, recibo where\n"
                            + "'" + vp.jTextField1.getText() + "'=nombres and  propietarios.id_propietarios = apto.id_propietario and propietarios.id_propietarios= recibo.id_propietarios;";

                    ps = con1.conexion().prepareStatement(clave);;
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Apellido");
                    modelo.addColumn("Telefono");
                    modelo.addColumn("Apartamento");
                    modelo.addColumn("Valor recibo");
                    modelo.addColumn("Fecha exp");
                    modelo.addColumn("Fecha limite");

                    while (rs.next()) {

                        Object[] filas = new Object[cantidadColumnas];

                        for (int i = 0; i < cantidadColumnas; i++) {
                            filas[i] = rs.getObject(i + 1);
                        }

                        modelo.addRow(filas);

                    }
                } catch (SQLException ex) {
                    System.out.println("Fuck");
                }

            } else if ("Apellido".equals(vp.jComboBox1.getSelectedItem().toString())) {
                try {

                    DefaultTableModel modelo = new DefaultTableModel();
                    vp.jTable1.setModel(modelo);

                    PreparedStatement ps = null;
                    ResultSet rs = null;

                    String clave = "select propietarios.id_propietarios, nombres, apellidos, telefono,id_apto, valor,fecha_exp, fecha_lim from propietarios, apto, recibo where\n"
                            + "'" + vp.jTextField1.getText() + "'=apellidos and  propietarios.id_propietarios = apto.id_propietario and propietarios.id_propietarios= recibo.id_propietarios;";

                    ps = con1.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Apellido");
                    modelo.addColumn("Telefono");
                    modelo.addColumn("Apartamento");
                    modelo.addColumn("Valor recibo");
                    modelo.addColumn("Fecha exp");
                    modelo.addColumn("Fecha limite");

                    while (rs.next()) {

                        Object[] filas = new Object[cantidadColumnas];

                        for (int i = 0; i < cantidadColumnas; i++) {
                            filas[i] = rs.getObject(i + 1);
                        }

                        modelo.addRow(filas);

                    }
                } catch (SQLException ex) {
                    System.out.println("Fuck");
                }
            } else if ("Telefono".equals(vp.jComboBox1.getSelectedItem().toString())) {
                try {

                    DefaultTableModel modelo = new DefaultTableModel();
                    vp.jTable1.setModel(modelo);

                    PreparedStatement ps = null;
                    ResultSet rs = null;

                    String clave = "select propietarios.id_propietarios, nombres, apellidos, telefono,id_apto, valor,fecha_exp, fecha_lim from propietarios, apto, recibo where\n"
                            + "'" + vp.jTextField1.getText() + "'=telefono and  propietarios.id_propietarios = apto.id_propietario and propietarios.id_propietarios= recibo.id_propietarios;";

                    ps = con1.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Apellido");
                    modelo.addColumn("Telefono");
                    modelo.addColumn("Apartamento");
                    modelo.addColumn("Valor recibo");
                    modelo.addColumn("Fecha exp");
                    modelo.addColumn("Fecha limite");

                    while (rs.next()) {

                        Object[] filas = new Object[cantidadColumnas];

                        for (int i = 0; i < cantidadColumnas; i++) {
                            filas[i] = rs.getObject(i + 1);
                        }

                        modelo.addRow(filas);

                    }
                } catch (SQLException ex) {
                    System.out.println("Fuck");
                }

            } else if ("Al dia".equals(vp.jComboBox1.getSelectedItem().toString())) {
                try {

                    DefaultTableModel modelo = new DefaultTableModel();
                    vp.jTable1.setModel(modelo);

                    PreparedStatement ps = null;
                    ResultSet rs = null;

                    String clave = "select propietarios.id_propietarios, nombres, apellidos, telefono,id_apto, valor,fecha_exp, fecha_lim from propietarios, apto, recibo, pago where\n"
                            + "propietarios.id_propietarios = apto.id_propietario and propietarios.id_propietarios= recibo.id_propietarios and recibo.id_recibo=pago.id_recibo and pagor='si'";

                    ps = con1.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Apellido");
                    modelo.addColumn("Telefono");
                    modelo.addColumn("Apartamento");
                    modelo.addColumn("Valor recibo");
                    modelo.addColumn("Fecha exp");
                    modelo.addColumn("Fecha limite");
                    
                    while (rs.next()) {

                        Object[] filas = new Object[cantidadColumnas];

                        for (int i = 0; i < cantidadColumnas; i++) {
                            filas[i] = rs.getObject(i + 1);
                        }

                        modelo.addRow(filas);

                        //JOptionPane.showMessageDialog(null, "Ingresa");
                    }
                } catch (SQLException ex) {
                    System.out.println("Fuck");
                }
            } else if ("Morosos".equals(vp.jComboBox1.getSelectedItem().toString())) {
                try {

                    DefaultTableModel modelo = new DefaultTableModel();
                    vp.jTable1.setModel(modelo);

                    PreparedStatement ps = null;
                    ResultSet rs = null;

                    String clave = "select propietarios.id_propietarios, nombres, apellidos, telefono,id_apto, valor,fecha_exp, fecha_lim from propietarios, apto, recibo, pago where\n"
                            + "propietarios.id_propietarios = apto.id_propietario and propietarios.id_propietarios= recibo.id_propietarios and recibo.id_recibo=pago.id_recibo and pagor='no'";

                    ps = con1.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Apellido");
                    modelo.addColumn("Telefono");
                    modelo.addColumn("Apartamento");
                    modelo.addColumn("Valor recibo");
                    modelo.addColumn("Fecha exp");
                    modelo.addColumn("Fecha limite");
                    
                    while (rs.next()) {

                        Object[] filas = new Object[cantidadColumnas];

                        for (int i = 0; i < cantidadColumnas; i++) {
                            filas[i] = rs.getObject(i + 1);
                        }

                        modelo.addRow(filas);

                        //JOptionPane.showMessageDialog(null, "Ingresa");
                    }
                } catch (SQLException ex) {
                    System.out.println("Fuck");
                }
            }
            
        } else if (x.getSource() == vp.jButton1) {
            vp.setVisible(false);
            vb.setVisible(true);
        }

    }

}