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
import Vista.VistaVisitante;
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
import Vista.VistaRegistroUser;
import Vista.VistaRegistroCarro;
import Vista.VistaActApa;
import Vista.VistaActPar;
import Vista.VistaPagoRecibos;
import Vista.VistaRecibos;


/**
 *
 * @author Jairo
 */
public class Base implements ActionListener {

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
    private VistaRegistroUser vistaregiu;
    private VistaRegistroCarro vistarcarro;
    private VistaVisitante vistavisi;
    private VistaActApa va;
    private VistaActPar vap;
        private VistaRecibos vistareci;
    private VistaPagoRecibos vistapreci;
    private int conta, conta1, conta2, conta3, conta4, conta5, conta6, conta7, conta8, conta9, conta10, conta11, conta12, conta13,conta14,conta15,conta16;

    public Base(VistaBase vistabase, VistaPropietarios vistapro, VistaRegistroP vistarp, VistaResS vistars, VistaRegistroResid vistarr,
            VistaTrab vistatrab, VistaRegistoTrab vistart, VistaZonas vistazona,
            VistaTraRes vistatr, conexion con, VistaActPro vistaactpro, VistaActRes vistaactres, VistaTipoem vitaem,
            VistaRegistroturno vistare, VistaActTrab vistaacttrab, VistaRegistroUser vistaregiu,
            VistaRegistroCarro vistarcarro, VistaVisitante vistavisi,VistaActApa va,VistaActPar vap,VistaPagoRecibos vistapreci,VistaRecibos vistareci) {
        this.vistabase = vistabase;
        this.vistapro = vistapro;
        this.vistarp = vistarp;
        this.vistars = vistars;
        this.vistarr = vistarr;
        this.vistatrab = vistatrab;
        this.vistart = vistart;
        this.vistazona = vistazona;
        this.vistatr = vistatr;
        this.vitaem = vitaem;
        this.vistare = vistare;
        this.va=va;
        this.vap=vap;
        this.vistarcarro = vistarcarro;
        this.vistaregiu = vistaregiu;
        this.vistaacttrab = vistaacttrab;
        this.vistavisi = vistavisi;
        this.con = con;
         this.vistareci = vistareci;
        this.vistapreci = vistapreci;
        this.conta = 1;
        this.conta1 = 1;
        this.conta2 = 1;
        this.conta3 = 1;
        this.conta4 = 1;
        this.conta5 = 1;
        this.conta6 = 1;
        this.conta7 = 1;
        this.conta8 = 1;
        this.conta9 = 1;
        this.conta10 = 1;
        this.conta11 = 1;
        this.conta12 = 1;
        this.conta13 = 1;
        this.conta16=1;
        this.conta14=1;
        this.conta15=1;
        this.vistaactpro = vistaactpro;
        this.vistaactres = vistaactres;
        this.vistabase.regisuser.addActionListener(this);
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
        this.vistabase.trabajadores.addActionListener(this);
        this.vistabase.jMenuItem3.addActionListener(this);
        this.vistabase.visitante.addActionListener(this);
        this.vistabase.actapa.addActionListener(this);
        this.vistabase.actpar.addActionListener(this);
        this.vistabase.jMenuItem2.addActionListener(this);
        this.vistabase.jMenuItem4.addActionListener(this);
    }

    

