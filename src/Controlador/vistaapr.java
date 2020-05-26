/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.VistaApar;
import Vista.VistaRegistroZona;
import Vista.VistaRegistroUsozo;
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
    private VistaRegistroUsozo vistaz;
    private conexion con;
    private int conta;
    public vistaapr(VistaApar vistaapr,VistaRegistroZona vistarz,conexion con,VistaRegistroUsozo vistaz){
    this.vistaapr=vistaapr;
    this.vistarz=vistarz;
    this.vistaz=vistaz;
    this.con=con;
    this.conta=1;
    this.vistaapr.jMenuItem1.addActionListener((ActionListener) this);
    
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
        
    }
}
