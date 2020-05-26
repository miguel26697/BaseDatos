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
import Vista.VistaRegistoTrab;
import Vista.VistaTipoem;
import conjunto.conexion;
import Vista.VistaRegistroturno;
import Vista.VistaActTrab;
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
    private VistaTipoem vitaem;
    private VistaRegistroturno vistare;
    private VistaActTrab vistaacttrab;
    private int conta,conta1,conta2,conta3,conta4,conta5,conta6,conta7,conta8;
    
    public Base(VistaBase vistabase,VistaPropietarios vistapro,VistaRegistroP vistarp, VistaResS vistars,VistaRegistroResid vistarr,VistaTrab vistatrab,VistaRegistoTrab vistart,VistaZonas vistazona,VistaTraRes vistatr,conexion con,VistaActPro vistaactpro,VistaActRes vistaactres,VistaTipoem vitaem,VistaRegistroturno vistare,VistaActTrab vistaacttrab){
    this.vistabase=vistabase;
    this.vistapro=vistapro;
    this.vistarp=vistarp;
    this.vistars=vistars;
    this.vistarr=vistarr;
    this.vistatrab=vistatrab;
    this.vistart=vistart;
    this.vistazona=vistazona;
    this.vistatr=vistatr;
    this.vitaem=vitaem;
    this.vistare=vistare;
    this.vistaacttrab=vistaacttrab;
    this.con=con;
    this.conta=1;
    this.conta1=1;
    this.conta2=1;
    this.conta3=1;
    this.conta4=1;
    this.conta5=1;
    this.conta6=1;
    this.conta7=1;
    this.conta8=1;
    this.vistaactpro=vistaactpro;
    this.vistaactres=vistaactres;
    this.vistabase.acttrab.addActionListener(this);
    this.vistabase.actpro.addActionListener(this);
    this.vistabase.tipoem.addActionListener(this);
    this.vistabase.tipoturn.addActionListener(this);
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
        if(x.getSource()== vistabase.acttrab){
        vistabase.setVisible(false);
        vistaacttrab.setVisible(true);
        if(conta8==1){
        acttrab act =new acttrab(vistabase,vistaacttrab,con);
            conta8++;
        }
        }
        
        if(x.getSource()== vistabase.tipoturn){
         vistabase.setVisible(false);
        vistare.setVisible(true);
        if(conta7==1){
        RegistroTurno vy =new RegistroTurno (vistabase,vistare,con);
        conta7++;
        }
        
        }
        if(x.getSource()== vistabase.propietarios){  
        vistabase.setVisible(false);
        vistapro.setVisible(true);
        if(conta5==1){
        VPropietarios vp =new VPropietarios(vistapro,vistabase,con);
        conta5++;
        }
        }
        if(x.getSource()== vistabase.tipoem){
        vistabase.setVisible(false);
        vitaem.setVisible(true);
        if(conta6==1){
        RegistroTipotra ve =new RegistroTipotra (vistabase,vitaem,con);
        conta6++;
        }
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
        if(conta4==1){
            RegistroTrabajador res=new RegistroTrabajador(vistabase,vistart,con);
            this.conta4++;
        }
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
