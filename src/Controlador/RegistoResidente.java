/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.VistaRegistroResid;
import conjunto.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Jairo
 */
public class RegistoResidente implements ActionListener{
    private VistaRegistroResid vistare;
    private conexion con;
    
    public RegistoResidente(VistaRegistroResid vistare,conexion con){
    this.vistare=vistare;
     this.con=con;
    this.vistare.jButton1.addActionListener(this);
    this.vistare.jButton2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()== vistare.jButton2){
      try{
      String id= vistare.jTextField1.getText();
      String nombre=vistare.jTextField2.getText();
      String apellidos=vistare.jTextField3.getText();
      String telefono =vistare.jTextField4.getText();
      String id_apto=vistare.jTextField6.getText();
      PreparedStatement ps;
      if(!id.equals(null) && !nombre.equals(null) && !apellidos.equals(null) && !telefono.equals(null) && !id_apto.equals(null)){
      ps=con.conexion().prepareStatement("insert into residentes(id_residente,nombre,apellidos,telefono,id_apto)values('"+id+"','"+nombre+"','"+apellidos+"','"+telefono+"','"+id_apto+"')");
      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Dato Registrado Correctamente");
      }else{
      JOptionPane.showMessageDialog(null, "Ca,pos vacios");
      
      }
      }catch(Exception x){
     
      }
      
      }
        
        
        
       
    }
    
    
}
