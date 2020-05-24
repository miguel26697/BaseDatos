/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo;
import Vista.vistaingreso;
import Vista.VistaBase;
import conjunto.conexion;
import Vista.Vistaconexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class Controlador  implements ActionListener {
   
    private  Vistaconexion Vcon;
    private  conexion conn;
 

    public Controlador(Modelo m,Vistaconexion vcon, conexion conn) {
        this.Vcon=vcon;
        this.Vcon.conpru.addActionListener(this);
        this.conn=conn;
        //this.Vingre.jButton1.addActionListener(this);
     
    }
    public void iniciar(){
    //Vingre.setVisible(false);
    
    
    }

    @Override
    public void actionPerformed(ActionEvent x) {
       try{
           
           if(x.getSource() == Vcon.conpru){
       
               Connection cn=conn.conexion();
           if(cn==null){
           Vcon.lbl.setText("La base de datos no se conecto");
        }
        else{
            Vcon.lbl.setText("La base de datos  se conecto");
        
        }
               
               
           }
           
          
       
       
       
       
       }catch(Exception e){
       
       
       }
    }
    
    
    
    
}
