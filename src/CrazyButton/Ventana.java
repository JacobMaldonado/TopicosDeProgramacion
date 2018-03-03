/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrazyButton;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.*;
/**
 *
 * @author jacob
 */
public class Ventana {

    private JFrame ventana;
    private JPanel recipiente;
    private JButton botonLoco[];
    private Random aleatorio;

    public Ventana() {
        ventana = new JFrame();
        recipiente = new JPanel();
        botonLoco = new JButton[3];
        aleatorio = new Random(System.nanoTime());
        inicializarBotonesLocos();
    }
    
    private void inicializarBotonesLocos(){
        for (int i = 0; i < botonLoco.length; i++) {
            botonLoco[i] = new JButton();
        }
    }
    
    public Ventana construir(){
        ventana.setLayout(new BorderLayout());
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(500, 500);
        ventana.add(recipiente, BorderLayout.CENTER);
        recipiente.setPreferredSize(ventana.getSize());
        recipiente.add(botonLoco[0]);
        recipiente.add(botonLoco[1]);
        recipiente.add(botonLoco[2]);
        atributosBotonesLocos();
        
        return this;      
    }
    
    private void atributosBotonesLocos(){
        for (int i = 0; i < botonLoco.length; i++) {
            botonLoco[i].addMouseMotionListener(listenerBotones());///new Listener());
            botonLoco[i].setPreferredSize(new Dimension(100,50));
        }
        botonLoco[0].setText("Toca");
        botonLoco[1].setText("Touch");
        botonLoco[2].setText("Salir");
    }
    
    private MouseMotionListener listenerBotones(){
        return new MouseAdapter(){
            @Override
            public void mouseMoved(MouseEvent e) {
                JButton button = (JButton)e.getSource();
                int x, y, margenX, margenY;
                margenX = recipiente.getWidth() - button.getWidth();
                margenY = recipiente.getHeight() - button.getHeight();
                y = aleatorio.nextInt(margenY); //% recipiente.getHeight();
                x = aleatorio.nextInt(margenX); //% recipiente.getWidth();
                System.out.println("x: "+ x + "y: "+ y);
                //botonLoco.setBounds(x, y, botonLoco.getHeight(), botonLoco.getWidth());
                button.setLocation(x, y);
            }
            
        };
    }
    
    public void mostrar(){
        ventana.setVisible(true);
    }
   
    
    
    
}
