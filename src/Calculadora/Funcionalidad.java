/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora;

import com.sun.xml.internal.ws.util.StringUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author jacob
 */
public class Funcionalidad {

    public static final String OPERADOR_SUMA = "+";
    public static final String OPERADOR_RESTA = "-";
    public static final String OPERADOR_MULTIPLICACION = "X";
    public static final String OPERADOR_DIVISION = "/";
    public static final String OPERADOR_PORCENTAJE = "%";
    public static final String OPERADOR_CUADRADO = "X^2";
    public static final String OPERADOR_RAIZ = "RAIZ";

    ///----------------------LISTENERS-------------------------------
    
    public static MouseListener listenerNumerico(JLabel pantalla) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JButton cB = (JButton) e.getSource();
                pantalla.setText(pantalla.getText() + cB.getText());
            }
        };
    }

    public static MouseListener listenerPunto(JLabel pantalla) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JButton cB = (JButton) e.getSource();
                String contenido = pantalla.getText();
                if (!contenido.isEmpty() && !contieneOperadorSinNumero(contenido)) {
                    String operador = operadorUsado(contenido);
                    if(!operador.isEmpty()){
                        String []numeros;
                        numeros = contenido.split(operador);
                        if(contarPuntos(numeros[numeros.length - 1]) < 1)
                            pantalla.setText(contenido + ".");
                    }else{
                        if(contarPuntos(contenido) < 1)
                            pantalla.setText(contenido + ".");
                    }
                }
            }
        };
    }

    public static MouseListener listenerOperadoresBinarios(JLabel pantalla) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String contenido = pantalla.getText();
                JButton btn = (JButton) e.getSource();
                if (!contenido.isEmpty() && !contieneOperadorSinNumero(contenido)) {
                    double valor = hacerOperacionBasica(contenido);
                    String stringValor = String.valueOf(valor);
                    pantalla.setText(stringValor + " " + btn.getText() + " ");
                }
            }
        };
    }
    
    public static MouseListener listenerBotonIgual(JLabel pantalla) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String contenido = pantalla.getText();
                if (!contenido.isEmpty() && !contieneOperadorSinNumero(contenido)) {
                    double valor = hacerOperacionBasica(contenido);
                    pantalla.setText(String.valueOf(valor));
                }
            }

        };
    }

    public static MouseListener listenerNavegabilidad(JLabel pantalla) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String contenido = pantalla.getText();
                String nuevo;
                JButton btn = (JButton) e.getSource();
                if (!contenido.isEmpty()) {
                    nuevo = hacerBorrado(contenido, btn);
                    pantalla.setText(nuevo);
                }
            }

        };
    }
    //----------------------------LISTENER TECLAS--------------------
    
    
    //-----------------------------Metodos de ayuda-------------------------
    
    private static int contarPuntos(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '.')
                count++;
        }
        return count;
    }
    

    private static double hacerOperacionBasica(String contenido) {
        String operandos[];
        if (contenido.contains(OPERADOR_SUMA)) {
            operandos = contenido.split(" \\" + OPERADOR_SUMA + " ");
            return Double.parseDouble(operandos[0]) + Double.parseDouble(operandos[1]);
        } else if (contenido.contains(OPERADOR_RESTA)) {
            operandos = contenido.split(" \\" + OPERADOR_RESTA + " ");
            return Double.parseDouble(operandos[0]) - Double.parseDouble(operandos[1]);
        } else if (contenido.contains(OPERADOR_MULTIPLICACION)) {
            operandos = contenido.split(" " + OPERADOR_MULTIPLICACION + " ");
            return Double.parseDouble(operandos[0]) * Double.parseDouble(operandos[1]);
        } else if (contenido.contains(OPERADOR_DIVISION)) {
            operandos = contenido.split(" \\" + OPERADOR_DIVISION + " ");
            return Double.parseDouble(operandos[0]) / Double.parseDouble(operandos[1]);
        } else if (contenido.contains(OPERADOR_PORCENTAJE)) {
            operandos = contenido.split(" \\" + OPERADOR_PORCENTAJE + " ");
            return Double.parseDouble(operandos[0]) / Double.parseDouble(operandos[1]) * 100;
        } else {
            return Double.parseDouble(contenido);
        }
    }

    private static boolean contieneOperadorSinNumero(String contenido) {
        String texto = contenido.trim();
        if (texto.endsWith(OPERADOR_SUMA)) {
            return true;
        } else if (texto.endsWith(OPERADOR_RESTA)) {
            return true;
        } else if (texto.endsWith(OPERADOR_MULTIPLICACION)) {
            return true;
        } else if (texto.endsWith(OPERADOR_DIVISION)) {
            return true;
        } else if (texto.endsWith(OPERADOR_PORCENTAJE)) {
            return true;
        }
        return false;
    }

    public static MouseListener listenerOperadoresUnarios(JLabel pantalla) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String contenido = pantalla.getText();
                if (!contenido.isEmpty() && !contieneOperadorSinNumero(contenido)) {
                    JButton btn = (JButton) e.getSource();
                    String r;
                    r = resultadoOperacionUnaria(contenido, btn.getText());
                    pantalla.setText(r);
                }
            }
        };
    }

    private static String resultadoOperacionUnaria(String contenido, String op) {
        int indice = contenido.lastIndexOf(" ");
        String c, inicio;
        if (indice > 0) {
            c = contenido.substring(indice);
            inicio = contenido.substring(0, indice).trim() + " ";
        } else {
            c = contenido;
            inicio = "";
        }
        double valor = hacerOperacionAvanzada(c.trim(), op);
        return inicio + String.valueOf(valor);
    }

    private static String operadorUsado(String contenido){
        if(contenido.contains(OPERADOR_SUMA)){
            return " \\" + OPERADOR_SUMA + " ";
        }else if(contenido.contains(OPERADOR_RESTA)){
            return " \\" + OPERADOR_RESTA + " ";
        }else if(contenido.contains(OPERADOR_MULTIPLICACION)){
            return " " + OPERADOR_MULTIPLICACION + " ";
        }else if(contenido.contains(OPERADOR_DIVISION)){
            return " \\" + OPERADOR_DIVISION + " ";
        }else if(contenido.contains(OPERADOR_PORCENTAJE)){
            return " \\" + OPERADOR_PORCENTAJE + " ";
        }else
            return "";
    }

    private static double hacerOperacionAvanzada(String contenido, String op) {
        if (op.equals(OPERADOR_CUADRADO)) {
            return Math.pow(Double.parseDouble(contenido), 2);
        } else if (op.equals(OPERADOR_RAIZ)) {
            return Math.sqrt(Double.parseDouble(contenido));
        }
        return 0;
    }

    private static String hacerBorrado(String contenido, JButton btn) {
        if (btn.getText().equals("<-")) {
            if (contieneOperadorSinNumero(contenido)) {
                return contenido.substring(0, contenido.length() - 3);
            } else {
                return contenido.substring(0, contenido.length() - 1);
            }
        } else {
            return "";
        }
    }

    

}
