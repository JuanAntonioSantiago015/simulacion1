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
        return BigDecimal.valueOf(tiempoCola).add(BigDecimal.valueOf(medServicio), MC);
    }

    public static BigDecimal clientsInLine(double medLlegada, double tiempoCola) {
        return BigDecimal.valueOf(medLlegada).multiply(BigDecimal.valueOf(tiempoCola), MC);
    }

    public static BigDecimal clientsInSystem(double medLlegada, double tiempoServicio) {
        return BigDecimal.valueOf(medLlegada).multiply(BigDecimal.valueOf(tiempoServicio), MC);
    }

    public static BigDecimal probOcupado(double medLlegada, double medServicio) {
        return BigDecimal.valueOf(medLlegada).divide(BigDecimal.valueOf(medServicio), MC);
    }

    public static BigDecimal probOcio(double medLlegada, double medServicio) {
        BigDecimal division = BigDecimal.valueOf(medLlegada).divide(BigDecimal.valueOf(medServicio), MC);
        return BigDecimal.ONE.subtract(division, MC);
    }

    public static BigDecimal probN(double medLlegada, double medServicio, int n) {
        BigDecimal division = BigDecimal.valueOf(medLlegada).divide(BigDecimal.valueOf(medServicio), MC);
        BigDecimal resta = BigDecimal.ONE.subtract(division, MC);
        BigDecimal elevado = division.pow(n, MC);
        return resta.multiply(elevado, MC);
    }

    public static BigDecimal clientesCola(double medLlegada, double tiempoCola) {
        return BigDecimal.valueOf(medLlegada).multiply(BigDecimal.valueOf(tiempoCola), MC);
    }
    
}
