/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.VistaBase;
import Vista.VistaActTrab;
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
public class acttrab implements ActionListener{
    private VistaBase vistabase;
    private VistaActTrab vistaacttrab;
    private conexion con;
    
    public acttrab(VistaBase vistabase,VistaActTrab vistaacttrab,conexion con){
    this.con=con;
    this.vistabase=vistabase;
    this.vistaacttrab=vistaacttrab;
    
    this.vistaacttrab.jButton1.addActionListener(this);
    this.vistaacttrab.jButton2.addActionListener(this);
    this.vistaacttrab.jButton3.addActionListener(this);
    this.vistaacttrab.jButton4.addActionListener(this);
    this.vistaacttrab.jButton2.setEnabled(false);
    this.vistaacttrab.jButton3.setEnabled(false);
    this.vistaacttrab.jTextField2.setEnabled(false);
    this.vistaacttrab.jTextField3.setEnabled(false);
    this.vistaacttrab.jTextField4.setEnabled(false);
    this.vistaacttrab.jTextField5.setEnabled(false);
    this.vistaacttrab.jTextField6.setEnabled(false);
    this.vistaacttrab.jTextField8.setEnabled(false);
    this.vistaacttrab.jTextField9.setEnabled(false);
    this.vistaacttrab.jTextField11.setEnabled(false);
    this.vistaacttrab.jTextField12.setEnabled(false);
    
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaacttrab.jButton1){
          try{
          
            String clave="Select id_trabajdor  ,nombre ,apellidos,direccion,fecha_inicio,telefono,eps,caja_com,id_tipo,id_turno  from trabajadores where id_trabajdor ='"+vistaacttrab.jTextField1.getText()+"'";
            PreparedStatement ps;
            ResultSet rs;
            ps=con.conexion().prepareStatement(clave);
            rs=ps.executeQuery();
            if(rs.next()){
            vistaacttrab.jTextField2.setText(rs.getString("nombre"));
            vistaacttrab.jTextField3.setText(rs.getString("apellidos"));
            vistaacttrab.jTextField4.setText(rs.getString("direccion"));
            vistaacttrab.jTextField5.setText(rs.getString("fecha_inicio"));
            vistaacttrab.jTextField6.setText(rs.getString("telefono"));
            vistaacttrab.jTextField8.setText(rs.getString("eps"));
            vistaacttrab.jTextField9.setText(rs.getString("caja_com"));
            vistaacttrab.jTextField11.setText(rs.getString("id_tipo"));
            vistaacttrab.jTextField12.setText(rs.getString("id_turno"));
                this.vistaacttrab.jButton2.setEnabled(true);
                this.vistaacttrab.jButton3.setEnabled(true);
                this.vistaacttrab.jTextField2.setEnabled(true);
                this.vistaacttrab.jTextField3.setEnabled(true);
                this.vistaacttrab.jTextField4.setEnabled(true);
                this.vistaacttrab.jTextField5.setEnabled(true);
                this.vistaacttrab.jTextField6.setEnabled(true);
                this.vistaacttrab.jTextField8.setEnabled(true);
                this.vistaacttrab.jTextField9.setEnabled(true);
                this.vistaacttrab.jTextField11.setEnabled(true);
                this.vistaacttrab.jTextField12.setEnabled(true);
                
            
            }else{
            vistaacttrab.jTextField2.setText(null);
            vistaacttrab.jTextField3.setText(null);
            vistaacttrab.jTextField4.setText(null);
            vistaacttrab.jTextField5.setText(null);
            vistaacttrab.jTextField6.setText(null);
            vistaacttrab.jTextField8.setText(null);
            vistaacttrab.jTextField9.setText(null);
            vistaacttrab.jTextField11.setText(null);
            vistaacttrab.jTextField12.setText(null);
              this.vistaacttrab.jButton2.setEnabled(false);
              this.vistaacttrab.jButton3.setEnabled(false);
              this.vistaacttrab.jTextField2.setEnabled(false);
              this.vistaacttrab.jTextField3.setEnabled(false);
              this.vistaacttrab.jTextField4.setEnabled(false);
              this.vistaacttrab.jTextField5.setEnabled(false);
              this.vistaacttrab.jTextField6.setEnabled(false);
              this.vistaacttrab.jTextField8.setEnabled(false);
              this.vistaacttrab.jTextField9.setEnabled(false);
              this.vistaacttrab.jTextField11.setEnabled(false);
              this.vistaacttrab.jTextField12.setEnabled(false);
            JOptionPane.showMessageDialog(null, "id no encontrado");
            }
        }catch(Exception x){
         JOptionPane.showMessageDialog(null, "Datos incorrectos");
        
        }
        
        }
        
