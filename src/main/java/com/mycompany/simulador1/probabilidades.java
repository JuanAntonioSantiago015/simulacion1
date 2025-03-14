/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador1;

import static com.mycompany.simulador1.ProbabilidadHipergeometrica.agregarFila;
import static com.mycompany.simulador1.ProbabilidadHipergeometrica.calcularHiper;
import static com.mycompany.simulador1.ProbabilidadHipergeometrica.calcularSesgo;
import static com.mycompany.simulador1.ProbabilidadHipergeometrica.curtosis;
import static com.mycompany.simulador1.ProbabilidadHipergeometrica.desviacionEstandar;
import static com.mycompany.simulador1.ProbabilidadHipergeometrica.sqrt;
import static com.mycompany.simulador1.ProbabilidadInterfaz.agregarFila;
import static com.mycompany.simulador1.ProbabilidadInterfaz.calcularBinomial;
import static com.mycompany.simulador1.ProbabilidadInterfaz.calcularFactorial;
import static com.mycompany.simulador1.ProbabilidadInterfaz.calcularSesgo;
import static com.mycompany.simulador1.ProbabilidadInterfaz.curtosis;
import static com.mycompany.simulador1.ProbabilidadInterfaz.dat;
import static com.mycompany.simulador1.ProbabilidadInterfaz.factorCorreccion;
import static com.mycompany.simulador1.dPoisson.calcularFactorial;
import static com.mycompany.simulador1.dPoisson.calcularPoisson;
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
public class probabilidades extends JFrame {

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

        JLabel lblK = new JLabel("K");  // Nuevo campo para K
        lblK.setBounds(20, 80, 80, 20);
        JTextField txtK = new JTextField();
        txtK.setBounds(110, 80, 50, 20);

        JLabel lblAlpha = new JLabel("Alpha");
        lblAlpha.setBounds(170, 80, 20, 20);
        JTextField txtAlpha = new JTextField();
        txtAlpha.setBounds(200, 80, 50, 20);

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
        frame.add(lblAlpha);
        frame.add(txtAlpha);
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
        frame.add(lblK);  // Agregamos K
        frame.add(txtK);
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
                System.out.println("ESTE ES EL RESULTADO QUE ME TENDRÍA QUE AGREGAR = " + determinarTipoCurtosis(2));
                int textN = Integer.parseInt(txtMuestra.getText().trim());
                System.out.println("textN = " + textN);
                int textPoblacion = Integer.parseInt(txtPoblacion.getText().trim());
                System.out.println("textPoblacion = " + textPoblacion);
                double paraVeinte = textPoblacion * 0.20;

                double twntyPrcnt = textPoblacion * 0.20;

                System.out.println("twntyPrcnt = " + twntyPrcnt);
                double txtPPoisson = Double.parseDouble(txtExito.getText());

                double valorMedia = Double.parseDouble(txtAlpha.getText());

                var valorXX = Integer.parseInt(txtNumExitos.getText());

                double factorPoisson = textN * txtPPoisson;
                System.out.println("factorPoisson = " + factorPoisson);