    @Override
    public void actionPerformed(ActionEvent x) {
        if (x.getSource() == vistabase.jMenuItem2 || x.getSource() == vistabase.jMenuItem4) {
            System.out.println("hola");
            vistabase.setVisible(false);
            if (x.getSource() == vistabase.jMenuItem2) {
                vistareci.setVisible(true);
            } else {
                vistapreci.setVisible(true);
            }
            if (conta16 == 1) {
                GenerarRecibo vrec = new GenerarRecibo(vistabase, vistareci, con, vistapreci);
                conta16++;
            }
        }
        
        
        
        if(x.getSource() == vistabase.actpar){
        vistabase.setVisible(false);
        vap.setVisible(true);
        if(conta15==1){
            actpar ac=new actpar(vistabase,vap,con);
        conta15++;
        }
        }
        
        
        if(x.getSource()== vistabase.actapa){
            vistabase.setVisible(false);
            va.setVisible(true);
            if(conta14==1){
                actapa ac=new actapa(va,vistabase,con);
                conta14++;
        }
        
        }
        
        if (x.getSource() == vistabase.visitante) {
            vistabase.setVisible(false);
            vistavisi.setVisible(true);
            if (conta13 == 1) {
                VVisitante vs = new VVisitante(vistabase, vistavisi, con);
                conta13++;
            }
        }

        if (x.getSource() == vistabase.jMenuItem3) {
            vistabase.setVisible(false);
            vistarcarro.setVisible(true);
            if (conta10 == 1) {
                RegistroCarro regisca = new RegistroCarro(vistabase, vistarcarro, con);
                conta10++;
            }
        }

        if (x.getSource() == vistabase.regisuser) {
            vistabase.setVisible(false);
            vistaregiu.setVisible(true);
            if (conta9 == 1) {
                RegistroUser regis = new RegistroUser(vistabase, vistaregiu, con);
                conta9++;
            }
        }

        if (x.getSource() == vistabase.acttrab) {
            vistabase.setVisible(false);
            vistaacttrab.setVisible(true);
            if (conta8 == 1) {
                acttrab act = new acttrab(vistabase, vistaacttrab, con);
                conta8++;
            }
        }

        if (x.getSource() == vistabase.tipoturn) {
            vistabase.setVisible(false);
            vistare.setVisible(true);
            if (conta7 == 1) {
                RegistroTurno vy = new RegistroTurno(vistabase, vistare, con);
                conta7++;
            }

        }
        if (x.getSource() == vistabase.propietarios) {
            vistabase.setVisible(false);
            vistapro.setVisible(true);
            if (conta5 == 1) {
                VPropietarios vp = new VPropietarios(vistapro, vistabase, con);
                conta5++;
            }
        }
        if (x.getSource() == vistabase.tipoem) {
            vistabase.setVisible(false);
            vitaem.setVisible(true);
            if (conta6 == 1) {
                RegistroTipotra ve = new RegistroTipotra(vistabase, vitaem, con);
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
        if (x.getSource() == vistabase.residentes) {
            vistabase.setVisible(false);
            vistars.setVisible(true);
            if (conta12 == 1) {
                VResidentes vr = new VResidentes(vistars, vistabase, con);
                conta12++;
            }
        }
        if (x.getSource() == vistabase.registroresi) {
            vistabase.setVisible(false);
            vistarr.setVisible(true);
            if (conta1 == 1) {
                RegistoResidente rg = new RegistoResidente(vistabase, con,vistarr);
                this.conta1++;
            }
        }
        if (x.getSource() == vistabase.actpro) {

            vistabase.setVisible(false);
            vistaactpro.setVisible(true);
            if (conta2 == 1) {
                actupro act = new actupro(vistabase, vistaactpro, con);
                this.conta2++;
            }
        }
        if (x.getSource() == vistabase.actures) {
            vistabase.setVisible(false);
            vistaactres.setVisible(true);
            if (conta3 == 1) {
                actures act = new actures(vistaactres, vistabase, con);
                this.conta3++;
            }
        }

        if (x.getSource() == vistabase.trabajadores) {
            vistabase.setVisible(false);
            vistatrab.setVisible(true);
            if (conta11 == 1) {
                VTrabajadores vt = new VTrabajadores(vistabase, vistatrab, con);
                conta11++;
            }

        }
        if (x.getSource() == vistabase.registrotrab) {
            vistabase.setVisible(false);
            vistart.setVisible(true);
            if (conta4 == 1) {
                RegistroTrabajador res = new RegistroTrabajador(vistabase, vistart, con);
                this.conta4++;
            }
        }

    }

}
