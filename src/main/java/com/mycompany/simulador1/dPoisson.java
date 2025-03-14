/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
/**
 *
 * @author juan
 */
import javax.swing.*;

public class dPoisson extends JFrame {

    public dPoisson() {
        // Configuración del frame
        setTitle("Calculadora de Poisson");
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Para cerrar correctamente la ventana
        setLocationRelativeTo(null); // Para centrar la ventana en la pantalla

        // Crear y configurar los componentes
        JLabel lblAlpha = new JLabel("Alpha:");
        lblAlpha.setBounds(20, 20, 140, 20);
        JTextField txtAlpha = new JTextField();
        txtAlpha.setBounds(160, 20, 50, 20);

        JLabel lblK = new JLabel("K:");
        lblK.setBounds(220, 20, 150, 20);
        JTextField txtK = new JTextField();
        txtK.setBounds(270, 20, 50, 20);
        
        JLabel lblP = new JLabel("P:");
        lblP.setBounds(20, 50, 140, 20);
        JTextField txtP = new JTextField();
        txtP.setBounds(160, 50, 50, 20);
        
        JLabel lblN = new JLabel("N:");
        lblN.setBounds(220, 50, 150, 20);
        JTextField txtN = new JTextField();
        txtN.setBounds(270, 50, 50, 20);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(20, 80, 140, 20);
        JTextField txtResultado = new JTextField();
        txtResultado.setBounds(160, 80, 150, 20);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 130, 150, 20);

        // Agregar los componentes al frame
        add(lblK);
        add(txtK);
        add(lblAlpha);
        add(txtAlpha);
        add(lblP);
        add(txtP);
        add(lblN);
        add(txtN);
        add(lblResultado);
        add(txtResultado);
        add(btnCalcular);

        // Hacer visible la ventana
        setVisible(true);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int k = Integer.parseInt(txtK.getText());
                    System.out.println("Número válido: " + k); // Solo para depuración
                    double alpha = Double.parseDouble(txtAlpha.getText());
                    System.out.println(calcularPoisson(k, alpha));
                    double txtPPoisson = Double.parseDouble(txtP.getText());
                    double n = Double.parseDouble(txtN.getText());
                    double mult1 = n * txtPPoisson;
                    if(txtPPoisson!= 0 && n != 0){
                        System.out.println("p = " + txtPPoisson);
                        System.out.println("mult1 = " + mult1);
                        if (txtPPoisson >= 0.1 && mult1 >= 10){
                            alpha = txtPPoisson * n;
                            System.out.println("alpha = " + alpha);
                            txtResultado.setText(String.valueOf(calcularPoisson(k, alpha)));
                            System.out.println("calcularPoisson(k, alpha) = " + calcularPoisson(k, alpha));
                        }
                    }
                    
                    if (k!= 0 && alpha != 0){
                        txtResultado.setText(String.valueOf(calcularPoisson(k, alpha)));
                    }
                    
                } catch (NumberFormatException ee) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número entero para K.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
        );
    }

    // Método para ejecutar la ventana desde otra clase
    public static void mostrar() {
        SwingUtilities.invokeLater(dPoisson::new);
    }

    public static void main(String[] args) {
        mostrar();
    }

    public static BigInteger calcularFactorial(int n) {
        // Inicializamos el resultado como 1
        BigInteger resultado = BigInteger.ONE;

        // Multiplicamos desde 1 hasta n
        for (int i = 1; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }

        return resultado;
    }

    public static BigDecimal calcularPoisson(int k, double alpha) {
        MathContext mc = new MathContext(20);
        BigDecimal potencia = new BigDecimal(alpha).pow(k, new MathContext(20));;
        BigDecimal factorial = new BigDecimal(calcularFactorial(k));
        BigDecimal vEuler = new BigDecimal(Math.exp(-alpha), mc);
        BigDecimal mult1 = vEuler.multiply(potencia);
        BigDecimal resultado = mult1.divide(factorial, 20, RoundingMode.HALF_UP);
        return resultado;
    }
}
