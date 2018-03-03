/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javafx.scene.paint.Color;
import javax.swing.*;

/**
 *
 * @author jacob
 */
public class MiVentana {
    //declaracion de componentes
    private JFrame ventana;
    
    //panel
    private JPanel pan_north;
    private JPanel pan_east;
    private JPanel pan_west;
    private JPanel pan_south;
    private JPanel pan_center;
    //botones
    private JButton button_agree;
    private JButton button_left;
    private JButton button_right;
    private JButton button_bottom;
    private JButton button_center;
    
    //inicializacion de componentes
    public MiVentana(String title){
        ventana = new JFrame(title);
        
        pan_north = new JPanel();
        pan_east = new JPanel();
        pan_west = new JPanel();
        pan_south = new JPanel();
        pan_center = new JPanel();
        
        button_agree = new JButton("arriba");
        button_right = new JButton("derecha");
        button_left = new JButton("izquierda");
        button_bottom = new JButton("abajo");
        button_center = new JButton("centro");
        atributos();
        armar();
    }
    //Atributos a los componentes
    public void atributos(){
        ventana.setSize(300, 400);
        ventana.setLayout(new BorderLayout(10,10));
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        atributosPaneles();
        button_agree.setBounds(60,30,100,80);
    }
    
    public void atributosPaneles(){
        pan_north.setBackground(java.awt.Color.MAGENTA);
        pan_west.setBackground(java.awt.Color.red);
        pan_east.setBackground(java.awt.Color.BLUE);
        pan_south.setBackground(java.awt.Color.YELLOW);
        pan_center.setBackground(java.awt.Color.ORANGE);
    }
    

    //armar la vista
    public void armar(){
        ventana.add(pan_north, BorderLayout.NORTH);
        ventana.add(pan_west, BorderLayout.WEST);
        ventana.add(pan_east, BorderLayout.EAST);
        ventana.add(pan_south, BorderLayout.SOUTH);
        ventana.add(pan_center, BorderLayout.CENTER);
        pan_north.add(button_agree);
        pan_west.add(button_left);
        pan_east.add(button_right);
        pan_south.add(button_bottom);
        pan_center.add(button_center);
    }
    //mostrar
    public void mostrar(){
        ventana.setVisible(true);
    }
}
