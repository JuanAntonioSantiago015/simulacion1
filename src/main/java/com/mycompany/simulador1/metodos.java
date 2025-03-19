/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador1;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juan
 */
public class metodos {

    public static BigDecimal desviacionEstandar(int N, int n, int k) {
        MathContext mc = new MathContext(50, RoundingMode.HALF_UP);

        // Convertir los valores a BigDecimal
        BigDecimal NDec = new BigDecimal(N);
        BigDecimal nDec = new BigDecimal(n);
        BigDecimal kDec = new BigDecimal(k);

        // Calcular (n * k) / N
        BigDecimal nk = nDec.multiply(kDec, mc);
        BigDecimal division1 = nk.divide(NDec, mc);

        // Calcular 1 - (k / N)
        BigDecimal division2 = kDec.divide(NDec, mc);
        BigDecimal resta = BigDecimal.ONE.subtract(division2, mc);

        // Multiplicar (n * k / N) * (1 - k / N)
        BigDecimal multInterna = division1.multiply(resta, mc);

        // Calcular la primera raíz cuadrada: sqrt((n * k / N) * (1 - k / N))
        BigDecimal raiz1 = sqrt(multInterna, mc);

        // Calcular (N - n) / (N - 1)
        BigDecimal restaNum = NDec.subtract(nDec, mc);
        BigDecimal restaDen = NDec.subtract(BigDecimal.ONE, mc);
        BigDecimal division3 = restaNum.divide(restaDen, mc);

        // Calcular la segunda raíz cuadrada: sqrt((N - n) / (N - 1))
        BigDecimal raiz2 = sqrt(division3, mc);

        // Multiplicar las dos raíces
        BigDecimal resultado = raiz1.multiply(raiz2, mc);

        System.out.println("Desviación estándar: " + resultado);

        return resultado;
    }

    public static void agregarFila(int n, BigDecimal vBinomial, BigDecimal vBinomialAcum, BigDecimal porcentaje, BigDecimal porcentajeAcum, DefaultTableModel tabla) {
        tabla.addRow(new Object[]{
            n,
            vBinomial,
            vBinomialAcum,
            porcentaje,
            porcentajeAcum
        });
    }

    public static void agregarFilaH(double n, BigDecimal vHiper, BigDecimal vBinomialAcum, BigDecimal porcentaje, BigDecimal porcentajeAcum, DefaultTableModel tabla) {
        tabla.addRow(new Object[]{n, vHiper, vBinomialAcum, porcentaje, porcentajeAcum});
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
    
    public static double calcularFivePrcnt(int N){
        double validacion = N * 0.05;
        return validacion;
    }

    public static double calcularVeintePrcnt(int N) {
        double validacion = N * 0.20;
        return validacion;
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
