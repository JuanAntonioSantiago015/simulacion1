/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador1;

import java.math.BigDecimal;

/**
 *
 * @author juan
 */
public class MetodosMM {
    public static BigDecimal serviceTime (double tiempoCola, double medServicio){
        BigDecimal serviceTime = new BigDecimal(tiempoCola).add(new BigDecimal(medServicio));
        return serviceTime;
    }
    
    public static BigDecimal clientsInLine (double medLlegada, double tiempoCola){
        BigDecimal clientsInLine = new BigDecimal(medLlegada).multiply(new BigDecimal(tiempoCola));
        return clientsInLine;
    }
    
    public static BigDecimal clientsInSystem (double medLlegada, double tiempoServicio) {
        BigDecimal clientsInSystem = new BigDecimal(medLlegada).multiply(new BigDecimal(tiempoServicio));
        return clientsInSystem;
    }
    
    public static BigDecimal probOcupado (double medLlegada, double medServicio){
        BigDecimal probOcupado = new BigDecimal(medLlegada).divide(new BigDecimal(medServicio));
        return probOcupado;
    }
    
    public static BigDecimal probOcio (double medLlegada, double medServicio){
        BigDecimal probOcio = BigDecimal.ONE.subtract(new BigDecimal(medLlegada).divide(new BigDecimal(medServicio)));
        return probOcio;
    }
    
}
