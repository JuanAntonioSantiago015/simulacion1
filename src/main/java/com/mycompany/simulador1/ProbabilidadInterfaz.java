/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class ProbabilidadInterfaz extends JFrame {

    private static DefaultTableModel modeloTabla;
    private static JTable tabla;
    private static JScrollPane scrollPane;

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    static DefaultCategoryDataset dat = new DefaultCategoryDataset();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de Probabilidad");
        frame.setSize(600, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiquetas y campos de texto
        JLabel lblExito = new JLabel("p");
        lblExito.setBounds(20, 20, 140, 20);
        JTextField txtExito = new JTextField();
        txtExito.setBounds(160, 20, 50, 20);

        JLabel lblFracaso = new JLabel("q");
        lblFracaso.setBounds(220, 20, 150, 20);
        JTextField txtFracaso = new JTextField();
        txtFracaso.setBounds(370, 20, 50, 20);

        JLabel lblMuestra = new JLabel("Muestra");
        lblMuestra.setBounds(430, 20, 60, 20);
        JTextField txtMuestra = new JTextField();
        txtMuestra.setBounds(490, 20, 50, 20);

        JLabel lblPoblacion = new JLabel("Población");
        lblPoblacion.setBounds(20, 50, 80, 20);
        JTextField txtPoblacion = new JTextField();
        txtPoblacion.setBounds(110, 50, 50, 20);

        JLabel lblNumExitos = new JLabel("x=");
        lblNumExitos.setBounds(170, 50, 20, 20);
        JTextField txtNumExitos = new JTextField();
        txtNumExitos.setBounds(200, 50, 50, 20);

        JLabel lblPorcentajeAceptacion = new JLabel("%");
        lblPorcentajeAceptacion.setBounds(260, 50, 20, 20);
        JTextField txtPorcentajeAceptacion = new JTextField();
        txtPorcentajeAceptacion.setBounds(300, 50, 50, 20);

        String[] opciones = {"x=", "x<=", "x>="};
        JComboBox<String> comboOpciones = new JComboBox<>(opciones);
        comboOpciones.setBounds(360, 50, 80, 20);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(20, 110, 80, 20);
        JTextField txtResultado = new JTextField();
        txtResultado.setBounds(100, 110, 200, 20);

        JButton btnCalcular = new JButton("Calcular:");
        btnCalcular.setBounds(420, 110, 150, 20);

        JLabel lblMedia = new JLabel("Media:");
        lblMedia.setBounds(20, 140, 80, 20);
        JTextField txtMedia = new JTextField();
        txtMedia.setBounds(100, 140, 200, 20);

        JLabel lblDE = new JLabel("D. E.:");
        lblDE.setBounds(20, 170, 80, 20);
        JTextField txtDE = new JTextField();
        txtDE.setBounds(100, 170, 200, 20);

        JLabel lblFactor = new JLabel("F.C.:");
        lblFactor.setBounds(20, 200, 80, 20);
        JTextField txtFactor = new JTextField();
        txtFactor.setBounds(100, 200, 200, 20);

        JLabel lblSesgo = new JLabel("Sesgo:");
        lblSesgo.setBounds(20, 230, 80, 20);
        JTextField txtSesgo = new JTextField();
        txtSesgo.setBounds(100, 230, 200, 20);
        JLabel txtTipoS = new JLabel();
        txtTipoS.setBounds(370, 230, 200, 20);

        JLabel lblCurtosis = new JLabel("Curtosis:");
        lblCurtosis.setBounds(20, 260, 80, 20);
        JTextField txtCurtosis = new JTextField();
        txtCurtosis.setBounds(100, 260, 200, 20);
        JLabel txtTipoC = new JLabel();
        txtTipoC.setBounds(370, 260, 200, 20);

        // Agregar componentes al frame
        frame.add(lblExito);
        frame.add(lblPorcentajeAceptacion);
        frame.add(txtPorcentajeAceptacion);
        frame.add(lblSesgo);
        frame.add(txtSesgo);
        frame.add(txtTipoS);
        frame.add(txtTipoC);
        frame.add(lblCurtosis);
        frame.add(txtCurtosis);
        frame.add(lblFactor);
        frame.add(txtFactor);
        frame.add(txtExito);
        frame.add(lblFracaso);
        frame.add(txtFracaso);
        frame.add(lblMuestra);
        frame.add(txtMuestra);
        frame.add(lblPoblacion);
        frame.add(txtPoblacion);
        frame.add(comboOpciones);
        frame.add(btnCalcular);
        frame.add(lblResultado);
        frame.add(txtResultado);
        frame.add(lblNumExitos);
        frame.add(txtNumExitos);
        frame.add(lblMedia);
        frame.add(txtMedia);
        frame.add(lblDE);
        frame.add(txtDE);
        frame.setVisible(true);
        modeloTabla = new DefaultTableModel(new Object[]{"n", "Valor Binomial", "Valor binomial acumulado", "Porcentaje", "Porcentaje acumulado"}, 0);
        tabla = new JTable(modeloTabla);

        // Agregar la tabla dentro de un JScrollPane
        scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(50, 400, 500, 150);  // Ubicación en vertical 400
        frame.add(scrollPane);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoQ = txtFracaso.getText().trim();
                String textoP = txtExito.getText().trim();

                double q, p;

                try {
                    q = textoQ.isEmpty() ? Double.NaN : Double.parseDouble(textoQ);
                } catch (NumberFormatException eee) {
                    q = Double.NaN;
                }

                try {
                    p = textoP.isEmpty() ? Double.NaN : Double.parseDouble(textoP);
                } catch (NumberFormatException eee) {
                    p = Double.NaN;
                }

// Si uno está vacío, toma el valor del otro menos 1
                if (Double.isNaN(q) && !Double.isNaN(p)) {
                    q = 1 - p;
                } else if (Double.isNaN(p) && !Double.isNaN(q)) {
                    p = 1 - q;
                } else if (Double.isNaN(q) && Double.isNaN(p)) {
                    // Ambos están vacíos o inválidos, establecer valores predeterminados
                    JOptionPane.showMessageDialog(null, "Ingrese un valor para p o q");
                }

                System.out.println("Valor de p: " + p);
                System.out.println("Valor de q: " + q);

                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                modeloTabla.setRowCount(0);
                String seleccionado = (String) comboOpciones.getSelectedItem();
                //double p = Double.parseDouble(txtExito.getText());
                //double q = Double.parseDouble(txtFracaso.getText());
                int n = Integer.parseInt(txtMuestra.getText());
                System.out.println("n = " + n);
                int N = Integer.parseInt(txtPoblacion.getText());
                String textN = txtPoblacion.getText().trim();
                int x = Integer.parseInt(txtNumExitos.getText());
                double fivePrcnt = N * 0.05;
                System.out.println("fivePrcnt = " + fivePrcnt);
                double vFinal = 0;
                double porcentajeAcum = 0;
                double probAcum = 0;
                double porcentajeAceptacion = Integer.parseInt(txtPorcentajeAceptacion.getText());

                if (x > n) {
                    JOptionPane.showMessageDialog(null, "x no debe ser mayor a la muestra");
                } else {
                    //////////Para igual
                String texto = txtFracaso.getText().trim();

                    if (seleccionado.equals("x=")) {
                        double media = n * p;
                        txtMedia.setText(String.valueOf(media));

                        if (n <= fivePrcnt || N == 0) {
                            double calc = Math.sqrt(n * p * q);
                            System.out.println("Este es el valor de n en la primer condicional" + n);
                            txtDE.setText(String.valueOf(calc));
                            System.out.println("Es menor al 5%");
                            txtFactor.setText("");

                        }

                        if (N != 0) {
                            double FC = factorCorreccion(N, n);
                            txtFactor.setText(String.valueOf(FC));
                            double calc = Math.sqrt(n * p * q);
                            double respuesta = FC * calc;
                            txtDE.setText(String.valueOf(respuesta));
                            System.out.println("Es mayor al 5%");
                        }

                        for (int i = 0; i <= x; i++) {  // Iterar hasta 'x' en lugar de 'n'
                            double vBinomial = calcularBinomial(p, q, n, i);
                            vFinal += vBinomial;
                            dataset.addValue(vBinomial, "Probabilidad", String.valueOf(i));
                            double porcentaje1 = vBinomial * 100;
                            porcentajeAcum += porcentaje1;
                            probAcum += vBinomial;
                            agregarFila(i, vBinomial, probAcum, porcentaje1, porcentajeAcum);
                            dat.addValue(porcentajeAcum, "Porcentajes", String.valueOf(i));
                            tabla.setDefaultRenderer(Object.class, new ResaltadorFilas(porcentajeAceptacion));
                        }
                        var vFinal1 = calcularBinomial(p, q, n, x);
                        txtResultado.setText(String.valueOf(vFinal1));
                        agregarFila(n, calcularBinomial(p, q, n, x), calcularBinomial(p, q, n, x), calcularBinomial(p, q, n, x) * 100, calcularBinomial(p, q, n, x) * 100);

                    }

                    ////////////Para menor o igual
                if (seleccionado.equals("x<=")) {
                        vFinal = 0; // Reiniciar la variable antes de empezar a sumar

                        if (n <= fivePrcnt || N == 0) {
                            double calc = Math.sqrt(n * p * q);
                            txtDE.setText(String.valueOf(calc));
                            txtFactor.setText("");
                        }
                        if (N != 0) {
                            double FC = factorCorreccion(N, n);
                            txtFactor.setText(String.valueOf(FC));
                            double calc = Math.sqrt(n * p * q);
                            double respuesta = FC * calc;
                            txtDE.setText(String.valueOf(respuesta));
                        }

                        double media = n * p;
                        txtMedia.setText(String.valueOf(media));

                        for (int i = 0; i <= x; i++) {  // Iterar hasta 'x' en lugar de 'n'
                            double vBinomial = calcularBinomial(p, q, n, i);
                            vFinal += vBinomial;
                            dataset.addValue(vBinomial, "Probabilidad", String.valueOf(i));
                            double porcentaje1 = vBinomial * 100;
                            porcentajeAcum += porcentaje1;
                            probAcum += vBinomial;
                            agregarFila(i, vBinomial, probAcum, porcentaje1, porcentajeAcum);
                            dat.addValue(porcentajeAcum, "Porcentajes", String.valueOf(i));
                            tabla.setDefaultRenderer(Object.class, new ResaltadorFilas(porcentajeAceptacion));
                        }

                        txtResultado.setText(String.valueOf(vFinal));
                    }

                    ////////////Para mayor o igual
                if (seleccionado.equals("x>=")) {
                        vFinal = 0; // Reiniciar la variable antes de empezar a sumar

                        if (fivePrcnt <= n || N == 0) {
                            double calc = Math.sqrt(n * p * q);
                            txtDE.setText(String.valueOf(calc));
                            txtFactor.setText("");
                        }

                        if (N != 0) {
                            double FC = factorCorreccion(N, n);
                            txtFactor.setText(String.valueOf(FC));
                            double calc = Math.sqrt(n * p * q);
                            double respuesta = FC * calc;
                            txtDE.setText(String.valueOf(respuesta));
                        }

                        double media = n * p;
                        txtMedia.setText(String.valueOf(media));

                        for (int i = x; i <= n; i++) {  // Aquí se debe iterar desde 'x' hasta 'n'
                            double vBinomial = calcularBinomial(p, q, n, i);
                            vFinal += vBinomial;
                            dataset.addValue(vBinomial, "Probabilidad", String.valueOf(i));
                            double porcentaje1 = vBinomial * 100;
                            porcentajeAcum += porcentaje1;
                            probAcum += vBinomial;
                            agregarFila(i, vBinomial, probAcum, porcentaje1, porcentajeAcum);
                            dat.addValue(porcentajeAcum, "Porcentajes", String.valueOf(i));
                            tabla.setDefaultRenderer(Object.class, new ResaltadorFilas(porcentajeAceptacion));
                        }

                        txtResultado.setText(String.valueOf(vFinal));
                    }

                    //////////Cálculo de calcularSesgo
                txtSesgo.setText(String.valueOf(calcularSesgo(q, p, n)));
                    double ses = calcularSesgo(q, p, n);
                    if (ses == 0) {
                        txtTipoS.setText("Curva simétrica");
                    }
                    if (ses < 0) {
                        txtTipoS.setText("Asimétrica hacia la izquierda");
                    }
                    if (ses > 0) {
                        txtTipoS.setText("Asimétrica hacia la derecha");
                    }

                    //////////Cálculo de curtosis
                txtCurtosis.setText(String.valueOf(curtosis(q, p, n)));
                    double curt = curtosis(q, p, n);
                    //double tipo = curt - 3;
                    if (curt == 0) {
                        txtTipoC.setText("Mesocúrtica");
                    }
                    if (curt < 0) {
                        txtTipoC.setText("Platicúrtica");
                    }
                    if (curt > 0) {
                        txtTipoC.setText("Leptocúrtica");
                    }
                    // Primer gráfico
                    JFreeChart chart = ChartFactory.createBarChart("Distribución binomial", "Valor de n", "Valor binomial", dataset);
                    ChartPanel chartPanel = new ChartPanel(chart);
                    JFrame frame = new JFrame("Gráfica Binomial");
                    frame.setSize(800, 600);
                    frame.setContentPane(chartPanel);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);

                    // Segundo gráfico
                    JFreeChart porcentajes = ChartFactory.createBarChart("Porcentajes", "Valor de n", "Valor de porcentajes", dat);
                    ChartPanel chartPanel2 = new ChartPanel(porcentajes);
                    JFrame frame2 = new JFrame("Gráfica de Porcentajes");
                    frame2.setSize(800, 600);
                    frame2.setContentPane(chartPanel2);
                    frame2.setLocation(frame.getX() + 820, frame.getY()); // Ubicar al lado de la primera ventana
                    frame2.setVisible(true);
                }
            }
        });
    }

    public static void agregarFila(double n, double vBinomial, double vBinomialAcum, double porcentaje, double porcentajeAcum) {
        modeloTabla.addRow(new Object[]{n, vBinomial, vBinomialAcum, porcentaje, porcentajeAcum});
    }

    public static double curtosis(double q, double p, double n) {
        double mult2 = 6 * p * q;
        double resta = 1 - mult2;
        double multiplicacion = n * q * p;
        double raiz = Math.sqrt(multiplicacion);
        double division = resta / raiz;
        double curtosis = 3 + division;

        return curtosis;
    }

    public static double calcularSesgo(double q, double p, double n) {
        double resta = q - p;
        double multiplicacion = n * q * p;
        double raiz = Math.sqrt(multiplicacion);
        double calcularSesgo = resta / raiz;
        return calcularSesgo;
    }

    public static double factorCorreccion(double N, double n) {
        double resta1 = N - n;
        double resta2 = N - 1;
        double resultadoFC = Math.sqrt(resta1 / resta2);
        return resultadoFC;
    }

    public static double calcularBinomial(double pp, double qq, int n, int x) {
        BigInteger facN = calcularFactorial(n);
        System.out.println("facN = " + facN);
        BigInteger facX = calcularFactorial(x);
        System.out.println("facX = " + facX);
        BigInteger facResta = calcularFactorial(n - x);
        System.out.println("facResta = " + facResta);

        // Convertir BigInteger a BigDecimal para evitar pérdida de precisión
        BigDecimal num = new BigDecimal(facN);
        BigDecimal denom = new BigDecimal(facX.multiply(facResta));

        // División con alta precisión
        BigDecimal div = num.divide(denom, 20, BigDecimal.ROUND_HALF_UP);

        // Cálculo de potencias
        double pX = Math.pow(pp, x);
        double qNX = Math.pow(qq, (n - x));

        // Multiplicación del resultado binomial
        double binomial = div.doubleValue() * pX * qNX;

        System.out.println("Resultado = " + binomial);
        return binomial;
    }

    // Factorial usando BigInteger para evitar overflow con números grandes
    public static BigInteger calcularFactorial(int n) {
        BigInteger resultado = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }
        return resultado;
    }

}
