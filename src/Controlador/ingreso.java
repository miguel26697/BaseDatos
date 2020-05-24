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

/**
 *
 * @author Jairo
 */
public class ingreso  implements ActionListener {
    private vistaingreso Vingre;
    private VistaBase VistaBase;
    private conexion con;
    
    
    public ingreso(vistaingreso Vingre,VistaBase VistaBase,conexion con){
    this.Vingre=Vingre;
    this.VistaBase=VistaBase;
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
                Vingre.setVisible(false);
                VistaBase.setVisible(true);
            } 
            //swwwwwhkgjhf
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
