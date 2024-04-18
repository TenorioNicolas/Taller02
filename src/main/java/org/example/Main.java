package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int DIAS = 7;
    private static final int HORAS = 24;
    private static double[][] sismos = new double[DIAS][HORAS];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double[][] lecturasSismicas = generarDatosSismicos(DIAS);
        encontrarYMostrarSismoMasIntenso(lecturasSismicas);
    }

    private static double[][] generarDatosSismicos(int dias) {
        double[][] lecturasSismicas = new double[dias][24];
        Random random = new Random();
        for (int dia = 0; dia < dias; dia++) {
            for (int hora = 0; hora < 24; hora++) {
                lecturasSismicas[dia][hora] = 1.0 + (9.5 - 1.0) * random.nextDouble();
            }
        }
        return lecturasSismicas;
    }

    private static void encontrarYMostrarSismoMasIntenso(double[][] lecturasSismicas) {
        double maxIntensidad = 0;
        int diaDelMaximo = -1;
        int horaDelMaximo = -1;
        for (int dia = 0; dia < lecturasSismicas.length; dia++) {
            for (int hora = 0; hora < lecturasSismicas[dia].length; hora++) {
                if (lecturasSismicas[dia][hora] > maxIntensidad) {
                    maxIntensidad = lecturasSismicas[dia][hora];
                    diaDelMaximo = dia;
                    horaDelMaximo = hora;
                }
            }
        }
        System.out.printf("El día %d, a las %02d:00, se registró el sismo más intenso, con una magnitud de %.2f en la escala de Richter.\n",
                diaDelMaximo + 1, horaDelMaximo, maxIntensidad);
    }
}
