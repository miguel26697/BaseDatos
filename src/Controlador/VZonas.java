/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Vista.VistaApar;
import Vista.VistaZonas;
import Vista.VistaZonas;
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
public class VZonas implements ActionListener {

    VistaApar vistabase = new VistaApar();
    VistaZonas vistazona = new VistaZonas();
    private conexion con;

    VZonas(VistaApar vistabase, VistaZonas vistazona, conexion con) {
        this.vistabase = vistabase;
        this.vistazona = vistazona;
        this.con = con;
        vistazona.jButton1.addActionListener(this);
        vistazona.jComboBox1.addActionListener(this);
        vistazona.jButton2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistazona.jButton2){
        vistazona.setVisible(false);
        vistabase.setVisible(true);
        }
        
        
        
        if (e.getSource() == vistazona.jButton1) {
            DefaultTableModel modelo = new DefaultTableModel();
            vistazona.jTable1.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;
            if ("Todos".equals(vistazona.jComboBox1.getSelectedItem().toString())) {
                try {

                    String clave = "select actividad, dia, fecha from usozona,zonas, residentes where usozona.id_residente = residentes.id_residente and usozona.id_zona = zonas.id_zona";

                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Tipo");
                    modelo.addColumn("Dia");
                    modelo.addColumn("Fecha");

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
            } else if ("Recreacion".equals(vistazona.jComboBox1.getSelectedItem().toString())) {
                try {

                    String clave = "select actividad, dia, fecha from usozona,zonas, residentes where 'recreacion'=actividad and usozona.id_residente = residentes.id_residente and usozona.id_zona = zonas.id_zona";

                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Tipo");
                    modelo.addColumn("Dia");
                    modelo.addColumn("Fecha");

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
            } else if ("Salones".equals(vistazona.jComboBox1.getSelectedItem().toString())) {
                try {

                    String clave = "select actividad, dia, fecha from usozona,zonas, residentes where 'salones'=actividad and usozona.id_residente = residentes.id_residente and usozona.id_zona = zonas.id_zona";
                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Tipo");
                    modelo.addColumn("Dia");
                    modelo.addColumn("Fecha");

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
        }
    }

}