                if (textN < valorXX) {
                    JOptionPane.showMessageDialog(null, "X no debe ser mayor a la muestra.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (valorXX != 0 && valorMedia != 0) {
                    JOptionPane.showMessageDialog(null, "Vamos a usar Poisson");
                    txtTipoS.setText("");
                    txtTipoC.setText("");
                    txtCurtosis.setText("");
                    txtSesgo.setText("");
                    txtFactor.setText("");
                    txtMedia.setText("");
                    txtDE.setText("");

                    txtResultado.setText(String.valueOf(calcularPoisson(valorXX, valorMedia)));
                    double sesgoPoisson = 1 / Math.sqrt(valorMedia);
                    txtSesgo.setText(String.valueOf(sesgoPoisson));
                    txtTipoS.setText(determinarTipoSesgo(sesgoPoisson));

                    double curtosisPoisson = 1 / valorMedia;
                    txtCurtosis.setText(String.valueOf(curtosisPoisson));
                    txtTipoC.setText(determinarTipoCurtosis(curtosisPoisson));

                    BigDecimal valorMediaBD = new BigDecimal(valorMedia);
                    MathContext mc = new MathContext(50, RoundingMode.HALF_UP);
                    BigDecimal dePoisson = sqrt(valorMediaBD, mc);
                    txtDE.setText(String.valueOf(dePoisson));

                    txtMedia.setText(String.valueOf(valorMedia));
                }

                if (txtPPoisson <= 0.1 && factorPoisson <= 10) {
                    JOptionPane.showMessageDialog(null, "Vamos a usar Poisson");
                    txtTipoS.setText("");
                    txtTipoC.setText("");
                    txtCurtosis.setText("");
                    txtSesgo.setText("");
                    txtFactor.setText("");
                    txtMedia.setText("");
                    txtDE.setText("");

                    try {
                        //k es X
                        int valorX = Integer.parseInt(txtNumExitos.getText());
                        System.out.println("Número válido: " + valorX); // Solo para depuración
                        double alpha = Double.parseDouble(txtAlpha.getText());
                        if (alpha == 0) {
                            alpha = txtPPoisson * textN;
                        }
                        System.out.println("alpha = " + alpha);

                        System.out.println(calcularPoisson(valorX, alpha));

                        txtResultado.setText(String.valueOf(calcularPoisson(valorX, alpha)));
                        System.out.println("calcularPoisson(k, alpha) = " + calcularPoisson(valorX, alpha));
                        double q = 1 - txtPPoisson;
                        txtSesgo.setText(String.valueOf(calcularSesgo(q, txtPPoisson, textN)));
                        txtCurtosis.setText(String.valueOf(curtosis(q, txtPPoisson, textN)));
                        txtMedia.setText(String.valueOf(alpha));

                        //Cáluclo de desviación estándar
                        BigDecimal alphaDE = new BigDecimal(alpha);
                        MathContext mc = new MathContext(50, RoundingMode.HALF_UP);
                        BigDecimal dePoisson = sqrt(alphaDE, mc);
                        txtDE.setText(String.valueOf(dePoisson));

                        //SESGO
                        // = 1 /SQRT(media)
                        double ses = calcularSesgo(q, txtPPoisson, textN);
                        txtTipoS.setText(determinarTipoSesgo(ses));

                        double curt = curtosis(q, txtPPoisson, textN);
                        txtTipoC.setText(determinarTipoCurtosis(curt));

                        System.out.println("x = " + valorX);

                        for (int i = 0; i <= valorX; i++) {
                            System.out.println("Este es el valor de i = " + i);
                            BigDecimal vHiper = calcularPoisson(i, alpha);
                            System.out.println("vHiper = " + vHiper);
                            dat.addValue(vHiper, "Probabilidad", String.valueOf(i));
                        }

                        // Primer gráfico
                        JFreeChart chart = ChartFactory.createBarChart("Distribución de Poisson", "Valor de n", "Valor de Poisson", dat);
                        ChartPanel chartPanel = new ChartPanel(chart);
                        JFrame frame = new JFrame("Gráfica Poisson");
                        frame.setSize(800, 600);
                        frame.setContentPane(chartPanel);
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);

                    } catch (NumberFormatException ee) {
                        JOptionPane.showMessageDialog(null, "Por favor, ingrese un número entero para K.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }

                if (textN >= twntyPrcnt && textPoblacion != 0) {
                    JOptionPane.showMessageDialog(null, "Vamos a usar la hipergeométrica");
                    double k = 0;

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

                    //p = k/n
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
                        System.out.println("Este es el valor de p = " + p);
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

                    String texto = txtFracaso.getText().trim();
                    BigDecimal vFinal = BigDecimal.ZERO; // Inicializar en 0
                    BigDecimal porcentajeAcum = BigDecimal.ZERO; // Inicializar en 0
                    BigDecimal hiperAcum = BigDecimal.ZERO; //

                    txtSesgo.setText(String.valueOf(calcularSesgo(q, p, textN)));
                    txtCurtosis.setText(String.valueOf(curtosis(q, p, textN)));

                    double ses = calcularSesgo(q, p, textN);
                    txtTipoS.setText(determinarTipoSesgo(ses));

                    double curt = curtosis(q, p, textN);
                    txtTipoC.setText(determinarTipoCurtosis(curt));

                    double multMedia = textN * k;
                    double media = multMedia / textPoblacion;

                    txtMedia.setText(String.valueOf(media));

                    desviacionEstandar(textPoblacion, textN, textX, (int) k);
                    //calcularHiper(textPoblacion, textN, textX, textK);
                    if (seleccionado.equals("x=")) {
                        BigDecimal vHiperParaMostrar = calcularHiper(textPoblacion, textN, textX, (int) k);
                        txtResultado.setText(String.valueOf(vHiperParaMostrar));
                        for (int i = 0; i <= textX; i++) {
                            BigDecimal vHiper = calcularHiper(textPoblacion, textN, i, (int) k);
                            vFinal = vFinal.add(vHiper); // Ahora sí está inicializado correctamente

                            dataset.addValue(vHiper.doubleValue(), "Probabilidad", String.valueOf(i));

                            BigDecimal porcentaje1 = vHiper.multiply(BigDecimal.valueOf(100));
                            porcentajeAcum = porcentajeAcum.add(porcentaje1); // Acumulando el porcentaje
                            hiperAcum = hiperAcum.add(vHiper);
                            dataset.addValue(vHiper, "Probabilidad", String.valueOf(i));
                            agregarFilaH(i, vHiper, hiperAcum, porcentaje1, porcentajeAcum);
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

                            BigDecimal porcentaje1 = vHiper.multiply(BigDecimal.valueOf(100));
                            porcentajeAcum = porcentajeAcum.add(porcentaje1); // Acumulando el porcentaje
                            hiperAcum = hiperAcum.add(vHiper);
                            dataset.addValue(vHiper, "Probabilidad", String.valueOf(i));
                            agregarFilaH(i, vHiper, hiperAcum, porcentaje1, porcentajeAcum);

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

                            BigDecimal porcentaje1 = vHiper.multiply(BigDecimal.valueOf(100));
                            porcentajeAcum = porcentajeAcum.add(porcentaje1); // Acumulando el porcentaje
                            hiperAcum = hiperAcum.add(vHiper);
                            dataset.addValue(vHiper, "Probabilidad", String.valueOf(i));
                            agregarFilaH(i, vHiper, hiperAcum, porcentaje1, porcentajeAcum);
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

                    System.out.println("/////////////");
                    System.out.println("p = " + p);
                    System.out.println("q = " + q);
                    System.out.println("textPoblacion = " + textPoblacion);
                    System.out.println("textN = " + textN);
                    System.out.println("textX = " + textX);
                    System.out.println("k = " + k);

                }
                System.out.println("textN = " + textN);
                if (textN < twntyPrcnt || twntyPrcnt == 0) {
                    JOptionPane.showMessageDialog(null, "Vamos a usar binomial");
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

                    int x = Integer.parseInt(txtNumExitos.getText());
                    double fivePrcnt = N * 0.05;
                    System.out.println("fivePrcnt = " + fivePrcnt);
                    BigDecimal vFinal = BigDecimal.ZERO;
                    BigDecimal porcentajeAcum = BigDecimal.ZERO;
                    BigDecimal probAcum = BigDecimal.ZERO;
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

                            for (int i = 0; i <= x; i++) {
                                // Obtener el valor binomial como BigDecimal
                                BigDecimal vBinomial = calcularBinomial(p, q, n, i);

                                // Acumular valores usando BigDecimal
                                vFinal = vFinal.add(vBinomial);

                                // Agregar al dataset
                                dataset.addValue(vBinomial.doubleValue(), "Probabilidad", String.valueOf(i));

                                // Calcular el porcentaje
                                BigDecimal porcentaje1 = vBinomial.multiply(BigDecimal.valueOf(100));
                                porcentajeAcum = porcentajeAcum.add(porcentaje1);
                                probAcum = probAcum.add(vBinomial);

                                // Llamar a la función para agregar fila con valores en BigDecimal
                                agregarFila(i, vBinomial, probAcum, porcentaje1, porcentajeAcum);

                                // Agregar al gráfico de porcentajes
                                dat.addValue(porcentajeAcum.doubleValue(), "Porcentajes", String.valueOf(i));

                                // Configurar el resaltador de filas
                                tabla.setDefaultRenderer(Object.class, new ResaltadorFilas(porcentajeAceptacion));
                            }

                            BigDecimal vFinal1 = calcularBinomial(p, q, n, x);
                            txtResultado.setText(vFinal1.toPlainString());

                            BigDecimal vFinalX = calcularBinomial(p, q, n, x);
                            BigDecimal porcentajeFinal = vFinalX.multiply(BigDecimal.valueOf(100));

                            agregarFila(n, vFinalX, vFinalX, porcentajeFinal, porcentajeFinal);
                        }

                        if (seleccionado.equals("x<=")) {
                            vFinal = BigDecimal.ZERO; // Reiniciar la variable antes de empezar a sumar
                            porcentajeAcum = BigDecimal.ZERO;
                            probAcum = BigDecimal.ZERO;

                            if (BigDecimal.valueOf(n).compareTo(BigDecimal.valueOf(fivePrcnt)) <= 0 || N == 0) {
                                BigDecimal calc = BigDecimal.valueOf(Math.sqrt(n * p * q));
                                txtDE.setText(calc.toPlainString());
                                txtFactor.setText("");
                            }

                            if (N != 0) {
                                BigDecimal FC = BigDecimal.valueOf(factorCorreccion(N, n));
                                txtFactor.setText(FC.toPlainString());

                                BigDecimal calc = BigDecimal.valueOf(Math.sqrt(n * p * q));
                                BigDecimal respuesta = FC.multiply(calc);
                                txtDE.setText(respuesta.toPlainString());
                            }

                            BigDecimal media = BigDecimal.valueOf(n).multiply(BigDecimal.valueOf(p));
                            txtMedia.setText(media.toPlainString());

                            for (int i = 0; i <= x; i++) {  // Iterar hasta 'x' en lugar de 'n'
                                BigDecimal vBinomial = calcularBinomial(p, q, n, i);
                                vFinal = vFinal.add(vBinomial);

                                dataset.addValue(vBinomial.doubleValue(), "Probabilidad", String.valueOf(i));

                                BigDecimal porcentaje1 = vBinomial.multiply(BigDecimal.valueOf(100));
                                porcentajeAcum = porcentajeAcum.add(porcentaje1);
                                probAcum = probAcum.add(vBinomial);

                                agregarFila(i, vBinomial, probAcum, porcentaje1, porcentajeAcum);
                                dat.addValue(porcentajeAcum.doubleValue(), "Porcentajes", String.valueOf(i));

                                tabla.setDefaultRenderer(Object.class, new ResaltadorFilas(porcentajeAceptacion));
                            }

                            txtResultado.setText(vFinal.toPlainString());
                        }

                        if (seleccionado.equals("x>=")) {
                            vFinal = BigDecimal.ZERO; // Reiniciar la variable antes de empezar a sumar

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
                                BigDecimal vBinomial = calcularBinomial(p, q, n, i);  // Suponiendo que esta función devuelve BigDecimal
                                vFinal = vFinal.add(vBinomial);

                                dataset.addValue(vBinomial.doubleValue(), "Probabilidad", String.valueOf(i));

                                BigDecimal porcentaje1 = vBinomial.multiply(BigDecimal.valueOf(100));
                                porcentajeAcum = porcentajeAcum.add(porcentaje1);
                                probAcum = probAcum.add(vBinomial);

                                agregarFila(i, vBinomial, probAcum, porcentaje1, porcentajeAcum);
                                dat.addValue(porcentajeAcum.doubleValue(), "Porcentajes", String.valueOf(i));

                                tabla.setDefaultRenderer(Object.class, new ResaltadorFilas(porcentajeAceptacion));
                            }

// Mostrar el resultado en `txtResultado`
                            txtResultado.setText(vFinal.toPlainString());

                        }

                        txtSesgo.setText(String.valueOf(calcularSesgo(q, p, n)));
                        double ses = calcularSesgo(q, p, n);
                        txtTipoS.setText(determinarTipoSesgo(ses));

                        txtCurtosis.setText(String.valueOf(curtosis(q, p, n)));
                        double curt = curtosis(q, p, n);
                        txtTipoC.setText(determinarTipoCurtosis(curt));

                        //Gráfico
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
            }
        });

    }

