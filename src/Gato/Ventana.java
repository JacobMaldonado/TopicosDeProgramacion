/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gato;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.*;
/**
 *
 * @author jacob
 */
public class Ventana {
    
    private final JFrame mPanelPrincipal;
    private final JPanel mGridPanel;
    private final JLabel mTitulo;
    private final JPanel mButtonPanel;
    private final JButton mButtonExit;
    private final JButton mButtonRestart;
    private final JButton mButtonsGato[];
    private final Font mLabelFont;
    private JPanel mCurrentPanel;
    private Random mRand;
    
    public Ventana (){
        mPanelPrincipal = new JFrame();
        mGridPanel = new JPanel();
        mTitulo = new JLabel("Gato");
        mButtonExit = new JButton ("Salir");
        mButtonRestart = new JButton ("Reiniciar");
        mButtonPanel = new JPanel();
        mButtonsGato = new JButton[9];
        mRand = new Random(System.nanoTime());
        instanciarBotonesGato();
        mLabelFont = mTitulo.getFont();
    }
    
    //instanciar botones
    public void instanciarBotonesGato(){
        for (int i = 0; i < mButtonsGato.length; i++) {
            mButtonsGato[i] = new JButton("Boton " + i);
            
        }
        
    }
    //construir
    public void construir(){
        mPanelPrincipal.setSize(500,600);
        mPanelPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mPanelPrincipal.setLayout(new BorderLayout());
        mButtonPanel.setLayout(new BorderLayout());
        mGridPanel.setLayout(new GridLayout(3,3,5,5));
        mPanelPrincipal.add(mGridPanel,BorderLayout.CENTER);
        mPanelPrincipal.add(mTitulo, BorderLayout.NORTH);   
        label();
        botonesInferiores();
        generarTablero();
    }
    
    public void label(){
        mTitulo.setFont(new Font(mLabelFont.getName(), Font.PLAIN, 42));
        mTitulo.setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    public void botonesInferiores(){
        mButtonPanel.add(mButtonExit, BorderLayout.EAST);
        mButtonPanel.add(mButtonRestart, BorderLayout.WEST);
        mPanelPrincipal.add(mButtonPanel, BorderLayout.SOUTH);
    }
    
    private void generarTablero(){
        for (int i = 0; i < mButtonsGato.length; i++) {
            mButtonsGato[i].setPreferredSize(new Dimension(100,100));
            mButtonsGato[i].setBackground(new Color(mRand.nextInt()));
            mGridPanel.add(mButtonsGato[i]);
        }
    }
    
    public void mostrar(){
        mPanelPrincipal.setVisible(true);
    }
}