        if(e.getSource()== vistaacttrab.jButton2){
            try{
          String nom=vistaacttrab.jTextField2.getText();
          String ape=vistaacttrab.jTextField3.getText();
          String dir=vistaacttrab.jTextField4.getText();
          String fe=vistaacttrab.jTextField5.getText();
          String tel=vistaacttrab.jTextField6.getText();
          String eps=vistaacttrab.jTextField8.getText();
          String caj=vistaacttrab.jTextField9.getText();
          String idt=vistaacttrab.jTextField11.getText();
          String idtu=vistaacttrab.jTextField12.getText();
          PreparedStatement ps;
          ResultSet rs;
          if(nom.length()!=0 && ape.length()!=0 && dir.length()!=0 && fe.length()!=0 && tel.length()!=0 && eps.length()!=0 && caj.length()!=0 && idt.length()!=0 && idtu.length()!=0 ){
            ps=con.conexion().prepareStatement("update trabajadores set id_trabajdor='"+vistaacttrab.jTextField1.getText()+"'"
                    + ",nombre='"+nom+"',apellidos='"+ape+"',direccion='"+dir+"',fecha_inicio='"+fe+"',telefono='"+tel+"',eps='"+eps+"'"
                    + ",caja_com='"+caj+"',id_tipo='"+idt+"',id_turno='"+idtu+"'"
                            + "where id_trabajdor="+vistaacttrab.jTextField1.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
              vistaacttrab.jTextField2.setText(null);
            vistaacttrab.jTextField3.setText(null);
            vistaacttrab.jTextField4.setText(null);
            vistaacttrab.jTextField5.setText(null);
            vistaacttrab.jTextField6.setText(null);
            vistaacttrab.jTextField8.setText(null);
            vistaacttrab.jTextField9.setText(null);
            vistaacttrab.jTextField11.setText(null);
            vistaacttrab.jTextField12.setText(null);
              this.vistaacttrab.jButton2.setEnabled(false);
              this.vistaacttrab.jButton3.setEnabled(false);
              this.vistaacttrab.jTextField2.setEnabled(false);
              this.vistaacttrab.jTextField3.setEnabled(false);
              this.vistaacttrab.jTextField4.setEnabled(false);
              this.vistaacttrab.jTextField5.setEnabled(false);
              this.vistaacttrab.jTextField6.setEnabled(false);
              this.vistaacttrab.jTextField8.setEnabled(false);
              this.vistaacttrab.jTextField9.setEnabled(false);
              this.vistaacttrab.jTextField11.setEnabled(false);
              this.vistaacttrab.jTextField12.setEnabled(false);
            
        }else{
            JOptionPane.showMessageDialog(null, "Complete los datos");
            }
        
            }catch(Exception x){
            
            }
         
        }
        if(e.getSource() == vistaacttrab.jButton3){
        try{
            PreparedStatement ps;
            String id=vistaacttrab.jTextField1.getText();
            ps=con.conexion().prepareStatement("delete from trabajadores where id_trabajdor="+id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Trabajador  Eliminado");
            vistaacttrab.jTextField2.setText(null);
            vistaacttrab.jTextField3.setText(null);
            vistaacttrab.jTextField4.setText(null);
            vistaacttrab.jTextField5.setText(null);
            vistaacttrab.jTextField6.setText(null);
            vistaacttrab.jTextField8.setText(null);
            vistaacttrab.jTextField9.setText(null);
            vistaacttrab.jTextField11.setText(null);
            vistaacttrab.jTextField12.setText(null);
              this.vistaacttrab.jButton2.setEnabled(false);
              this.vistaacttrab.jButton3.setEnabled(false);
              this.vistaacttrab.jTextField2.setEnabled(false);
              this.vistaacttrab.jTextField3.setEnabled(false);
              this.vistaacttrab.jTextField4.setEnabled(false);
              this.vistaacttrab.jTextField5.setEnabled(false);
              this.vistaacttrab.jTextField6.setEnabled(false);
              this.vistaacttrab.jTextField8.setEnabled(false);
              this.vistaacttrab.jTextField9.setEnabled(false);
              this.vistaacttrab.jTextField11.setEnabled(false);
              this.vistaacttrab.jTextField12.setEnabled(false);
           
            }catch(Exception x){
            JOptionPane.showMessageDialog(null, "El usuario no se puede elmininar porque esta asociado a un dato");
          
        }
    }
        if(e.getSource() == vistaacttrab.jButton4){
        vistaacttrab.dispose();
        vistabase.setVisible(true);
            vistaacttrab.jTextField1.setText(null);
            vistaacttrab.jTextField2.setText(null);
            vistaacttrab.jTextField3.setText(null);
            vistaacttrab.jTextField4.setText(null);
            vistaacttrab.jTextField5.setText(null);
            vistaacttrab.jTextField6.setText(null);
            vistaacttrab.jTextField8.setText(null);
            vistaacttrab.jTextField9.setText(null);
            vistaacttrab.jTextField11.setText(null);
            vistaacttrab.jTextField12.setText(null);
              this.vistaacttrab.jButton2.setEnabled(false);
              this.vistaacttrab.jButton3.setEnabled(false);
              this.vistaacttrab.jTextField2.setEnabled(false);
              this.vistaacttrab.jTextField3.setEnabled(false);
              this.vistaacttrab.jTextField4.setEnabled(false);
              this.vistaacttrab.jTextField5.setEnabled(false);
              this.vistaacttrab.jTextField6.setEnabled(false);
              this.vistaacttrab.jTextField8.setEnabled(false);
              this.vistaacttrab.jTextField9.setEnabled(false);
              this.vistaacttrab.jTextField11.setEnabled(false);
              this.vistaacttrab.jTextField12.setEnabled(false);
        
        
        }
        
        
    
    }
}
