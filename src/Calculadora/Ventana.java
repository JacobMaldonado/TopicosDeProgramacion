/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora;

import java.awt.*;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author jacob
 */
public class Ventana {

    private static final int BOTON_SUMA = 0;
    private static final int BOTON_RESTA = 1;
    private static final int BOTON_DIVISION = 2;
    private static final int BOTON_MULTIPLICACION = 3;
    private static final int BOTON_PORCENTAJE = 4;
    private static final int BOTON_CUADRADO = 5;
    private static final int BOTON_RAIZ = 6;

    private final JFrame mVentana;
    private final JPanel mContenedorBotones;
    private final JButton[] mNumericos;
    private final JButton[] mOperadores;
    private final JButton[] mNavegabilidad;
    private final JButton mResultado;
    private final JLabel mPantalla;
    private final JButton mPunto;
    private final GridBagLayout mLayout;
    private final GridBagConstraints mConstraints;

    public Ventana() {
        mVentana = new JFrame();
        mContenedorBotones = new JPanel();
        mResultado = new JButton();
        mPantalla = new JLabel();
        mNumericos = new JButton[10];
        mOperadores = new JButton[7];
        mNavegabilidad = new JButton[2];
        mConstraints = new GridBagConstraints();
        mLayout = new GridBagLayout();
        mPunto = new JButton();
        instanciarBotonesNumericos();
        instanciarBotonesFunciones();
        instanciarBotonesNavegabilidad();
    }

    public Ventana construir() {
        //atributos de los componentes
        atributosVentana();
        atributosContenedorBotones();
        atributosPantalla();
        //listeners
        agregarListenersBotonesFunciones();
        //agregar componentes al panel
        
        agregarBotonesNumericos();
        agregarBotonesExpresiones();
        agregarBotonResultado();
        agregarBotonesNavegabilidad();
        return this;
    }
    
    private void instanciarBotonesNavegabilidad(){
        
        mNavegabilidad[0] = new JButton("<-");
        mNavegabilidad[0].addMouseListener(Funcionalidad.listenerNavegabilidad(mPantalla));
        mNavegabilidad[1] = new JButton("CE");
        mNavegabilidad[1].addMouseListener(Funcionalidad.listenerNavegabilidad(mPantalla));
        
    }

    private void instanciarBotonesNumericos() {
        for (int i = 0; i < mNumericos.length; i++) {
            mNumericos[i] = new JButton(String.valueOf(i));
            mNumericos[i].addMouseListener(Funcionalidad.listenerNumerico(mPantalla));
        }
    }

    private void instanciarBotonesFunciones() {
        mOperadores[BOTON_SUMA] = new JButton("+");
        mOperadores[BOTON_RESTA] = new JButton("-");
        mOperadores[BOTON_MULTIPLICACION] = new JButton("X");
        mOperadores[BOTON_DIVISION] = new JButton("/");
        mOperadores[BOTON_PORCENTAJE] = new JButton("%");
        mOperadores[BOTON_CUADRADO] = new JButton("X^2");
        mOperadores[BOTON_RAIZ] = new JButton("RAIZ");
    }
    
    private void agregarListenersBotonesFunciones(){
        MouseListener listenerBasicas,listenerAvanzadas;
        listenerBasicas = Funcionalidad.listenerOperadoresBinarios(mPantalla);
        listenerAvanzadas = Funcionalidad.listenerOperadoresUnarios(mPantalla);
        mOperadores[BOTON_SUMA].addMouseListener(listenerBasicas);
        mOperadores[BOTON_RESTA].addMouseListener(listenerBasicas);
        mOperadores[BOTON_MULTIPLICACION].addMouseListener(listenerBasicas);
        mOperadores[BOTON_DIVISION].addMouseListener(listenerBasicas);
        mOperadores[BOTON_PORCENTAJE].addMouseListener(listenerBasicas);
        mOperadores[BOTON_RAIZ].addMouseListener(listenerAvanzadas);
        mOperadores[BOTON_CUADRADO].addMouseListener(listenerAvanzadas);
    }
    
    

    private void atributosVentana() {
        mVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mVentana.setSize(700, 350);
        mVentana.setLayout(new BorderLayout());
        mVentana.add(mContenedorBotones, BorderLayout.CENTER);
        mVentana.add(mPantalla, BorderLayout.NORTH);
    }
    
    private void atributosContenedorBotones(){
        mContenedorBotones.setLayout(mLayout);
    }

    private void atributosPantalla(){
        mPantalla.setPreferredSize(new Dimension(230,50));
        mPantalla.addKeyListener(new ListenerTeclas(mPantalla));
        mPantalla.setBackground(Color.white);
        mPantalla.setFont(new Font("Pantalla", Font.BOLD, 42));
        mPantalla.setBorder(new EmptyBorder(20, 20, 20, 20));
        mPantalla.setOpaque(true);
    }
    
    private void agregarBotonesNumericos() {
        for (int i = 1; i < mNumericos.length; i++) {
            mConstraints.gridx = (i - 1) % 3;
            mConstraints.gridy = (int) (i - 1) / 3;
            mLayout.setConstraints(mNumericos[i], mConstraints);
            mContenedorBotones.add(mNumericos[i]);
        }
        agregarBotonPunto();
        atributosBotonCero();
        mContenedorBotones.add(mNumericos[0]);
        
    }
    
    private void atributosBotonCero(){
        mConstraints.gridx = 0;
        mConstraints.gridy = 3;
        mConstraints.gridwidth = 2;
        mConstraints.fill = GridBagConstraints.BOTH;
        mLayout.setConstraints(mNumericos[0], mConstraints);
        mConstraints.gridwidth = 1;
    }
    
    private void agregarBotonPunto(){
        mPunto.setText(".");
        mPunto.addMouseListener(Funcionalidad.listenerPunto(mPantalla));
        mConstraints.gridx = 2;
        mConstraints.gridy = 3;
        mConstraints.fill = GridBagConstraints.BOTH;
        mLayout.setConstraints(mPunto, mConstraints);
        mContenedorBotones.add(mPunto);
    }
    

    private void agregarBotonesExpresiones() {
        for (int i = 0; i < mOperadores.length; i++) {
            mConstraints.gridx = 3 + i % 2;
            mConstraints.gridy = (int) (i / 2);
            mLayout.setConstraints(mOperadores[i], mConstraints);
            mContenedorBotones.add(mOperadores[i]);
        }
    }

    private void agregarBotonResultado() {
        mConstraints.gridx = 4;
        mConstraints.gridy = 3;
        mConstraints.gridwidth = 2;
        mLayout.setConstraints(mResultado, mConstraints);
        mResultado.setText("=");
        mResultado.addMouseListener(Funcionalidad.listenerBotonIgual(mPantalla));
        mContenedorBotones.add(mResultado);
        mConstraints.gridwidth = 1;
    }
    
    private void agregarBotonesNavegabilidad(){
        //boton retroceso
        mConstraints.gridx = 5;
        mConstraints.gridy = 0;
        mLayout.setConstraints(mNavegabilidad[0], mConstraints);
        mContenedorBotones.add(mNavegabilidad[0]);
        //boton CE
        mConstraints.gridx = 5;
        mConstraints.gridy = 1;
        mConstraints.gridheight = 2;
        mLayout.setConstraints(mNavegabilidad[1], mConstraints);
        mContenedorBotones.add(mNavegabilidad[1]);
        mConstraints.gridheight = 1;
    }
    
    public void mostrar(){
        mVentana.pack();
        mVentana.setVisible(true);
    }

    public JLabel getPantalla(){
        return mPantalla;
    }
}
