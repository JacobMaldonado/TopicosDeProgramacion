/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GridBagLayoutBotonesCentrados;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

/**
 *
 * @author jacob
 */
public class Ventana {
    public static int ALTURA = 7;
    public static int ANCHO = 7;
    
    private final JButton botones[];
    private final JFrame ventana;
    private final JButton botonCentral;
    private final JButton botonHorizontal;
    private final JButton botonVertical;
    private final GridBagLayout layout;
    private GridBagConstraints constraints;
    private int perimetro;
    
    public Ventana(){
        ventana = new JFrame();
        botonCentral = new JButton("BOTONSOTE");
        botonHorizontal = new JButton("Horizontal");
        botonVertical = new JButton ("Vertical");
        layout = new GridBagLayout();
        constraints = new GridBagConstraints();
        perimetro =  ALTURA +  ANCHO;
        botones = new JButton[perimetro];
        for (int i = 0; i < perimetro - 2; i++) {
            botones[i] = new JButton(); 
        }
    }
    
    public Ventana construir(){
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(layout);
        //constraints.fill = GridBagConstraints.BOTH;
        int next = 0;
        for (int i = 0; i < ALTURA ; i++) {
            for (int j = 0; j < ANCHO ; j++) {
                if((i == 0 || j == 0) && i != j ){
                    constraints.gridx = i;
                    constraints.gridy = j;
                    layout.setConstraints(botones[next], constraints);
                    if( i == 0)
                        botones[next].setText(String.valueOf(j));
                    else
                        botones[next].setText(String.valueOf((char)('A' - 1 + i)));
                    botones[next].setPreferredSize(new Dimension(150,100));
                    
                    ventana.add(botones[next]);
                    System.out.println(next);
                    next++;
                }
            }
        }
        atributosBotonCentral();
        atributosBotonHorizontal();
        atributosBotonVertical();
        ventana.pack();
        return this;
    }
    
    private void atributosBotonCentral(){
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridheight = 2;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        layout.setConstraints(botonCentral, constraints);
        botonCentral.setFont(new Font("Central",Font.ITALIC,32));
        ventana.add(botonCentral);
    }
    
    private void atributosBotonHorizontal(){
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridheight = 1;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.BOTH;
        layout.setConstraints(botonHorizontal, constraints);
        botonHorizontal.setFont(new Font("Central",Font.ITALIC,22));
        ventana.add(botonHorizontal);
    }
    
    private void atributosBotonVertical(){
        constraints.gridx = 4;
        constraints.gridy = 1;
        constraints.gridheight = 3;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        layout.setConstraints(botonVertical, constraints);
        botonVertical.setFont(new Font("Central",Font.ITALIC,32));
        ventana.add(botonVertical);
    }
    
    public void mostrar(){
        ventana.setVisible(true);
    }
    
}
