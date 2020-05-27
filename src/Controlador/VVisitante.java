/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VistaBase;
import Vista.VistaVisitante;
import conjunto.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author david
 */
public class VVisitante implements ActionListener {
    
    VistaBase vb = new VistaBase();
    VistaVisitante vv = new VistaVisitante();
    private conexion con;
    
    public VVisitante(VistaBase vb, VistaVisitante vv, conexion con) {
        this.vb = vb;
        this.vv = vv;
        this.con = con;
        this.vv.jButton1.addActionListener(this);
        this.vv.jButton2.addActionListener(this);
        this.vv.jComboBox1.addActionListener(this);
        this.vv.jTextField1.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vv.jButton1) {
            DefaultTableModel modelo = new DefaultTableModel();
            vv.jTable1.setModel(modelo);
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            if ("Todos".equals(vv.jComboBox1.getSelectedItem().toString())) {
                try {
                    
                    String clave = "select id_visitante, visitante.nombre, visitante.apellidos,fecha,carro,placa, visitante.id_apto, residentes.telefono from visitante,apto,residentes\n"
                            + "where visitante.id_apto = apto.id_apto and apto.id_apto = residentes.id_apto;";
                    
                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();
                    
                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();
                    
                    modelo.addColumn("Id");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Apellido");
                    modelo.addColumn("Fecha");
                    modelo.addColumn("Carro");
                    modelo.addColumn("Placa");
                    modelo.addColumn("Apartamento");
                    modelo.addColumn("Telefono apartamento");
                    
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
            } else if ("Id".equals(vv.jComboBox1.getSelectedItem().toString())) {
                try {
                    
                    String clave = "select id_visitante, visitante.nombre, visitante.apellidos,fecha,carro,placa, visitante.id_apto, residentes.telefono from visitante,apto,residentes\n"
                            + "where '" + vv.jTextField1.getText() + "' = id_visitante and visitante.id_apto = apto.id_apto and apto.id_apto = residentes.id_apto;";
                    
                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();
                    
                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();
                    
                    modelo.addColumn("Id");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Apellido");
                    modelo.addColumn("Fecha");
                    modelo.addColumn("Carro");
                    modelo.addColumn("Placa");
                    modelo.addColumn("Apartamento");
                    modelo.addColumn("Telefono apartamento");
                    
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
            } else if ("Nombre".equals(vv.jComboBox1.getSelectedItem().toString())) {
                try {
                    
                    String clave = "select id_visitante, visitante.nombre, visitante.apellidos,fecha,carro,placa, visitante.id_apto, residentes.telefono from visitante,apto,residentes\n"
                            + "where '" + vv.jTextField1.getText() + "' = visitante.nombre and visitante.id_apto = apto.id_apto and apto.id_apto = residentes.id_apto;";
                    
                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();
                    
                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();
                    
                    modelo.addColumn("Id");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Apellido");
                    modelo.addColumn("Fecha");
                    modelo.addColumn("Carro");
                    modelo.addColumn("Placa");
                    modelo.addColumn("Apartamento");
                    modelo.addColumn("Telefono apartamento");
                    
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
            } else if ("Apellidos".equals(vv.jComboBox1.getSelectedItem().toString())) {
                try {
                    
                    String clave = "select id_visitante, visitante.nombre, visitante.apellidos,fecha,carro,placa, visitante.id_apto, residentes.telefono from visitante,apto,residentes\n"
                            + "where '" + vv.jTextField1.getText() + "' = visitante.apellidos and visitante.id_apto = apto.id_apto and apto.id_apto = residentes.id_apto;";
                    
                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();
                    
                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();
                    
                    modelo.addColumn("Id");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Apellido");
                    modelo.addColumn("Fecha");
                    modelo.addColumn("Carro");
                    modelo.addColumn("Placa");
                    modelo.addColumn("Apartamento");
                    modelo.addColumn("Telefono apartamento");
                    
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
            }
        } else if (e.getSource() == vv.jButton2) {
            vv.setVisible(false);
            vb.setVisible(true);
        }
    }
    
}
