/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador1;

/**
 *
 * @author juan_antonio
*/

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class grafica extends JFrame {

    private List<Punto> points; // Usamos una clase personalizada para manejar double

    public grafica() {
        setTitle("Gráfica de Puntos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        points = new ArrayList<>();

        // Leer datos del archivo
        leerDatos("datos.txt");

        // Crear el panel de la gráfica
        JPanel graphPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dibujarPuntos(g);
            }
        };
        graphPanel.setBackground(Color.WHITE);

        // Añadir el panel a la ventana
        getContentPane().add(graphPanel);
    }

    private void leerDatos(String rutaArchivo) {
        try (Scanner scanner = new Scanner(new File(rutaArchivo))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    double x = Double.parseDouble(partes[0].trim());
                    double y = Double.parseDouble(partes[1].trim());
                    points.add(new Punto(x, y)); // Añadir punto a la lista
                }
            }
            System.out.println("Datos leídos correctamente de " + rutaArchivo);
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir datos: " + e.getMessage());
        }
    }

    private void dibujarPuntos(Graphics g) {
        for (Punto punto : points) {
            int x = (int) punto.getX(); // Convertir double a int para dibujar
            int y = (int) punto.getY(); // Convertir double a int para dibujar
            g.setColor(Color.BLUE);
            g.fillOval(x - 5, y - 5, 10, 10); // Dibujar un círculo en cada punto
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            grafica ventana = new grafica();
            ventana.setVisible(true);
        });
    }
}

// Clase personalizada para manejar coordenadas con decimales
class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}