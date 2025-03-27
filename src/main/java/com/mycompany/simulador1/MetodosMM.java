/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador1;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author juan
 */
public class MetodosMM {
    
    private static final MathContext MC = new MathContext(50, RoundingMode.HALF_UP);

    public static BigDecimal serviceTime(double tiempoCola, double medServicio) {
        BigDecimal resta = BigDecimal.valueOf(tiempoCola).subtract(BigDecimal.valueOf(tiempoCola), MC);
        return BigDecimal.ONE.divide(resta, MC);
    }

    public static BigDecimal clientsInLine(double medLlegada, double tiempoCola) {
        BigDecimal elevado = BigDecimal.valueOf(medLlegada).pow(2, MC);
        BigDecimal resta = BigDecimal.valueOf(tiempoCola).subtract(BigDecimal.valueOf(medLlegada), MC);
        BigDecimal multiplicacion = BigDecimal.valueOf(tiempoCola).multiply(resta, MC);
        BigDecimal resultado = elevado.divide(multiplicacion, MC);
        return resultado;
    }

    public static BigDecimal clientsInSystem(double medLlegada, double tiempoServicio) {
        BigDecimal resta = BigDecimal.valueOf(tiempoServicio).subtract(BigDecimal.valueOf(medLlegada));
        BigDecimal resultado = BigDecimal.valueOf(medLlegada).divide(resta, MC);
        return resultado;
    }

    public static BigDecimal probOcupado(double medLlegada, double medServicio) {
        return BigDecimal.valueOf(medLlegada).divide(BigDecimal.valueOf(medServicio), MC);
    }

    public static BigDecimal probOcio(double medLlegada, double medServicio) {
        BigDecimal division = BigDecimal.valueOf(medLlegada).divide(BigDecimal.valueOf(medServicio), MC);
        return BigDecimal.ONE.subtract(division);
    }

    public static BigDecimal probN(double medLlegada, double medServicio, int n) {
        BigDecimal division = BigDecimal.valueOf(medLlegada).divide(BigDecimal.valueOf(medServicio), MC);
        BigDecimal resta = BigDecimal.ONE.subtract(division, MC);
        BigDecimal elevado = division.pow(n, MC);
        return resta.multiply(elevado, MC);
    }

    public static BigDecimal clientesCola(double medLlegada, double tiempoCola) {
        BigDecimal resta = BigDecimal.valueOf(tiempoCola).subtract(BigDecimal.valueOf(medLlegada), MC);
        BigDecimal multiplicacion = BigDecimal.valueOf(tiempoCola).multiply(resta, MC);
        BigDecimal resultado = BigDecimal.valueOf(medLlegada).divide(multiplicacion, MC);
        return resultado;
    }
    
}
