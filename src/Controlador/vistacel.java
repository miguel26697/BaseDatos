/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.Vistacel;
import Vista.VistaRegistroVisi;
import Vista.VistaParqueadero;
import conjunto.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.VistaVisitante;

/**
 *
 * @author Jairo
 */
public class vistacel implements ActionListener {
    private Vistacel vistacel;
    private VistaRegistroVisi vistaregis;
    private VistaVisitante vistavi;
    private conexion con;
    private VistaParqueadero vp;
    private int conta,conta1,conta2;
    public vistacel(Vistacel vistacel,VistaRegistroVisi vistaregis,conexion con,VistaVisitante vistavi,VistaParqueadero vp){
    this.vistacel=vistacel;
    this.vistaregis=vistaregis;
    this.vp=vp;
    this.vistavi=vistavi;
    this.con=con;
    this.conta=1;
    this.conta1=1;
    this.conta2=1;
    this.vistacel.jMenuItem2.addActionListener(this);
    this.vistacel.jMenuItem1.addActionListener(this);
    this.vistacel.jMenuItem3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistacel.jMenuItem2){
            vistacel.setVisible(false);
            vistaregis.setVisible(true);
            if(conta==1){
            RegistroVisitante regisvi =new RegistroVisitante(vistacel,vistaregis,con);
      
            this.conta++;
            }}
        
        if(e.getSource()== vistacel.jMenuItem1){
            vistacel.setVisible(false);
            vistavi.setVisible(true);
            if(conta1==1){
              VVisitante1 vs=new VVisitante1(vistacel, vistavi,con);
            conta1++;
            }
        }
        if(e.getSource() == vistacel.jMenuItem3){
         vistacel.setVisible(false);
         vp.setVisible(true);
        if(conta2 == 1){
        VParqueaderos vap=new VParqueaderos (vistacel,vp,con);
        conta2++;
        }
        }
    }
}
