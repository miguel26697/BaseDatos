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
    conexion con =new conexion();
   
      vistaingreso Vingre =new vistaingreso();
      VistaBase VistaBase =new VistaBase();
      Vingre.setVisible(true);
      VistaBase vistabase = new VistaBase();
      VistaPropietarios vistapro= new VistaPropietarios();
      VistaRegistroP vistarp=new VistaRegistroP();
      VistaResS vistars=new VistaResS();
      VistaRegistroResid vistarr =new VistaRegistroResid();
      VistaTrab vistatrab = new VistaTrab();
      VistaRegistoTrab vistart =new VistaRegistoTrab();
      VistaZonas vistazona=new VistaZonas();
      VistaTraRes vistatr =new VistaTraRes();
      VistaActPro vistaactpro =new VistaActPro();
      VistaActRes vistaactres =new VistaActRes();
      ingreso conotra=new ingreso(Vingre,VistaBase,con,vistabase,vistapro, vistarp, vistars, vistarr,vistatrab, vistart, vistazona, vistatr,vistaactpro, vistaactres);
     
        
    }
    
}
