/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

/**
 *
 * @author jacob
 */
public class ListenerTeclas extends KeyAdapter {

    JLabel mPantalla;
    
    public ListenerTeclas(JLabel pantalla) {
        mPantalla = pantalla;
    }

    
    
    @Override
    public void keyTyped(KeyEvent e) {
        
        System.out.println(e);
        char c = e.getKeyChar();
        System.out.println(String.valueOf(c));
        if(esNumero(c))
            mPantalla.setText(mPantalla.getText() + String.valueOf(c));
        else if (c == '\n')
            ;
    }
    
    private boolean esNumero(char c){
        try{
            Integer.parseInt(String.valueOf(c));
        }catch (NumberFormatException ne){
            ne.printStackTrace();
            return false;
        }
        return true;
    }
}
