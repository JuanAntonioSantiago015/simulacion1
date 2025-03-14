/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador1;

import static com.mycompany.simulador1.ProbabilidadInterfaz.agregarFila;
import static com.mycompany.simulador1.ProbabilidadInterfaz.calcularBinomial;
import static com.mycompany.simulador1.ProbabilidadInterfaz.curtosis;
import static com.mycompany.simulador1.ProbabilidadInterfaz.dat;
import static com.mycompany.simulador1.ProbabilidadInterfaz.factorCorreccion;
import static com.mycompany.simulador1.ProbabilidadInterfaz.calcularSesgo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author juan
 */
public class ProbabilidadHipergeometrica {

    private static DefaultTableModel modeloTabla;
    private static JTable tabla;
    private static JScrollPane scrollPane;
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    //static DefaultCategoryDataset dat = new DefaultCategoryDataset();

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

        JLabel lblK = new JLabel("k");
        lblK.setBounds(260, 50, 20, 20);
        JTextField txtK = new JTextField();
        txtK.setBounds(300, 50, 50, 20);

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
        frame.add(lblK);
        frame.add(txtK);
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
                double k = 0;
                int textPoblacion = Integer.parseInt(txtPoblacion.getText().trim());
                System.out.println("textPoblacion = " + textPoblacion);
                int textN = Integer.parseInt(txtMuestra.getText().trim());
                System.out.println("textN = " + textN);
                int textX = Integer.parseInt(txtNumExitos.getText().trim());
                System.out.println("textX = " + textX);

                String textoK = txtK.getText().trim();
                int textK = 0; // Inicializamos en 0

                if (!textoK.isEmpty()) {
                    try {
                        textK = Integer.parseInt(textoK);
                        k = textK; // Asigna el valor ingresado
                    } catch (NumberFormatException ee) {
                        System.out.println("El valor de txtK no es un número válido.");
                    }
                }

                String textoQ = txtFracaso.getText().trim();
                String textoP = txtExito.getText().trim();
                double q, p;

                try {
                    q = textoQ.isEmpty() ? Double.NaN : Double.parseDouble(textoQ);
                } catch (NumberFormatException ee) {
                    q = Double.NaN;
                }

                try {
                    p = textoP.isEmpty() ? Double.NaN : Double.parseDouble(textoP);
                } catch (NumberFormatException ee) {
                    p = Double.NaN;
                }

// Verificar si k no se ingresó y asignar k = p * N
                if (textoK.isEmpty()) {
                    if (!Double.isNaN(p)) {
                        k = p * textPoblacion; // Calculamos k
                        System.out.println("k calculado: " + k);
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe ingresar un valor para k o p.");
                        return;
                    }
                }

// Si N es válido, calculamos p y q
                if (textPoblacion > 0) {
                    p = k / textPoblacion;
                    q = 1 - p;
                } else {
                    JOptionPane.showMessageDialog(null, "N debe ser mayor que 0.");
                    return;
                }

// Mostrar valores finales
                System.out.println("p = " + p + ", q = " + q);
                System.out.println("Valor de k: " + k);

                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                modeloTabla.setRowCount(0);
                String seleccionado = (String) comboOpciones.getSelectedItem();
                double twntyPrcnt = textPoblacion * 0.20;
                String texto = txtFracaso.getText().trim();
                BigDecimal vFinal = BigDecimal.ZERO; // Inicializar en 0
                BigDecimal porcentajeAcum = BigDecimal.ZERO; // Inicializar en 0
                BigDecimal hiperAcum = BigDecimal.ZERO; //

                txtSesgo.setText(String.valueOf(calcularSesgo(q, p, textN)));
                txtCurtosis.setText(String.valueOf(curtosis(q, p, textN)));

                double ses = calcularSesgo(q, p, textN);
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
                double curt = curtosis(q, p, textN);
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