    public static BigDecimal desviacionEstandar(int N, int n, int x, int k) {

        MathContext mc = new MathContext(50, RoundingMode.HALF_UP);
        BigDecimal NDec = new BigDecimal(N);
        BigDecimal nDec = new BigDecimal(n);
        BigDecimal xDec = new BigDecimal(x);
        BigDecimal kDec = new BigDecimal(k);
        BigDecimal division = kDec.divide(NDec, mc);
        BigDecimal mult1 = nDec.multiply(division, mc);
        BigDecimal raiz = sqrt(mult1, mc);

        BigDecimal resta = BigDecimal.ONE.subtract(division, mc);

        BigDecimal resultado = raiz.multiply(resta, mc);

        System.out.println("ESTA ES LA DESVIACIÖN " + resultado);

        return resultado;
    }

    public static void agregarFila(int n, BigDecimal vBinomial, BigDecimal vBinomialAcum, BigDecimal porcentaje, BigDecimal porcentajeAcum) {
        modeloTabla.addRow(new Object[]{
            n,
            vBinomial,
            vBinomialAcum,
            porcentaje,
            porcentajeAcum
        });
    }

    public static void agregarFilaH(double n, BigDecimal vHiper, BigDecimal vBinomialAcum, BigDecimal porcentaje, BigDecimal porcentajeAcum) {
        modeloTabla.addRow(new Object[]{n, vHiper, vBinomialAcum, porcentaje, porcentajeAcum});
    }

