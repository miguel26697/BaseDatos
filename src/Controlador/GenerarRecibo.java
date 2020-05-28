/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VistaBase;
import Vista.VistaPagoRecibos;
import Vista.VistaRecibos;
import Vista.VistaVisitante;
import conjunto.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author migue
 */
public class GenerarRecibo implements ActionListener {

    VistaBase vb = new VistaBase();
    VistaRecibos vv = new VistaRecibos();
    VistaPagoRecibos vp = new VistaPagoRecibos();
    private conexion con;
    int cont = 0;
    String mes = "";
    String mes2 = "";
    int año = 0;
    int valor = 0;
    ArrayList<String> propietarios = new ArrayList<String>();

    public GenerarRecibo(VistaBase vb, VistaRecibos vv, conexion con, VistaPagoRecibos vp) {
        this.vb = vb;
        this.vv = vv;
        this.vp = vp;
        this.con = con;
        this.vv.jButton1.addActionListener(this);
        this.vv.jButton2.addActionListener(this);
        this.vp.btnaceptar.addActionListener(this);
        this.vp.btnvolver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vv.jButton1) {
            String clave = " Select id_propietarios from propietarios ";
            PreparedStatement ps;
            ResultSet rs;

            try {
                ps = con.conexion().prepareStatement(clave);
                rs = ps.executeQuery();
                while (rs.next()) {
                    propietarios.add(rs.getString("id_propietarios"));
                    cont++;
                }

                String fecha_exp = "";
                String fecha_lim = "";

                if ("Enero".equals(vv.jComboBox1.getSelectedItem().toString())) {
                    mes = "01/01";
                    mes2 = "31/01";
                } else if ("Febrero".equals(vv.jComboBox1.getSelectedItem().toString())) {
                    mes = "01/02";
                    mes2 = "31/02";
                } else if ("Marzo".equals(vv.jComboBox1.getSelectedItem().toString())) {
                    mes = "01/03";
                    mes2 = "31/03";
                } else if ("Abril".equals(vv.jComboBox1.getSelectedItem().toString())) {
                    mes = "01/04";
                    mes2 = "31/04";
                } else if ("Mayo".equals(vv.jComboBox1.getSelectedItem().toString())) {
                    mes = "01/05";
                    mes2 = "31/05";
                } else if ("Junio".equals(vv.jComboBox1.getSelectedItem().toString())) {
                    mes = "01/06";
                    mes2 = "31/06";
                } else if ("Julio".equals(vv.jComboBox1.getSelectedItem().toString())) {
                    mes = "01/07";
                    mes2 = "31/07";
                } else if ("Agosto".equals(vv.jComboBox1.getSelectedItem().toString())) {
                    mes = "01/08";
                    mes2 = "31/08";
                } else if ("Septiembre".equals(vv.jComboBox1.getSelectedItem().toString())) {
                    mes = "01/09";
                    mes2 = "31/09";
                } else if ("Octubre".equals(vv.jComboBox1.getSelectedItem().toString())) {
                    mes = "01/10";
                    mes2 = "31/10";
                } else if ("Noviembre".equals(vv.jComboBox1.getSelectedItem().toString())) {
                    mes = "01/11";
                    mes2 = "31/11";
                } else if ("Diciembre".equals(vv.jComboBox1.getSelectedItem().toString())) {
                    mes = "01/12";
                    mes2 = "31/12";
                }

                if ("2020".equals(vv.jComboBox2.getSelectedItem().toString())) {
                    año = 2020;
                    fecha_exp = mes + "/" + año;
                    fecha_lim = mes2 + "/" + año;
                    valor = 120000;
                } else if ("2021".equals(vv.jComboBox2.getSelectedItem().toString())) {
                    año = 2021;
                    fecha_exp = mes + "/" + año;
                    fecha_lim = mes2 + "/" + año;
                    valor = 135000;
                } else if ("2022".equals(vv.jComboBox2.getSelectedItem().toString())) {
                    año = 2022;
                    fecha_exp = mes + "/" + año;
                    fecha_lim = mes2 + "/" + año;
                    valor = 140000;
                } else if ("2023".equals(vv.jComboBox2.getSelectedItem().toString())) {
                    año = 2023;
                    fecha_exp = mes + "/" + año;
                    fecha_lim = mes2 + "/" + año;
                    valor = 160000;
                } else if ("2024".equals(vv.jComboBox2.getSelectedItem().toString())) {
                    año = 2024;
                    fecha_exp = mes + "/" + año;
                    fecha_lim = mes2 + "/" + año;
                    valor = 210000;
                } else if ("2025".equals(vv.jComboBox2.getSelectedItem().toString())) {
                    año = 2025;
                    fecha_exp = mes + "/" + año;
                    fecha_lim = mes2 + "/" + año;
                    valor = 260000;
                }
                for (int i = 0; i < cont; i++) {

                    ps = con.conexion().prepareStatement("insert into recibo(fecha_exp,fecha_lim,valor,id_propietarios)values('" + fecha_exp + "','" + fecha_lim + "','" + Integer.toString(valor) + "','"
                            + propietarios.get(i) + "')");
                    ps.executeUpdate();

                }
                JOptionPane.showMessageDialog(null, "Recibos generados correctamente");

            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, "Registro no Almacenado " + x.getMessage());
                System.out.println("" + x);
            }

        }
        if (e.getSource() == vp.btnaceptar) {
            if (vp.txtCedula.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, " Complete los campos ");
            } else {
                try {
                    int id = Integer.parseInt(vp.txtCedula.getText());
                    PreparedStatement ps;
                    ResultSet rs;
                    try {

                        ps = con.conexion().prepareStatement("select id_recibo,fecha_exp,fecha_lim,valor,propietarios.nombres,propietarios.id_propietarios from recibo inner join propietarios where propietarios.id_propietarios = " + Integer.toString(id) + "");
                        rs = ps.executeQuery();
                        JOptionPane.showMessageDialog(null, "Factura generada Correctamente");
                        vp.txtCedula.setText(null);
                        while (rs.next()) {
                            vp.jLabel8.setText(rs.getString("id_recibo"));
                            vp.jLabel10.setText(rs.getString("id_propietarios"));
                            vp.jLabel11.setText(rs.getString("valor"));
                            vp.jLabel12.setText(rs.getString("fecha_exp"));
                            vp.jLabel14.setText(rs.getString("fecha_lim"));
                        }
                    } catch (Exception x) {
                        JOptionPane.showMessageDialog(null, "Factura no generada " + x.getMessage());
                        System.out.println("" + x);
                    }
                } catch (NumberFormatException a) {
                    JOptionPane.showMessageDialog(null, " El ID debe ser un numero ");
                }

            }

        }

        if (e.getSource()
                == vv.jButton2) {
            vv.setVisible(false);
            vv.dispose();
            vb.setVisible(true);
            vp.txtCedula.setText("");
        }

        if (e.getSource() == vp.btnvolver) {
            vp.setVisible(false);
            vp.dispose();
            vb.setVisible(true);
            vp.txtCedula.setText("");
        }
    }
}