                if (textN >= twntyPrcnt) {
                    double multMedia = textN * k;
                    double media = multMedia / textPoblacion;
                    System.out.println("media = " + media);
                    txtMedia.setText(String.valueOf(media));

                    desviacionEstandar(textPoblacion, textN, textX, (int)k);
                    //calcularHiper(textPoblacion, textN, textX, textK);
                    if (seleccionado.equals("x=")) {
                        BigDecimal vHiperParaMostrar = calcularHiper(textPoblacion, textN, textX, (int) k);
                        txtResultado.setText(String.valueOf(vHiperParaMostrar));
                        for (int i = 0; i <= textX; i++) {
                            BigDecimal vHiper = calcularHiper(textPoblacion, textN, i, (int) k);
                            vFinal = vFinal.add(vHiper); // Ahora sí está inicializado correctamente

                            dataset.addValue(vHiper.doubleValue(), "Probabilidad", String.valueOf(i));
                            System.out.println("vFinal = " + vFinal);

                            BigDecimal porcentaje1 = vHiper.multiply(BigDecimal.valueOf(100));
                            porcentajeAcum = porcentajeAcum.add(porcentaje1); // Acumulando el porcentaje
                            hiperAcum = hiperAcum.add(vHiper);
                            dataset.addValue(vHiper, "Probabilidad", String.valueOf(i));
                            agregarFila(i, vHiper, hiperAcum, porcentaje1, porcentajeAcum);
                        }
                        txtDE.setText(String.valueOf(desviacionEstandar(textPoblacion, textN, textX, (int) k)));
                    }
                    if (seleccionado.equals("x<=")) {

                        BigDecimal vHiperParaMostrar = calcularHiper(textPoblacion, textN, textX, (int) k);
                        txtResultado.setText(String.valueOf(vHiperParaMostrar));
                        for (int i = 0; i <= textX; i++) {
                            BigDecimal vHiper = calcularHiper(textPoblacion, textN, i, (int) k);
                            vFinal = vFinal.add(vHiper); // Ahora sí está inicializado correctamente

                            dataset.addValue(vHiper.doubleValue(), "Probabilidad", String.valueOf(i));
                            System.out.println("vFinal = " + vFinal);

                            BigDecimal porcentaje1 = vHiper.multiply(BigDecimal.valueOf(100));
                            porcentajeAcum = porcentajeAcum.add(porcentaje1); // Acumulando el porcentaje
                            hiperAcum = hiperAcum.add(vHiper);
                            dataset.addValue(vHiper, "Probabilidad", String.valueOf(i));
                            agregarFila(i, vHiper, hiperAcum, porcentaje1, porcentajeAcum);
                            
                        }
                        txtDE.setText(String.valueOf(desviacionEstandar(textPoblacion, textN, textX, (int) k)));
                    }

                    if (seleccionado.equals("x>=")) {

                        BigDecimal vHiperParaMostrar = calcularHiper(textPoblacion, textN, textX, (int) k);
                        txtResultado.setText(String.valueOf(vHiperParaMostrar));
                        for (int i = textX; i <= textN; i++) {
                            BigDecimal vHiper = calcularHiper(textPoblacion, textN, i, (int) k);
                            vFinal = vFinal.add(vHiper); // Ahora sí está inicializado correctamente

                            dataset.addValue(vHiper.doubleValue(), "Probabilidad", String.valueOf(i));
                            System.out.println("vFinal = " + vFinal);

                            BigDecimal porcentaje1 = vHiper.multiply(BigDecimal.valueOf(100));
                            porcentajeAcum = porcentajeAcum.add(porcentaje1); // Acumulando el porcentaje
                            hiperAcum = hiperAcum.add(vHiper);
                            dataset.addValue(vHiper, "Probabilidad", String.valueOf(i));
                            agregarFila(i, vHiper, hiperAcum, porcentaje1, porcentajeAcum);
                        }

                        txtDE.setText(String.valueOf(desviacionEstandar(textPoblacion, textN, textX, (int) k)));
                    }

                    // Primer gráfico
                    JFreeChart chart = ChartFactory.createBarChart("Distribución hipergeométrica", "Valor de n", "Valor hipergeométrico", dataset);
                    ChartPanel chartPanel = new ChartPanel(chart);
                    JFrame frame = new JFrame("Gráfica Hipergeométrica");
                    frame.setSize(800, 600);
                    frame.setContentPane(chartPanel);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);

