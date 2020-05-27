/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VistaBase;
import Vista.VistaResS;
import conjunto.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class VResidentes implements ActionListener {

    VistaResS vistars = new VistaResS();
    VistaBase vistabase = new VistaBase();
    private conexion con;

    VResidentes(VistaResS vistars, VistaBase vistabase, conexion con) {
        this.vistars = vistars;
        this.vistabase = vistabase;
        this.con = con;
        vistars.jComboBox1.addActionListener(this);
        vistars.jTextField1.addActionListener(this);
        vistars.jButton1.addActionListener(this);
        vistars.jButton2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistars.jButton1) {
            DefaultTableModel modelo = new DefaultTableModel();
            vistars.jTable1.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;

            if ("Todos".equals(vistars.jComboBox1.getSelectedItem().toString())) {
                try {

                    String clave = "select id_propietarios, propietarios.nombres, propietarios.apellidos, residentes.id_residente, residentes.nombre, residentes.apellidos,apto.id_apto,pp,placa,modelo,bahia from propietarios, residentes, apto, parqueadero, carro where\n"
                            + "propietarios.id_propietarios = apto.id_propietario and apto.id_apto = residentes.id_apto and residentes.id_residente = parqueadero.id_residente  and carro.id_parqueadero = parqueadero.id_parqueadero";

                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id propietario");
                    modelo.addColumn("Nombre propietario");
                    modelo.addColumn("Apellido propietario");
                    modelo.addColumn("Id residente");
                    modelo.addColumn("Nombre R");
                    modelo.addColumn("Apellidos R");
                    modelo.addColumn("Apartamento");
                    modelo.addColumn("Parqueadero");
                    modelo.addColumn("Placa");
                    modelo.addColumn("Carro");
                    modelo.addColumn("Bahia");

                    while (rs.next()) {

                        Object[] filas = new Object[cantidadColumnas];

                        for (int i = 0; i < cantidadColumnas; i++) {
                            filas[i] = rs.getObject(i + 1);
                        }

                        modelo.addRow(filas);

                        //JOptionPane.showMessageDialog(null, "Ingresa");
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

            } else if ("Id".equals(vistars.jComboBox1.getSelectedItem().toString())) {
                try {

                    String clave = "select id_propietarios, propietarios.nombres, propietarios.apellidos, residentes.id_residente, residentes.nombre, residentes.apellidos,apto.id_apto,pp,placa,modelo,bahia from propietarios, residentes, apto, parqueadero, carro where\n"
                            + "'"+vistars.jTextField1.getText()+"' = id_residente and propietarios.id_propietarios = apto.id_propietario and apto.id_apto = residentes.id_apto and residentes.id_residente = parqueadero.id_residente  and carro.id_parqueadero = parqueadero.id_parqueadero";

                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id propietario");
                    modelo.addColumn("Nombre propietario");
                    modelo.addColumn("Apellido propietario");
                    modelo.addColumn("Id residente");
                    modelo.addColumn("Nombre R");
                    modelo.addColumn("Apellidos R");
                    modelo.addColumn("Apartamento");
                    modelo.addColumn("Parqueadero");
                    modelo.addColumn("Placa");
                    modelo.addColumn("Carro");
                    modelo.addColumn("Bahia");

                    while (rs.next()) {

                        Object[] filas = new Object[cantidadColumnas];

                        for (int i = 0; i < cantidadColumnas; i++) {
                            filas[i] = rs.getObject(i + 1);
                        }

                        modelo.addRow(filas);

                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            } else if ("Nombre".equals(vistars.jComboBox1.getSelectedItem().toString())) {
                try {

                    String clave = "select id_propietarios, propietarios.nombres, propietarios.apellidos, residentes.id_residente, residentes.nombre, residentes.apellidos,apto.id_apto,pp,placa,modelo,bahia from propietarios, residentes, apto, parqueadero, carro where\n"
                            + "'"+vistars.jTextField1.getText()+"' = residentes.nombre and propietarios.id_propietarios = apto.id_propietario and apto.id_apto = residentes.id_apto and residentes.id_residente = parqueadero.id_residente  and carro.id_parqueadero = parqueadero.id_parqueadero";

                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id propietario");
                    modelo.addColumn("Nombre propietario");
                    modelo.addColumn("Apellido propietario");
                    modelo.addColumn("Id residente");
                    modelo.addColumn("Nombre R");
                    modelo.addColumn("Apellidos R");
                    modelo.addColumn("Apartamento");
                    modelo.addColumn("Parqueadero");
                    modelo.addColumn("Placa");
                    modelo.addColumn("Carro");
                    modelo.addColumn("Bahia");

                    while (rs.next()) {

                        Object[] filas = new Object[cantidadColumnas];

                        for (int i = 0; i < cantidadColumnas; i++) {
                            filas[i] = rs.getObject(i + 1);
                        }

                        modelo.addRow(filas);

                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            } else if ("Apellido".equals(vistars.jComboBox1.getSelectedItem().toString())) {
                try {

                    String clave = "select id_propietarios, propietarios.nombres, propietarios.apellidos, residentes.id_residente, residentes.nombre, residentes.apellidos,apto.id_apto,pp,placa,modelo,bahia from propietarios, residentes, apto, parqueadero, carro where\n"
                            + "'"+vistars.jTextField1.getText()+"' = residentes.apellidos and propietarios.id_propietarios = apto.id_propietario and apto.id_apto = residentes.id_apto and residentes.id_residente = parqueadero.id_residente  and carro.id_parqueadero = parqueadero.id_parqueadero";

                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id propietario");
                    modelo.addColumn("Nombre propietario");
                    modelo.addColumn("Apellido propietario");
                    modelo.addColumn("Id residente");
                    modelo.addColumn("Nombre R");
                    modelo.addColumn("Apellidos R");
                    modelo.addColumn("Apartamento");
                    modelo.addColumn("Parqueadero");
                    modelo.addColumn("Placa");
                    modelo.addColumn("Carro");
                    modelo.addColumn("Bahia");

                    while (rs.next()) {

                        Object[] filas = new Object[cantidadColumnas];

                        for (int i = 0; i < cantidadColumnas; i++) {
                            filas[i] = rs.getObject(i + 1);
                        }

                        modelo.addRow(filas);

                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            } else if ("Placa".equals(vistars.jComboBox1.getSelectedItem().toString())) {
                try {

                    String clave = "select id_propietarios, propietarios.nombres, propietarios.apellidos, residentes.id_residente, residentes.nombre, residentes.apellidos,apto.id_apto,pp,placa,modelo,bahia from propietarios, residentes, apto, parqueadero, carro where\n"
                            + "'"+vistars.jTextField1.getText()+"' = placa and propietarios.id_propietarios = apto.id_propietario and apto.id_apto = residentes.id_apto and residentes.id_residente = parqueadero.id_residente  and carro.id_parqueadero = parqueadero.id_parqueadero";

                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id propietario");
                    modelo.addColumn("Nombre propietario");
                    modelo.addColumn("Apellido propietario");
                    modelo.addColumn("Id residente");
                    modelo.addColumn("Nombre R");
                    modelo.addColumn("Apellidos R");
                    modelo.addColumn("Apartamento");
                    modelo.addColumn("Parqueadero");
                    modelo.addColumn("Placa");
                    modelo.addColumn("Carro");
                    modelo.addColumn("Bahia");

                    while (rs.next()) {

                        Object[] filas = new Object[cantidadColumnas];

                        for (int i = 0; i < cantidadColumnas; i++) {
                            filas[i] = rs.getObject(i + 1);
                        }

                        modelo.addRow(filas);

                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            } else if ("Con carro".equals(vistars.jComboBox1.getSelectedItem().toString())) {
                try {

                    String clave = "select id_propietarios, propietarios.nombres, propietarios.apellidos, residentes.id_residente, residentes.nombre, residentes.apellidos,apto.id_apto,pp,placa,modelo,bahia from propietarios, residentes, apto, parqueadero, carro where\n"
                            + "propietarios.id_propietarios = apto.id_propietario and apto.id_apto = residentes.id_apto and residentes.id_residente = parqueadero.id_residente and pp = 'si' and  carro.id_parqueadero = parqueadero.id_parqueadero";

                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id propietario");
                    modelo.addColumn("Nombre propietario");
                    modelo.addColumn("Apellido propietario");
                    modelo.addColumn("Id residente");
                    modelo.addColumn("Nombre R");
                    modelo.addColumn("Apellidos R");
                    modelo.addColumn("Apartamento");
                    modelo.addColumn("Parqueadero");
                    modelo.addColumn("Placa");
                    modelo.addColumn("Carro");
                    modelo.addColumn("Bahia");

                    while (rs.next()) {

                        Object[] filas = new Object[cantidadColumnas];

                        for (int i = 0; i < cantidadColumnas; i++) {
                            filas[i] = rs.getObject(i + 1);
                        }

                        modelo.addRow(filas);

                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        } else if (e.getSource() == vistars.jButton2) {
            vistars.setVisible(false);
            vistabase.setVisible(true);
        }

    }

}
