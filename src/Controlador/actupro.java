/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.VistaBase;
import Vista.VistaActPro;
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
public class actupro implements ActionListener {
    private VistaBase vistabase;
    private VistaActPro vistaactpro;
    private conexion con;
    
    public actupro(VistaBase vistabase,VistaActPro vistaactpro,conexion con){
    this.vistabase=vistabase;
    this.vistaactpro=vistaactpro;
    this.con=con;
    this.vistaactpro.jButton1.addActionListener(this);
    this.vistaactpro.jButton2.addActionListener(this);
    this.vistaactpro.jButton3.addActionListener(this);
    this.vistaactpro.jButton4.addActionListener(this);
    this.vistaactpro.jButton2.setEnabled(false);
    this.vistaactpro.jButton4.setEnabled(false);
    this.vistaactpro.jTextField2.setEnabled(false);
    this.vistaactpro.jTextField3.setEnabled(false);
    this.vistaactpro.jTextField4.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if(e.getSource()==vistaactpro.jButton1){
            
        try{
          
            String clave="Select id_propietarios ,nombres ,apellidos,telefono  from propietarios where id_propietarios ='"+vistaactpro.jTextField1.getText()+"'";
            PreparedStatement ps;
            ResultSet rs;
            ps=con.conexion().prepareStatement(clave);
            rs=ps.executeQuery();
            if(rs.next()){
            vistaactpro.jTextField2.setText(rs.getString("nombres"));
            vistaactpro.jTextField3.setText(rs.getString("apellidos"));
            vistaactpro.jTextField4.setText(rs.getString("telefono"));
            this.vistaactpro.jButton2.setEnabled(true);
            this.vistaactpro.jButton4.setEnabled(true);
            this.vistaactpro.jTextField2.setEnabled(true);
            this.vistaactpro.jTextField3.setEnabled(true);
            this.vistaactpro.jTextField4.setEnabled(true); 
                
            
            }else{
            vistaactpro.jTextField2.setText(null);
            vistaactpro.jTextField3.setText(null);
            vistaactpro.jTextField4.setText(null); 
            this.vistaactpro.jButton2.setEnabled(false);
            this.vistaactpro.jTextField2.setEnabled(false);
            this.vistaactpro.jTextField3.setEnabled(false);
            this.vistaactpro.jTextField4.setEnabled(false);  
            JOptionPane.showMessageDialog(null, "id no encontrado");
            }
        }catch(Exception x){
         JOptionPane.showMessageDialog(null, "Datos incorrectos");
        
        }
        
        }
        if(e.getSource()== vistaactpro.jButton2){
        try{
            String nom=vistaactpro.jTextField2.getText();
            String ape=vistaactpro.jTextField3.getText();
            String tel=vistaactpro.jTextField4.getText();
            PreparedStatement ps;
            ResultSet rs;
            
            if(vistaactpro.jTextField2.getText().length()!=0 && vistaactpro.jTextField3.getText().length()!=0  && vistaactpro.jTextField4.getText().length()!=0 ){
            ps=con.conexion().prepareStatement("update propietarios set id_propietarios='"+vistaactpro.jTextField1.getText()+"',nombres='"+nom+"',apellidos='"+ape+"',telefono='"+tel+"'where id_propietarios="+vistaactpro.jTextField1.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            vistaactpro.jTextField2.setText(null);
            vistaactpro.jTextField3.setText(null);
            vistaactpro.jTextField4.setText(null); 
            this.vistaactpro.jButton4.setEnabled(false);
            this.vistaactpro.jButton2.setEnabled(false);
            this.vistaactpro.jTextField2.setEnabled(false);
            this.vistaactpro.jTextField3.setEnabled(false);
            this.vistaactpro.jTextField4.setEnabled(false);  
        }else{
            JOptionPane.showMessageDialog(null, "Complete los datos");
            }
        }catch(Exception x){
        JOptionPane.showMessageDialog(null, "Datos incorrectos");
        
        }
        
        }
        if(e.getSource()== vistaactpro.jButton4){
            try{
            PreparedStatement ps;
            String id=vistaactpro.jTextField1.getText();
            ps=con.conexion().prepareStatement("delete from propietarios where id_propietarios="+id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Propietario Eliminado");
            this.vistaactpro.jButton2.setEnabled(false);
            this.vistaactpro.jTextField2.setEnabled(false);
            this.vistaactpro.jTextField3.setEnabled(false);
            this.vistaactpro.jTextField4.setEnabled(false);  
            this.vistaactpro.jButton4.setEnabled(false);
            vistaactpro.jTextField1.setText(null);
            vistaactpro.jTextField2.setText(null);
            vistaactpro.jTextField3.setText(null);
            vistaactpro.jTextField4.setText(null);
            }catch(Exception x){
            JOptionPane.showMessageDialog(null, "El usuario no se puede elmininar porque esta asociado a un apto actualize el apto antes de eliminar");
            }
        }
        
        if(e.getSource() == vistaactpro.jButton3){
            this.vistaactpro.jButton2.setEnabled(false);
            this.vistaactpro.jTextField2.setEnabled(false);
            this.vistaactpro.jTextField3.setEnabled(false);
            this.vistaactpro.jTextField4.setEnabled(false);  
              this.vistaactpro.jButton4.setEnabled(false);
            vistaactpro.jTextField1.setText(null);
            vistaactpro.jTextField2.setText(null);
            vistaactpro.jTextField3.setText(null);
            vistaactpro.jTextField4.setText(null); 
            vistaactpro.dispose();
            vistabase.setVisible(true);
            
            
        }
        
        
    }
    
    
}
