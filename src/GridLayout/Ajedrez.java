/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GridLayout;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.Random;

public class Ajedrez {
    
    private JFrame mTablero;
    private JPanel mCurrentPanel;
    private int mColor;
    private Random rand;
    private JPanel[][] mPaneles;
    
    public Ajedrez(String title){
        mTablero = new JFrame(title);
        mPaneles = new JPanel[8][8];
    }
    
    public void construirDos(){
        mTablero.setSize(800,800);
        mTablero.setLayout(new GridLayout(8,8,0,0));
        mTablero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                mPaneles[i][j] = new JPanel();
                mCurrentPanel = mPaneles[i][j];
                int cuadroPar;
                //se determina cuadro inicial
                if(i % 2 == 0 )
                    cuadroPar = j;
                else
                    cuadroPar = j + 1;
                //se asigna el respectivo color
                if(cuadroPar % 2 == 0)
                    mCurrentPanel.setBackground(Color.BLACK);
                else
                    mCurrentPanel.setBackground(Color.WHITE);
                
                mTablero.add(mCurrentPanel);
            }
        }
    }
    
    public void construirColores(){
        mTablero.setSize(800,800);
        mTablero.setLayout(new GridLayout(8,8,0,0));
        mTablero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rand = new Random(System.nanoTime());
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                mCurrentPanel = new JPanel();
                mColor = rand.nextInt();
                mCurrentPanel.setBackground(Color.getColor(null, mColor));
                System.out.println("Color: "+ mColor + "---" + Color.getColor(null, mColor).toString());
                mTablero.add(mCurrentPanel);
            }
        }
    }
    
    
    public void mostrar(){
        mTablero.setVisible(true);
    }
}
