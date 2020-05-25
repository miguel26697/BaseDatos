/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.VistaBase;
import Vista.VistaPropietarios;
import Vista.VistaRegistroP;
import Vista.VistaResS;
import Vista.VistaRegistroResid;
import Vista.VistaTrab;
import Vista.VistaRegistoTrab;
import Vista.VistaZonas;
import Vista.VistaTraRes;
import Vista.VistaActRes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.VistaActPro;
import conjunto.conexion;
/**
 *
 * @author Jairo
 */
public class Base  implements ActionListener {
    private VistaBase vistabase;
    private VistaPropietarios vistapro;
    private VistaRegistroP vistarp;
    private VistaResS vistars;
    private VistaRegistroResid vistarr;
    private VistaTrab vistatrab;
    private VistaRegistoTrab vistart;
    private VistaZonas vistazona;
    private VistaTraRes vistatr;
    private conexion con;
    private VistaActPro vistaactpro;
    private VistaActRes vistaactres;
    private int conta,conta1,conta2,conta3;
    
    public Base(VistaBase vistabase,VistaPropietarios vistapro,VistaRegistroP vistarp, VistaResS vistars,VistaRegistroResid vistarr,VistaTrab vistatrab,VistaRegistoTrab vistart,VistaZonas vistazona,VistaTraRes vistatr,conexion con,VistaActPro vistaactpro,VistaActRes vistaactres){
    this.vistabase=vistabase;
    this.vistapro=vistapro;
    this.vistarp=vistarp;
    this.vistars=vistars;
    this.vistarr=vistarr;
    this.vistatrab=vistatrab;
    this.vistart=vistart;
    this.vistazona=vistazona;
    this.vistatr=vistatr;
    this.con=con;
    this.conta=1;
    this.conta1=1;
    this.conta2=1;
    this.conta3=1;
    this.vistaactpro=vistaactpro;
    this.vistaactres=vistaactres;
    this.vistabase.actpro.addActionListener(this);
    this.vistabase.actures.addActionListener(this);
    this.vistabase.propietarios.addActionListener(this);
    this.vistabase.registropro.addActionListener(this);
    this.vistabase.registroresi.addActionListener(this);
    this.vistabase.registrotrab.addActionListener(this);
    this.vistabase.residentes.addActionListener(this);
    this.vistabase.resitrab.addActionListener(this);
    this.vistabase.trabajadores.addActionListener(this);
    this.vistabase.zonas.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent x) {
        
        if(x.getSource()== vistabase.propietarios){
          
         vistabase.setVisible(false);
        vistapro.setVisible(true);
        }
        if (x.getSource() == vistabase.registropro) {
            vistabase.setVisible(false);
            vistarp.setVisible(true);
            if (conta == 1) {
                RegistroProp rp = new RegistroProp(vistabase, vistarp, con);
                conta++;
            }
        }
        if(x.getSource()==vistabase.residentes){
        vistabase.setVisible(false);
        vistars.setVisible(true);
        }
        if(x.getSource()==vistabase.registroresi){
            vistabase.setVisible(false);
        vistarr.setVisible(true);
       if(conta1==1){
         RegistoResidente rg=new RegistoResidente(vistabase,con,vistabase,vistapro, vistarp,  vistars, vistarr,vistatrab,vistart,vistazona,vistatr);
         this.conta1++;
       }
        }
        if(x.getSource()==vistabase.actpro){
            
            vistabase.setVisible(false);
            vistaactpro.setVisible(true);
            if(conta2==1){
             actupro act=new actupro(vistabase,vistaactpro,con);
             this.conta2++;
       }
        }
        if(x.getSource() == vistabase.actures){
        vistabase.setVisible(false);
        vistaactres.setVisible(true);
         if(conta3==1){
             actures act=new actures(vistaactres,vistabase,con);
             this.conta3++;
       }
        }
        
        
        if(x.getSource()==vistabase.trabajadores){
        vistabase.setVisible(false);
        vistatrab.setVisible(true);
        }
        if(x.getSource()==vistabase.registrotrab){
        vistabase.setVisible(false);
        vistart.setVisible(true);
        }
        if(x.getSource()== vistabase.resitrab){
            vistabase.setVisible(false);
            vistatr.setVisible(true);
        }
         if(x.getSource()== vistabase.zonas){
            vistabase.setVisible(false);
            vistazona.setVisible(true);
        }
        
    }
    
}
