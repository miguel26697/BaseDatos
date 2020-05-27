/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.VistaApar;
import Vista.VistaRegistroZona;
import Vista.VistaRegistroUsozo;
import Vista.VistaZonas;
import conjunto.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Jairo
 */
public class vistaapr implements ActionListener{
    private VistaApar vistaapr;
    private VistaRegistroZona vistarz;
    private VistaZonas vistazona;
    private VistaRegistroUsozo vistaz;
    private conexion con;
    private int conta,conat1;
    public vistaapr(VistaApar vistaapr,VistaRegistroZona vistarz,conexion con,VistaRegistroUsozo vistaz,VistaZonas vistazona){
    this.vistaapr=vistaapr;
    this.vistarz=vistarz;
    this.vistaz=vistaz;
    this.vistazona=vistazona;
    this.con=con;
    this.conta=1;
    this.conat1=1;
    this.vistaapr.jMenuItem1.addActionListener(this);
    this.vistaapr.jMenuItem2.addActionListener(this);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == vistaapr.jMenuItem1){
       vistaapr.setVisible(false);
       vistaz.setVisible(true);
       if(conta==1){
           RegistroUsozo rgz =new  RegistroUsozo(vistaapr,vistaz,con);
           
       conta++;
       }
       }
       if(e.getSource()== vistaapr.jMenuItem2){
       vistaapr.setVisible(false);
       vistazona.setVisible(true);
       if(conat1==1){
           VZonas vzona =new VZonas(vistaapr,vistazona,con);
           conat1++;
       }
       }
        
    }
}
