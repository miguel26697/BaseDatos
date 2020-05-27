/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.vistaingreso;
import Vista.VistaBase;
import conjunto.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import conjunto.Conjunto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Vista.VistaPropietarios;
import Vista.VistaRegistoTrab;
import Vista.VistaRegistroP;
import Vista.VistaRegistroResid;
import Vista.VistaResS;
import Vista.VistaTraRes;
import Vista.VistaTrab;
import Vista.VistaZonas;
import Vista.VistaActPro;
import Vista.VistaActRes;
import Vista.VistaTipoem;
import Vista.VistaRegistroturno;
import Vista.VistaApar;
import Vista.VistaRegistroUsozo;
import Vista.VistaRegistroZona;
import Vista.VistaActTrab;
import Vista.VistaRegistroVisi;
import Vista.Vistacel;
import Vista.VistaRegistroUser;
import Vista.VistaRegistroCarro;
import Vista.VistaVisitante;


/**
 *
 * @author Jairo
 */
public class ingreso implements ActionListener {

    private VistaApar vistaapr;
    private VistaRegistroZona vistarz;
    private vistaingreso Vingre;
    private VistaBase VistaBase;
    private conexion con;
    private VistaPropietarios vistapro;
    private VistaRegistroP vistarp;
    private VistaResS vistars;
    private VistaRegistroResid vistarr;
    private VistaTrab vistatrab;
    private VistaRegistoTrab vistart;
    private VistaZonas vistazona;
    private VistaTraRes vistatr;
    private VistaActPro vistaactpro;
    private VistaActRes vistaactres;
    private VistaTipoem vistaem;
    private VistaRegistroturno vistare;
    private VistaRegistroUsozo vistaz;
    private VistaActTrab vistaacttrab;
    private Vistacel vistacel;
    private VistaVisitante vistavisi;
    private VistaRegistroCarro vistarcarro;
    private VistaRegistroUser vistaregiu;
    private VistaRegistroVisi vistaresi;

    public ingreso(vistaingreso Vingre, VistaBase VistaBase, conexion con, VistaBase vistabase, VistaPropietarios vistapro, VistaRegistroP vistarp,
            VistaResS vistars, VistaRegistroResid vistarr, VistaTrab vistatrab, VistaRegistoTrab vistart, VistaZonas vistazona, VistaTraRes vistatr,
            VistaActPro vistaactpro, VistaActRes vistaactres, VistaTipoem vistaem, VistaRegistroturno vistare, VistaApar vistaapr, VistaRegistroZona vistarz,
            VistaRegistroUsozo vistaz, VistaActTrab vistaacttrab, Vistacel vistacel, VistaRegistroVisi vistaresi, VistaRegistroUser vistaregiu, VistaRegistroCarro vistarcarro, VistaVisitante vistavisi) {
        this.vistavisi = vistavisi;
        this.vistaz = vistaz;
        this.vistaapr = vistaapr;
        this.vistarz = vistarz;
        this.vistaacttrab = vistaacttrab;
        this.Vingre = Vingre;
        this.VistaBase = VistaBase;
        this.vistapro = vistapro;
        this.vistarp = vistarp;
        this.vistars = vistars;
        this.vistarr = vistarr;
        this.vistatrab = vistatrab;
        this.vistart = vistart;
        this.vistazona = vistazona;
        this.vistatr = vistatr;
        this.con = con;
        this.vistarcarro = vistarcarro;
        this.vistare = vistare;
        this.vistaem = vistaem;
        this.vistaregiu = vistaregiu;
        this.vistaactres = vistaactres;
        this.vistaactpro = vistaactpro;
        this.vistacel = vistacel;
        this.vistaresi = vistaresi;
        this.Vingre.jButton1.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent x) {

        if (x.getSource() == Vingre.jButton1) {
            try {
                String clave = "Select clave,tipo  from usuario where usuario.usuario ='" + Vingre.jTextField1.getText() + "'";
                PreparedStatement ps;
                ResultSet rs;
                ps = con.conexion().prepareStatement(clave);
                rs = ps.executeQuery();
                while (rs.next()) {
                    if (rs.getString("tipo").equals("admin")) {
                        if (rs.getString("clave").equals(Vingre.jPasswordField1.getText())) {
                            Base bd = new Base(VistaBase, vistapro, vistarp, vistars, vistarr, vistatrab, vistart, vistazona,
                                    vistatr, con, vistaactpro, vistaactres, vistaem, vistare, vistaacttrab, vistaregiu, vistarcarro, vistavisi);
                            Vingre.setVisible(false);
                            VistaBase.setVisible(true);
                        } else if (!rs.getString("clave").equals(Vingre.jPasswordField1.getText())) {
                            JOptionPane.showMessageDialog(null, "Usuario o clave incorrectas");
                        }
                    } else if (rs.getString("tipo").equals("Contra")) {
                        if (rs.getString("clave").equals(Vingre.jPasswordField1.getText())) {
                            vistaapr apr = new vistaapr(vistaapr, vistarz, con, vistaz,vistazona);
                            Vingre.setVisible(false);
                            vistaapr.setVisible(true);
                        } else if (!rs.getString("clave").equals(Vingre.jPasswordField1.getText())) {
                            JOptionPane.showMessageDialog(null, "Usuario o clave incorrectas");
                        }
                    } else if (rs.getString("tipo").equals("celador")) {
                        if (rs.getString("clave").equals(Vingre.jPasswordField1.getText())) {
                            vistacel vistace = new vistacel(vistacel, vistaresi, con,vistavisi);
                            Vingre.setVisible(false);
                            vistacel.setVisible(true);
                        } else if (!rs.getString("clave").equals(Vingre.jPasswordField1.getText())) {
                            JOptionPane.showMessageDialog(null, "Usuario o clave incorrectas");
                        }

                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(ingreso.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
