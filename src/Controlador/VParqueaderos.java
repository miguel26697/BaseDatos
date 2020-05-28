/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Vistacel;
import Vista.VistaParqueadero;
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
public class VParqueaderos implements ActionListener {
    Vistacel vb = new Vistacel();
    VistaParqueadero vp = new VistaParqueadero();
    private conexion con; 

    public VParqueaderos(Vistacel vb, VistaParqueadero vp, conexion con) {
        this.vp=vp;
        this.vb=vb;
        this.con=con;
        this.vp.jButton1.addActionListener(this);
        this.vp.jButton2.addActionListener(this);
    }
    
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vp.jButton1){
            try {

                    DefaultTableModel modelo = new DefaultTableModel();
                    vp.jTable1.setModel(modelo);

                    PreparedStatement ps = null;
                    ResultSet rs = null;

                    String clave = "select id_parqueadero, bahia, pp from parqueadero where pp='no'; ";
                    

                    ps = con.conexion().prepareStatement(clave);
                    rs = ps.executeQuery();

                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();

                    modelo.addColumn("Id");
                    modelo.addColumn("Bahia");
                    modelo.addColumn("Ocupado");
                    

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
        }if(e.getSource() == vp.jButton2){
            vb.setVisible(true);
            vp.setVisible(false);
        }
    }
}
