/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VistaBase;
import Vista.VistaTrab;
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
public class VTrabajadores implements ActionListener {

    VistaBase vb = new VistaBase();
    VistaTrab vt = new VistaTrab();
    private conexion con;

    public VTrabajadores(VistaBase vb, VistaTrab vt, conexion con) {
        this.vb = vb;
        this.vt = vt;
        this.con = con;
        vt.jComboBox1.addActionListener(this);
        vt.jTextField1.addActionListener(this);
        vt.jButton1.addActionListener(this);
        vt.jButton2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vt.jButton2) {

            DefaultTableModel modelo = new DefaultTableModel();
            vt.jTable1.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;
            if ("Todos".equals(vt.jComboBox1.getSelectedItem().toString())) {
                try {

                    String clave = "select id_trabajdor, nombre, apellidos, direccion, telefono, pago_hora, eps, caja_com, tipoemp.tipo, fecha_inicio, dias, turnos.tipo, horario_entrada, horario_salida from trabajadores, turnos, tipoemp\n"
                            + "where turnos.id_turno = trabajadores.id_turno and trabajadores.id_tipo = tipoemp.id_tipo;";

                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Apellido");
                    modelo.addColumn("Direccion");
                    modelo.addColumn("Telefono");
                    modelo.addColumn("Salario");
                    modelo.addColumn("Eps");
                    modelo.addColumn("Caja compensacion");
                    modelo.addColumn("Tipo");
                    modelo.addColumn("Fecha inicio");
                    modelo.addColumn("Dias");
                    modelo.addColumn("Tipo-horario");
                    modelo.addColumn("Horario entrada");
                    modelo.addColumn("Horario salida");

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
            }else if("Id".equals(vt.jComboBox1.getSelectedItem().toString())){
                try {

                    String clave = "select id_trabajdor, nombre, apellidos, direccion, telefono, pago_hora, eps, caja_com, tipoemp.tipo, fecha_inicio, dias, turnos.tipo, horario_entrada, horario_salida from trabajadores, turnos, tipoemp\n"
                            + "where '"+vt.jTextField1.getText()+"'=id_trabajdor and turnos.id_turno = trabajadores.id_turno and trabajadores.id_tipo = tipoemp.id_tipo;";

                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Apellido");
                    modelo.addColumn("Direccion");
                    modelo.addColumn("Telefono");
                    modelo.addColumn("Salario");
                    modelo.addColumn("Eps");
                    modelo.addColumn("Caja compensacion");
                    modelo.addColumn("Tipo");
                    modelo.addColumn("Fecha inicio");
                    modelo.addColumn("Dias");
                    modelo.addColumn("Tipo-horario");
                    modelo.addColumn("Horario entrada");
                    modelo.addColumn("Horario salida");

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

                
            }else if("Nombre".equals(vt.jComboBox1.getSelectedItem().toString())){
                try {

                    String clave = "select id_trabajdor, nombre, apellidos, direccion, telefono, pago_hora, eps, caja_com, tipoemp.tipo, fecha_inicio, dias, turnos.tipo, horario_entrada, horario_salida from trabajadores, turnos, tipoemp\n"
                            + "where '"+vt.jTextField1.getText()+"'=nombre and turnos.id_turno = trabajadores.id_turno and trabajadores.id_tipo = tipoemp.id_tipo;";

                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Apellido");
                    modelo.addColumn("Direccion");
                    modelo.addColumn("Telefono");
                    modelo.addColumn("Salario");
                    modelo.addColumn("Eps");
                    modelo.addColumn("Caja compensacion");
                    modelo.addColumn("Tipo");
                    modelo.addColumn("Fecha inicio");
                    modelo.addColumn("Dias");
                    modelo.addColumn("Tipo-horario");
                    modelo.addColumn("Horario entrada");
                    modelo.addColumn("Horario salida");

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

                
            }else if("Apellido".equals(vt.jComboBox1.getSelectedItem().toString())){
                try {

                    String clave = "select id_trabajdor, nombre, apellidos, direccion, telefono, pago_hora, eps, caja_com, tipoemp.tipo, fecha_inicio, dias, turnos.tipo, horario_entrada, horario_salida from trabajadores, turnos, tipoemp\n"
                            + "where '"+vt.jTextField1.getText()+"'=apellidos and turnos.id_turno = trabajadores.id_turno and trabajadores.id_tipo = tipoemp.id_tipo;";

                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Apellido");
                    modelo.addColumn("Direccion");
                    modelo.addColumn("Telefono");
                    modelo.addColumn("Salario");
                    modelo.addColumn("Eps");
                    modelo.addColumn("Caja compensacion");
                    modelo.addColumn("Tipo");
                    modelo.addColumn("Fecha inicio");
                    modelo.addColumn("Dias");
                    modelo.addColumn("Tipo-horario");
                    modelo.addColumn("Horario entrada");
                    modelo.addColumn("Horario salida");

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

                
            }else if("Telefono".equals(vt.jComboBox1.getSelectedItem().toString())){
                try {

                    String clave = "select id_trabajdor, nombre, apellidos, direccion, telefono, pago_hora, eps, caja_com, tipoemp.tipo, fecha_inicio, dias, turnos.tipo, horario_entrada, horario_salida from trabajadores, turnos, tipoemp\n"
                            + "where '"+vt.jTextField1.getText()+"'=telefono and turnos.id_turno = trabajadores.id_turno and trabajadores.id_tipo = tipoemp.id_tipo;";

                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Apellido");
                    modelo.addColumn("Direccion");
                    modelo.addColumn("Telefono");
                    modelo.addColumn("Salario");
                    modelo.addColumn("Eps");
                    modelo.addColumn("Caja compensacion");
                    modelo.addColumn("Tipo");
                    modelo.addColumn("Fecha inicio");
                    modelo.addColumn("Dias");
                    modelo.addColumn("Tipo-horario");
                    modelo.addColumn("Horario entrada");
                    modelo.addColumn("Horario salida");

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

                
            }else if("Tipo".equals(vt.jComboBox1.getSelectedItem().toString())){
                try {

                    String clave = "select id_trabajdor, nombre, apellidos, direccion, telefono, pago_hora, eps, caja_com, tipoemp.tipo, fecha_inicio, dias, turnos.tipo, horario_entrada, horario_salida from trabajadores, turnos, tipoemp\n"
                            + "where '"+vt.jTextField1.getText()+"'=tipoemp.tipo and turnos.id_turno = trabajadores.id_turno and trabajadores.id_tipo = tipoemp.id_tipo;";

                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Apellido");
                    modelo.addColumn("Direccion");
                    modelo.addColumn("Telefono");
                    modelo.addColumn("Salario");
                    modelo.addColumn("Eps");
                    modelo.addColumn("Caja compensacion");
                    modelo.addColumn("Tipo");
                    modelo.addColumn("Fecha inicio");
                    modelo.addColumn("Dias");
                    modelo.addColumn("Tipo-horario");
                    modelo.addColumn("Horario entrada");
                    modelo.addColumn("Horario salida");

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

                
            }else if("Tipo-horario".equals(vt.jComboBox1.getSelectedItem().toString())){
                try {

                    String clave = "select id_trabajdor, nombre, apellidos, direccion, telefono, pago_hora, eps, caja_com, tipoemp.tipo, fecha_inicio, dias, turnos.tipo, horario_entrada, horario_salida from trabajadores, turnos, tipoemp\n"
                            + "where '"+vt.jTextField1.getText()+"'=turnos.tipo and turnos.id_turno = trabajadores.id_turno and trabajadores.id_tipo = tipoemp.id_tipo;";

                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Apellido");
                    modelo.addColumn("Direccion");
                    modelo.addColumn("Telefono");
                    modelo.addColumn("Salario");
                    modelo.addColumn("Eps");
                    modelo.addColumn("Caja compensacion");
                    modelo.addColumn("Tipo");
                    modelo.addColumn("Fecha inicio");
                    modelo.addColumn("Dias");
                    modelo.addColumn("Tipo-horario");
                    modelo.addColumn("Horario entrada");
                    modelo.addColumn("Horario salida");

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

                
            }else if("Horario de inicio".equals(vt.jComboBox1.getSelectedItem().toString())){
                try {

                    String clave = "select id_trabajdor, nombre, apellidos, direccion, telefono, pago_hora, eps, caja_com, tipoemp.tipo, fecha_inicio, dias, turnos.tipo, horario_entrada, horario_salida from trabajadores, turnos, tipoemp\n"
                            + "where '"+vt.jTextField1.getText()+"'=horario_entrada and turnos.id_turno = trabajadores.id_turno and trabajadores.id_tipo = tipoemp.id_tipo;";

                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Apellido");
                    modelo.addColumn("Direccion");
                    modelo.addColumn("Telefono");
                    modelo.addColumn("Salario");
                    modelo.addColumn("Eps");
                    modelo.addColumn("Caja compensacion");
                    modelo.addColumn("Tipo");
                    modelo.addColumn("Fecha inicio");
                    modelo.addColumn("Dias");
                    modelo.addColumn("Tipo-horario");
                    modelo.addColumn("Horario entrada");
                    modelo.addColumn("Horario salida");

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

                
            }else if("Horario de salida".equals(vt.jComboBox1.getSelectedItem().toString())){
                try {

                    String clave = "select id_trabajdor, nombre, apellidos, direccion, telefono, pago_hora, eps, caja_com, tipoemp.tipo, fecha_inicio, dias, turnos.tipo, horario_entrada, horario_salida from trabajadores, turnos, tipoemp\n"
                            + "where '"+vt.jTextField1.getText()+"'=id_trabajdor and turnos.id_turno = trabajadores.id_turno and trabajadores.id_tipo = tipoemp.id_tipo;";

                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Apellido");
                    modelo.addColumn("Direccion");
                    modelo.addColumn("Telefono");
                    modelo.addColumn("Salario");
                    modelo.addColumn("Eps");
                    modelo.addColumn("Caja compensacion");
                    modelo.addColumn("Tipo");
                    modelo.addColumn("Fecha inicio");
                    modelo.addColumn("Dias");
                    modelo.addColumn("Tipo-horario");
                    modelo.addColumn("Horario entrada");
                    modelo.addColumn("Horario salida");

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

                
            }else if("Fecha de ingreso".equals(vt.jComboBox1.getSelectedItem().toString())){
                try {

                    String clave = "select id_trabajdor, nombre, apellidos, direccion, telefono, pago_hora, eps, caja_com, tipoemp.tipo, fecha_inicio, dias, turnos.tipo, horario_entrada, horario_salida from trabajadores, turnos, tipoemp\n"
                            + "where '"+vt.jTextField1.getText()+"'=fecha_inicio and turnos.id_turno = trabajadores.id_turno and trabajadores.id_tipo = tipoemp.id_tipo;";

                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id");
                    modelo.addColumn("Nombre");
                    modelo.addColumn("Apellido");
                    modelo.addColumn("Direccion");
                    modelo.addColumn("Telefono");
                    modelo.addColumn("Salario");
                    modelo.addColumn("Eps");
                    modelo.addColumn("Caja compensacion");
                    modelo.addColumn("Tipo");
                    modelo.addColumn("Fecha inicio");
                    modelo.addColumn("Dias");
                    modelo.addColumn("Tipo-horario");
                    modelo.addColumn("Horario entrada");
                    modelo.addColumn("Horario salida");

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
        
        if (e.getSource() == vt.jButton1) {
            vt.setVisible(false);
            vb.setVisible(true);
        }
    }

}
