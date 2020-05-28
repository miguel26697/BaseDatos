/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.VistaBase;
import Vista.VistaActApa;
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
public class actapa implements ActionListener{
    private conexion con;
    private VistaBase vistabase;
    private VistaActApa va;
    private String id;
    
    public actapa(VistaActApa va,VistaBase vistabase,conexion con){
    this.con=con;
    this.vistabase=vistabase;
    this.va=va;
    this.va.jButton1.addActionListener(this);
    this.va.jButton2.addActionListener(this);
    this.va.jButton3.addActionListener(this);
    this.va.jButton2.setEnabled(false);
    this.va.jTextField1.setEditable(false);
    
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          if(e.getSource() == va.jButton1){
             
            for (int i = 1; i < 6; i++) {
                for (int j = 1; j < 6; j++) {
                    for (int k = 0; k < 6; k++) {
                        if (("" + i + "").equals(va.jComboBox1.getSelectedItem().toString()) && ("" + j + "0" + k + "").equals(va.jComboBox2.getSelectedItem().toString())) {
                            this.id= "T" + i + "A" + j + "0" + k;
                        }
                    }
                }
            }
         try{
          
            String clave="Select id_apto ,tipo ,id_propietario from apto where id_apto ='"+id+"'";
            PreparedStatement ps;
            ResultSet rs;
            ps=con.conexion().prepareStatement(clave);
            rs=ps.executeQuery();
            if(rs.next()){
                va.jLabel5.setText(rs.getString("tipo"));
                va.jTextField1.setText(rs.getNString("id_propietario"));
                va.jButton2.setEnabled(true);
                va.jTextField1.setEditable(true);
            }else{

            JOptionPane.showMessageDialog(null, "id no encontrado");
            }
        }catch(Exception x){
         JOptionPane.showMessageDialog(null, "Datos incorrectos"+x.getMessage());
        
        }
        
        
        }
          if(e.getSource() == va.jButton2){
     
          try{
            String id_propietarios=va.jTextField1.getText();
            String id_atpo=this.id;
            PreparedStatement ps;
            ResultSet rs;
            if(id_propietarios.length() !=0){
            ps=con.conexion().prepareStatement("update apto set id_propietario='"+id_propietarios+"' where id_apto = \'"+id+"'");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            va.jButton2.setEnabled(false);
            va.jTextField1.setEditable(false);
            va.jTextField1.setText(null);
            va.jLabel5.setText(null);
  
        }else{
            JOptionPane.showMessageDialog(null, "Complete los datos");
            }
        }catch(Exception x){
        JOptionPane.showMessageDialog(null, "Datos incorrectos");
        
        }
          
          
          }
     if(e.getSource() == va.jButton3){
         va.jButton2.setEnabled(false);
            va.jTextField1.setEditable(false);
            va.jTextField1.setText(null);
            va.jLabel5.setText(null);
       va.dispose();
       vistabase.setVisible(true);
     
     
     }     
        
       
    }
    
}
