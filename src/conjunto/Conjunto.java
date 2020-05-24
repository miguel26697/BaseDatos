/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjunto;
import Controlador.ingreso;
import Modelo.Modelo;
import Vista.Vistaconexion;
import Vista.vistaingreso;
import Vista.VistaBase;
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
      ingreso conotra=new ingreso(Vingre,VistaBase,con);
      Vingre.setVisible(true);
      
    
    
        
    }
    
}
