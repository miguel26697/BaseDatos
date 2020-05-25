/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.VistaActRes;
import Vista.VistaBase;
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
public class actures implements ActionListener{
    private VistaActRes vistaactres;
    private VistaBase vistabase;
    private conexion con;
    public actures(VistaActRes vistaactres,VistaBase vistabase,conexion con){
    this.con=con;
    this.vistaactres=vistaactres;
    this.vistabase=vistabase;
    this.vistaactres.jButton1.addActionListener(this);
    this.vistaactres.jButton2.addActionListener(this);
    this.vistaactres.jButton3.addActionListener(this);
    this.vistaactres.jButton4.addActionListener(this);
    this.vistaactres.jButton2.setEnabled(false);
    this.vistaactres.jButton4.setEnabled(false);
    this.vistaactres.jTextField2.setEnabled(false);
    this.vistaactres.jTextField3.setEnabled(false);
    this.vistaactres.jTextField4.setEnabled(false);
    this.vistaactres.jTextField7.setEnabled(false);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaactres.jButton1){
            try{
          
            String clave="Select id_residente ,nombre ,apellidos,telefono,id_apto  from residentes where id_residente ='"+vistaactres.jTextField1.getText()+"'";
            PreparedStatement ps;
            ResultSet rs;
            ps=con.conexion().prepareStatement(clave);
            rs=ps.executeQuery();
            if(rs.next()){
            vistaactres.jTextField2.setText(rs.getString("nombre"));
            vistaactres.jTextField3.setText(rs.getString("apellidos"));
            vistaactres.jTextField4.setText(rs.getString("telefono"));
            vistaactres.jTextField7.setText(rs.getString("id_apto"));
            this.vistaactres.jButton2.setEnabled(true);
            this.vistaactres.jButton4.setEnabled(true);
            this.vistaactres.jTextField2.setEnabled(true);
            this.vistaactres.jTextField3.setEnabled(true);
            this.vistaactres.jTextField7.setEnabled(true); 
            this.vistaactres.jTextField4.setEnabled(true); 
                
            
            }else{
            vistaactres.jTextField2.setText(null);
            vistaactres.jTextField3.setText(null);
            vistaactres.jTextField4.setText(null); 
            vistaactres.jTextField7.setText(null); 
            this.vistaactres.jTextField7.setEnabled(false); 
            this.vistaactres.jButton2.setEnabled(false);
            this.vistaactres.jButton4.setEnabled(false);
            this.vistaactres.jTextField2.setEnabled(false);
            this.vistaactres.jTextField3.setEnabled(false);
            this.vistaactres.jTextField4.setEnabled(false);  
            JOptionPane.showMessageDialog(null, "id no encontrado");
            }
        }catch(Exception x){
         JOptionPane.showMessageDialog(null, "Datos incorrectos");
        
        }
        
        }
        if(e.getSource() == vistaactres.jButton2){
        try{
            String nom=vistaactres.jTextField2.getText();
            String ape=vistaactres.jTextField3.getText();
            String tel=vistaactres.jTextField4.getText();
            String id_apto=vistaactres.jTextField7.getText();
            PreparedStatement ps;
            ResultSet rs;
            
            if(vistaactres.jTextField2.getText().length()!=0 && vistaactres.jTextField3.getText().length()!=0  && vistaactres.jTextField4.getText().length()!=0 && vistaactres.jTextField7.getText().length()!=0){
            ps=con.conexion().prepareStatement("update residentes set id_residente='"+vistaactres.jTextField1.getText()+"',nombre='"+nom+"',apellidos='"+ape+"',telefono='"+tel+"',id_apto='"+id_apto+"'where id_residente="+vistaactres.jTextField1.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            vistaactres.jTextField2.setText(null);
            vistaactres.jTextField3.setText(null);
            vistaactres.jTextField4.setText(null); 
            vistaactres.jTextField7.setText(null);
            this.vistaactres.jButton4.setEnabled(false);
            this.vistaactres.jButton2.setEnabled(false);
            this.vistaactres.jTextField2.setEnabled(false);
            this.vistaactres.jTextField3.setEnabled(false);
            this.vistaactres.jTextField4.setEnabled(false);  
            this.vistaactres.jTextField7.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(null, "Complete los datos");
            }
        }catch(Exception x){
        JOptionPane.showMessageDialog(null, "Datos incorrectos");
        
        }
        
        }
        if(e.getSource() == vistaactres.jButton4){
        try{
            PreparedStatement ps;
            String id=vistaactres.jTextField1.getText();
            ps=con.conexion().prepareStatement("delete from residentes where id_residente="+id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Propietario Eliminado");
            this.vistaactres.jButton2.setEnabled(false);
            this.vistaactres.jTextField2.setEnabled(false);
            this.vistaactres.jTextField3.setEnabled(false);
            this.vistaactres.jTextField4.setEnabled(false);  
            this.vistaactres.jTextField7.setEnabled(false);  
            this.vistaactres.jButton4.setEnabled(false);
            vistaactres.jTextField1.setText(null);
            vistaactres.jTextField2.setText(null);
            vistaactres.jTextField3.setText(null);
            vistaactres.jTextField4.setText(null);
            vistaactres.jTextField7.setText(null);
            }catch(Exception x){
            JOptionPane.showMessageDialog(null, "El usuario no se puede elmininar porque esta asociado a un dato");
            }
        
        }
        if(e.getSource() == vistaactres.jButton3){
            this.vistaactres.jButton2.setEnabled(false);
            this.vistaactres.jTextField2.setEnabled(false);
            this.vistaactres.jTextField3.setEnabled(false);
            this.vistaactres.jTextField4.setEnabled(false); 
            this.vistaactres.jTextField7.setEnabled(false); 
            this.vistaactres.jButton4.setEnabled(false);
            vistaactres.jTextField1.setText(null);
            vistaactres.jTextField2.setText(null);
            vistaactres.jTextField3.setText(null);
            vistaactres.jTextField4.setText(null);
            vistaactres.jTextField7.setText(null);
            vistaactres.dispose();
            vistabase.setVisible(true);
            
        
        }
        
        
    }
    
}
