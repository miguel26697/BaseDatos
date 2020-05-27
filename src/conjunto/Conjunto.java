/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjunto;

import Controlador.ingreso;
import Controlador.Base;
import Modelo.Modelo;
import Vista.Vistaconexion;
import Vista.vistaingreso;
import Vista.VistaBase;
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
import javax.swing.JOptionPane;
import Vista.VistaTipoem;
import Vista.VistaRegistroturno;
import Vista.VistaApar;
import Vista.VistaRegistroZona;
import Vista.VistaRegistroUsozo;
import Vista.VistaActTrab;
import Vista.Vistacel;
import Vista.VistaRegistroVisi;
import Vista.VistaRegistroUser;
import Vista.VistaRegistroCarro;
import Vista.VistaVisitante;

/**
 *
 * @author david
 */
public class Conjunto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        conexion con = new conexion();
        VistaApar vistaapr = new VistaApar();
        VistaRegistroUsozo vistaz = new VistaRegistroUsozo();
        VistaRegistroZona vistarz = new VistaRegistroZona();
        vistaingreso Vingre = new vistaingreso();
        VistaBase VistaBase = new VistaBase();
        Vingre.setVisible(true);
        Vingre.setLocationRelativeTo(null);
        VistaBase vistabase = new VistaBase();
        VistaPropietarios vistapro = new VistaPropietarios();
        VistaRegistroP vistarp = new VistaRegistroP();
        VistaResS vistars = new VistaResS();
        VistaRegistroResid vistarr = new VistaRegistroResid();
        VistaTrab vistatrab = new VistaTrab();
        VistaRegistoTrab vistart = new VistaRegistoTrab();
        VistaZonas vistazona = new VistaZonas();
        VistaTraRes vistatr = new VistaTraRes();
        VistaActPro vistaactpro = new VistaActPro();
        VistaActRes vistaactres = new VistaActRes();
        VistaTipoem vistaem = new VistaTipoem();
        VistaRegistroturno vistare = new VistaRegistroturno();
        VistaActTrab vistaacttrab = new VistaActTrab();
        Vistacel vistacel = new Vistacel();
        VistaRegistroUser vistareu = new VistaRegistroUser();
        VistaRegistroVisi vistarevi = new VistaRegistroVisi();
        VistaRegistroCarro vistarcarro = new VistaRegistroCarro();
        VistaVisitante vistavisi = new VistaVisitante();
        ingreso conotra = new ingreso(Vingre, VistaBase, con, vistabase, vistapro, vistarp, vistars, vistarr, vistatrab, vistart, vistazona,
        vistatr, vistaactpro, vistaactres, vistaem, vistare, vistaapr, vistarz, vistaz, vistaacttrab, vistacel, vistarevi, vistareu, vistarcarro, vistavisi);
        conotra.iniciar();

    }

}
