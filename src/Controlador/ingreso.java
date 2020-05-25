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

/**
 *
 * @author Jairo
 */
public class ingreso  implements ActionListener {
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
    
    public ingreso(vistaingreso Vingre,VistaBase VistaBase,conexion con,VistaBase vistabase,VistaPropietarios vistapro,VistaRegistroP vistarp, VistaResS vistars,VistaRegistroResid vistarr,VistaTrab vistatrab,VistaRegistoTrab vistart,VistaZonas vistazona,VistaTraRes vistatr){
    this.Vingre=Vingre;
    this.VistaBase=VistaBase;
     this.vistapro=vistapro;
    this.vistarp=vistarp;
    this.vistars=vistars;
    this.vistarr=vistarr;
    this.vistatrab=vistatrab;
    this.vistart=vistart;
    this.vistazona=vistazona;
    this.vistatr=vistatr;
    this.con=con;
    this.Vingre.jButton1.addActionListener(this);
    
    }

    @Override
    public void actionPerformed(ActionEvent x) {
        
        if(x.getSource() == Vingre.jButton1){
            try {
            String clave="Select clave,tipo  from usuario where usuario.usuario ='"+Vingre.jTextField1.getText()+"'";
            PreparedStatement ps;
            ResultSet rs;
            ps=con.conexion().prepareStatement(clave);
                rs=ps.executeQuery();
                while(rs.next()){
            if(rs.getString("tipo").equals("admin")){   
            if(rs.getString("clave").equals(Vingre.jPasswordField1.getText())){
                Base bd=new Base(VistaBase,vistapro, vistarp, vistars, vistarr,vistatrab, vistart, vistazona, vistatr,con);
                Vingre.setVisible(false);
                VistaBase.setVisible(true);
            } 
            else if(!rs.getString("clave").equals(Vingre.jPasswordField1.getText())){
            JOptionPane.showMessageDialog(null, "Usuario o clave incorrectas");
            }
                }else if(rs.getString("tipo").equals("celador")){
                 JOptionPane.showMessageDialog(null, "celador");
                }
            
              }
            } catch (SQLException ex) {
                Logger.getLogger(ingreso.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
             
      
        
        }
        
        
     
    }
    
}
