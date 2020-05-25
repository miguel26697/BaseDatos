/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.VistaBase;
import Vista.VistaRegistroResid;
import conjunto.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Vista.VistaPropietarios;
import Vista.VistaRegistoTrab;
import Vista.VistaRegistroP;
import Vista.VistaRegistroResid;
import Vista.VistaResS;
import Vista.VistaTraRes;
import Vista.VistaTrab;
import Vista.VistaZonas;
import Vista.vistaingreso;
/**
 *
 * @author Jairo
 */
public class RegistoResidente implements ActionListener{
    private vistaingreso Vingre;
    private conexion con;
     private VistaBase VistaBase;
     private VistaPropietarios vistapro;
    private VistaRegistroP vistarp;
    private VistaResS vistars;
    private VistaRegistroResid vistarr;
    private VistaTrab vistatrab;
    private VistaRegistoTrab vistart;
    private VistaZonas vistazona;
    private VistaTraRes vistatr;
    public RegistoResidente(VistaBase VistaBase,conexion con,VistaBase vistabase,VistaPropietarios vistapro,VistaRegistroP vistarp, VistaResS vistars,VistaRegistroResid vistarr,VistaTrab vistatrab,VistaRegistoTrab vistart,VistaZonas vistazona,VistaTraRes vistatr){
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
    this.vistarr.jButton1.addActionListener(this);
    this.vistarr.jButton2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()== vistarr.jButton2){
      String id= vistarr.jTextField1.getText();
      String nombre=vistarr.jTextField2.getText();
      String apellidos=vistarr.jTextField3.getText();
      String telefono =vistarr.jTextField4.getText();
      String id_apto=vistarr.jTextField6.getText();
      PreparedStatement ps;
      try{
      
      if(!id.equals(null) && !nombre.equals(null) && !apellidos.equals(null) && !telefono.equals(null) && !id_apto.equals(null)){
      ps=con.conexion().prepareStatement("insert into residentes(id_residente,nombre,apellidos,telefono,id_apto)values('"+id+"','"+nombre+"','"+apellidos+"','"+telefono+"','"+id_apto+"')");
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Dato Registrado Correctamente");
       vistarr.jTextField1.setText("");
                vistarr.jTextField2.setText("");
                vistarr.jTextField3.setText("");
                vistarr.jTextField4.setText("");
                vistarr.jTextField6.setText("");
      }else{
      JOptionPane.showMessageDialog(null, "Campos vacios");
      
      }
      }catch(Exception x){
            
     JOptionPane.showMessageDialog(null, "Datos erroneos Dato no registrado");
      }
     
      }
        if(e.getSource()== vistarr.jButton1){      

              
                vistarr.setVisible(false);
                VistaBase.setVisible(true);
      
      }
        
        
       
    }
    
    
}