                    // Segundo gráfico
                    /*JFreeChart porcentajes = ChartFactory.createBarChart("Porcentajes", "Valor de n", "Valor de porcentajes", dat);
                    ChartPanel chartPanel2 = new ChartPanel(porcentajes);
                    JFrame frame2 = new JFrame("Gráfica de Porcentajes");
                    frame2.setSize(800, 600);
                    frame2.setContentPane(chartPanel2);
                    frame2.setLocation(frame.getX() + 820, frame.getY()); // Ubicar al lado de la primera ventana
                    frame2.setVisible(true);
                     */
                } else {
                    int opcion = JOptionPane.showConfirmDialog(
                            null,
                            "Es menor al 20%, debe usar una distribución binomial",
                            "Advertencia",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.WARNING_MESSAGE
                    );

                    if (opcion == JOptionPane.OK_OPTION) {
                        ProbabilidadInterfaz pb = new ProbabilidadInterfaz();
                        pb.setVisible(true);  // Llamamos a setVisible en el objeto, no en la clase
                    } else {
                        System.out.println("El usuario cerró la ventana o hizo clic en Cancelar.");
                    }

                }

                /*
                JFreeChart chart = ChartFactory.createBarChart("Distribución binomial", "Valor de n", "Valor binomial", dataset);
                ChartPanel chartPanel = new ChartPanel(chart);
                JFrame frame = new JFrame();
                frame.setSize(800, 600);
                frame.setContentPane(chartPanel);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                 */
            }
        });
    }

    public static void agregarFila(double n, BigDecimal vHiper, BigDecimal vBinomialAcum, BigDecimal porcentaje, BigDecimal porcentajeAcum) {
        modeloTabla.addRow(new Object[]{n, vHiper, vBinomialAcum, porcentaje, porcentajeAcum});
    }

    public static BigDecimal desviacionEstandar(int N, int n, int x, int k) {

        MathContext mc = new MathContext(50, RoundingMode.HALF_UP);
        BigDecimal NDec = new BigDecimal(N);
        BigDecimal nDec = new BigDecimal(n);
        BigDecimal xDec = new BigDecimal(x);
        BigDecimal kDec = new BigDecimal(k);
        BigDecimal division = kDec.divide(NDec, mc);
        System.out.println("division = " + division);
        BigDecimal mult1 = nDec.multiply(division, mc);
        System.out.println("mult1 = " + mult1);
        BigDecimal raiz = sqrt(mult1, mc);
        System.out.println("raiz = " + raiz);
        System.out.println("PRUEBA " + sqrt(new BigDecimal("25.00"), mc));

        BigDecimal resta = BigDecimal.ONE.subtract(division, mc);
        System.out.println("resta = " + resta);

        BigDecimal resultado = raiz.multiply(resta, mc);

        System.out.println("ESTA ES LA DESVIACIÖN " + resultado);

        return resultado;
    }

    public static BigDecimal calcularHiper(int N, int n, int x, int k) {
        int resta1 = N - k;

        int resta2 = N - n;

        int resta3 = n - x;

        int resta4 = N - k;
        int restaAg = resta4 - n;
        int restaBg = restaAg + x;

        int resta5 = k - x;

        var fac1 = calcularFactorial(resta1);

        var fac2 = calcularFactorial(k);

        var fac3 = calcularFactorial(n);

        var fac4 = calcularFactorial(resta2);

        var fac5 = calcularFactorial(resta3);

        var fac6 = calcularFactorial(restaBg);

        var fac7 = calcularFactorial(x);

        var fac8 = calcularFactorial(resta5);

        var fac9 = calcularFactorial(N);

        var numerador = fac1.multiply(fac2).multiply(fac3).multiply(fac4);

        var denominador = fac5.multiply(fac6).multiply(fac7).multiply(fac8).multiply(fac9);

        BigDecimal numeradorDecimal = new BigDecimal(numerador);
        BigDecimal denominadorDecimal = new BigDecimal(denominador);

        try {
            // Realizar la división con BigDecimal
            BigDecimal distribucion = numeradorDecimal.divide(denominadorDecimal, 50, RoundingMode.HALF_UP);
            System.out.println("Este es el valor de la distribución: " + distribucion);
            return distribucion;
        } catch (ArithmeticException e) {
            System.out.println("Error: División por cero o inexacta.");
            return BigDecimal.ZERO;
        }
        //System.out.println("Este es el valor de la distribución: " + distribucion);
        //return distribucion;
        //return fac9;
        //return fac9;
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

    public static double calcularSesgo(double q, double p, int n) {
        double resta = q - p;
        double mult = n * p * q;
        double raiz = Math.sqrt(mult);
        double resultado = resta / raiz;
        System.out.println("resultado del sesgo = " + resultado);
        return resultado;
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

    public static BigDecimal sqrt(BigDecimal value, MathContext mc) {
        BigDecimal x0 = BigDecimal.ZERO;
        BigDecimal x1 = new BigDecimal(Math.sqrt(value.doubleValue()), mc);

        while (!x0.equals(x1)) {
            x0 = x1;
            x1 = value.divide(x0, mc).add(x0).divide(BigDecimal.valueOf(2), mc);
        }
        return x1;
    }

}
