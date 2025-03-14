/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador1;

/**
 *
 * @author juan
 */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class BinomialChartExample extends JFrame {

    public BinomialChartExample(String title, int n, double p, DefaultCategoryDataset dataset) {
        title = "Gráfica";
        n = 9;
        p = 0.15;
        setTitle(title);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el gráfico de barras
        JFreeChart chart = ChartFactory.createBarChart(
                "Distribución Binomial (n=" + n + ", p=" + p + ")",
                "Número de Éxitos",
                "Probabilidad",
                dataset
        );

        // Personalizar el gráfico
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        // Asignar un solo color a todas las barras (sin resaltar ninguna)
        renderer.setSeriesPaint(0, new Color(100, 150, 250)); // Azul

        // Agregar el gráfico a un panel
        ChartPanel chartPanel = new ChartPanel(chart);
        add(chartPanel);
    }

    // Función para calcular la distribución binomial
    private static double binomialPMF(int n, int k, double p) {
        return factorial(n) / (factorial(k) * factorial(n - k)) * Math.pow(p, k) * Math.pow(1 - p, n - k);
    }

    // Función para calcular factorial
    private static double factorial(int num) {
        if (num == 0) return 1;
        double result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 10;  // Número de ensayos
        double p = 0.5;  // Probabilidad de éxito

        // Crear dataset dinámico
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int x = 0; x <= n; x++) {
            dataset.addValue(binomialPMF(n, x, p), "Probabilidad", String.valueOf(x));
        }

        SwingUtilities.invokeLater(() -> {
            BinomialChartExample chart = new BinomialChartExample("Distribución Binomial", n, p, dataset);
            chart.setVisible(true);
        });
    }
}