    public static String determinarTipoCurtosis(double curtosis) {
        String tipoC = "";
        if (curtosis == 0) {
            tipoC = "Mesocúrtica";
        }
        if (curtosis < 0) {
            tipoC = "Platicúrtica";
        }
        if (curtosis > 0) {
            tipoC = "Leptocúrtica";
        }

        return tipoC;
    }

    public static String determinarTipoSesgo(double sesgo) {
        String tipoS = "";
        if (sesgo == 0) {
            tipoS = "Curva simétrica";
        }
        if (sesgo < 0) {
            tipoS = "Asimétrica hacia la izquierda";
        }
        if (sesgo > 0) {
            tipoS = "Asimétrica hacia la derecha";
        }

        return tipoS;
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

    public static double factorCorreccion(double N, double n) {
        double resta1 = N - n;
        double resta2 = N - 1;
        double resultadoFC = Math.sqrt(resta1 / resta2);
        return resultadoFC;
    }

    public static BigDecimal calcularBinomial(double pp, double qq, int n, int x) {
        BigInteger facN = calcularFactorial(n);
        BigInteger facX = calcularFactorial(x);
        BigInteger facResta = calcularFactorial(n - x);

        // Convertir BigInteger a BigDecimal para evitar pérdida de precisión
        BigDecimal num = new BigDecimal(facN);
        BigDecimal denom = new BigDecimal(facX.multiply(facResta));

        // División con alta precisión
        BigDecimal div = num.divide(denom, 20, RoundingMode.HALF_UP);

        // Convertir probabilidades a BigDecimal y calcular potencias
        BigDecimal pX = new BigDecimal(pp).pow(x, new MathContext(20));
        BigDecimal qNX = new BigDecimal(qq).pow(n - x, new MathContext(20));

        // Multiplicación del resultado binomial
        BigDecimal binomial = div.multiply(pX).multiply(qNX);

        System.out.println("Resultado = " + binomial);
        return binomial;
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
