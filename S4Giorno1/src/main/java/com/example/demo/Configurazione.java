package com.example.demo;

public class Configurazione {
    private static double costoCoperto;

    public static double getCostoCoperto() {
        return costoCoperto;
    }

    public static void setCostoCoperto(double costoCoperto) {
        Configurazione.costoCoperto = costoCoperto;
    }
}