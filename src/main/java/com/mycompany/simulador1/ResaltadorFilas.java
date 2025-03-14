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
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ResaltadorFilas extends DefaultTableCellRenderer {
    private final double porcentajeAceptacion;

    public ResaltadorFilas(double porcentajeAceptacion) {
        this.porcentajeAceptacion = porcentajeAceptacion;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Restablecer el color por defecto
        c.setBackground(Color.WHITE);

        // Encontrar la fila que debe resaltarse
        int filaResaltada = encontrarFilaResaltada(table);

        // Resaltar solo la fila encontrada
        if (row == filaResaltada) {
            c.setBackground(Color.YELLOW);
        }

        return c;
    }

    // Método para encontrar la fila que debe resaltarse
    private int encontrarFilaResaltada(JTable table) {
        double valorMasCercano = -1; // Almacena el valor más cercano por debajo del porcentaje de aceptación
        int filaResaltada = -1; // Almacena la fila a resaltar

        for (int row = 0; row < table.getRowCount(); row++) {
            try {
                // Obtener el valor como cadena y limpiar caracteres no numéricos
                String rawValue = table.getValueAt(row, 4).toString().replaceAll("[^0-9.]", "");

                // Convertir a número
                double porcentajeAcumFila = Double.parseDouble(rawValue);

                // Verificar si el valor es menor o igual al porcentaje de aceptación
                if (porcentajeAcumFila <= porcentajeAceptacion) {
                    // Si es el valor más cercano hasta ahora, actualizar
                    if (porcentajeAcumFila > valorMasCercano) {
                        valorMasCercano = porcentajeAcumFila;
                        filaResaltada = row;
                    }
                }
            } catch (Exception e) {
                System.err.println("Error al convertir el valor en la fila " + row + ": " + e.getMessage());
            }
        }

        return filaResaltada;
    }
}