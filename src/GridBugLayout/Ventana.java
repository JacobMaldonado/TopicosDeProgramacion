/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GridBugLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import javax.swing.*;

public class Ventana {
    private final JButton []mButtons;
    private final JFrame mVentanaPrincipal;
    private final GridBagLayout mGridBagLayout;
    private GridBagConstraints mGridBagConstraints;
    
    public Ventana() {
        mVentanaPrincipal = new JFrame("GridBugLayout");
        mButtons = new JButton[5];
        for (int i = 0; i < mButtons.length; i++) {
            mButtons[i] = new JButton();
        }
        mGridBagLayout = new GridBagLayout();
        mGridBagConstraints = new GridBagConstraints();
    }
    
    public Ventana construir() {
        //Frame configuration
        mVentanaPrincipal.setSize(500,500);
        mVentanaPrincipal.setLayout(mGridBagLayout);
        mVentanaPrincipal.setForeground(Color.BLACK);
        
        mGridBagConstraints.insets = new Insets(20,10,20,10);
        for (int i = 0; i < mButtons.length; i++) {
            botones(i);
            mGridBagLayout.setConstraints(mButtons[i], mGridBagConstraints);
            mButtons[i].setText("Button " + String.valueOf(i+1));
            mVentanaPrincipal.add(mButtons[i]);
        }
        
        mVentanaPrincipal.pack();
        mVentanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return this;
    }
    
    private void botones(int index){
        switch(index){
            case 0:
                mGridBagConstraints.gridx = 4;
                mGridBagConstraints.gridy = 0;
                mVentanaPrincipal.add(new JPanel());
                mGridBagConstraints.gridx = 0;
                mGridBagConstraints.gridy = 0;
                mGridBagConstraints.gridheight = 4;
                mGridBagConstraints.fill = GridBagConstraints.VERTICAL;
                break;
            case 4:
                mGridBagConstraints.gridwidth = 2;
                mGridBagConstraints.gridx = 2;
                mGridBagConstraints.gridy = index;
                mGridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
                break;
            default:
                mGridBagConstraints.gridx = index;
                mGridBagConstraints.gridy = index;
                mGridBagConstraints.gridwidth = 1;
                mGridBagConstraints.gridheight = 1;
        }
    }
    
    public void mostrar(){
        mVentanaPrincipal.setVisible(true);
    }
}
