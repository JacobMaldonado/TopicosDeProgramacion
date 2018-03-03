/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jacob
 */
public class Ventana {

    JFrame ventana;
    JLabel lab_arriba, lab_abajo;
    JPanel area;

    public class EscMuse implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) { //To change body of generated methods, choose Tools | Templates.
            area.setBackground(new Color(new Random(System.nanoTime()).nextInt()));
            lab_abajo.setText("saquese prro");
            
            area.setPreferredSize(new Dimension(area.getWidth()-100, area.getHeight()-100));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            area.setBackground(new Color(new Random(System.nanoTime()).nextInt()));
            lab_abajo.setText("no lo haga compa");
            area.setPreferredSize(new Dimension(area.getWidth()+100, area.getHeight()+100));
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    public Ventana() {
        ventana = new JFrame();
        lab_abajo = new JLabel();
        lab_arriba = new JLabel();
        area = new JPanel();
        
    }

    //propiedades
    //armado
    public void construir(){
        ventana.setLayout(new BorderLayout());
        ventana.setSize(500,500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(area, BorderLayout.CENTER);
        ventana.add(lab_arriba, BorderLayout.NORTH);
        ventana.add(lab_abajo, BorderLayout.SOUTH);
        labels();
        escuchas();
        ventana.setVisible(true);
    }
    
    //labels
    public void labels(){
        Font f = new Font("labels",Font.BOLD, 42);
        lab_arriba.setText("Arriba");
        lab_arriba.setFont(f);
        lab_abajo.setText("Abajo");
        lab_abajo.setFont(f);
    }
    //escuchas
    public void escuchas(){
        area.addMouseListener(new EscMuse());
    }
    //hacerlo visible
}
