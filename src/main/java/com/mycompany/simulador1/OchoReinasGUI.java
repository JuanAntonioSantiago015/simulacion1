/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador1;

/**
 *
 * @author juan
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OchoReinasGUI extends JFrame {

    private static final int N = 8; // Tamaño del tablero
    private JButton[][] casillas = new JButton[N][N];
    private int[][] tablero = new int[N][N];

    public OchoReinasGUI() {
//        setTitle("Problema de las 8 Reinas");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el panel del tablero
        JPanel panelTablero = new JPanel(new GridLayout(N, N));
        panelTablero.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Inicializar el tablero y los botones
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                casillas[i][j] = new JButton();
                casillas[i][j].setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.BLACK);
                casillas[i][j].setOpaque(true);
                casillas[i][j].setBorderPainted(false);
                final int fila = i;
                final int columna = j;
                casillas[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        colocarReina(fila, columna);
                    }
                });
                panelTablero.add(casillas[i][j]);
            }
        }

        // Botón para resolver el problema
        JButton botonResolver = new JButton("Resolver");
        botonResolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resolverProblema();
            }
        });

        // Botón para reiniciar el tablero
        JButton botonReiniciar = new JButton("Reiniciar");
        botonReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarTablero();
            }
        });

        // Panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(botonResolver);
        panelBotones.add(botonReiniciar);

        // Añadir componentes al JFrame
        add(panelTablero, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void colocarReina(int fila, int columna) {
        // Limpiar el tablero antes de colocar una nueva reina
        reiniciarTablero();

        // Colocar la reina en la posición seleccionada
        tablero[fila][columna] = 1;
        casillas[fila][columna].setBackground(Color.RED);
        casillas[fila][columna].setText("R");
    }

    private void resolverProblema() {
        if (resolverProblema(0)) {
            JOptionPane.showMessageDialog(this, "Solución encontrada!");
            actualizarTablero();
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró una solución.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean resolverProblema(int columna) {
        if (columna >= N) {
            return true; // Todas las reinas han sido colocadas
        }

        for (int i = 0; i < N; i++) {
            if (esSeguro(i, columna)) {
                tablero[i][columna] = 1; // Colocar la reina

                if (resolverProblema(columna + 1)) {
                    return true;
                }

                tablero[i][columna] = 0; // Retroceder (backtracking)
            }
        }

        return false; // No se pudo colocar la reina en esta columna
    }

    private boolean esSeguro(int fila, int columna) {
        // Verificar la fila hacia la izquierda
        for (int i = 0; i < columna; i++) {
            if (tablero[fila][i] == 1) {
                return false;
            }
        }

        // Verificar la diagonal superior izquierda
        for (int i = fila, j = columna; i >= 0 && j >= 0; i--, j--) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }

        // Verificar la diagonal inferior izquierda
        for (int i = fila, j = columna; i < N && j >= 0; i++, j--) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }

        return true; // Es seguro colocar la reina
    }

    private void actualizarTablero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    casillas[i][j].setBackground(Color.RED);
                    casillas[i][j].setText("R");
                } else {
                    casillas[i][j].setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.BLACK);
                    casillas[i][j].setText("");
                }
            }
        }
    }

    private void reiniciarTablero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tablero[i][j] = 0;
                casillas[i][j].setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.BLACK);
                casillas[i][j].setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OchoReinasGUI().setVisible(true);
            }
        });
    }
}
