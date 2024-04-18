package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int HORAS = 24;
    private static double[][] sismos;
    private static Scanner scanner = new Scanner(System.in);

    private static void pedirDias() {
        System.out.print("Ingrese la cantidad de días para la simulación (2-31): ");
        int dias = scanner.nextInt();
        while (dias < 2 || dias > 31) {
            System.out.println("El número ingresado no es válido. Intente de nuevo.");
            dias = scanner.nextInt();
        }
        sismos = new double[dias][HORAS]; // Inicializa la matriz con la cantidad de días definida por el usuario
    }

    private static void generarDatosSismicos() {
        Random random = new Random();
        for (int dia = 0; dia < sismos.length; dia++) {
            for (int hora = 0; hora < HORAS; hora++) {
                sismos[dia][hora] = 1.0 + (9.5 - 1.0) * random.nextDouble();
            }
        }
    }

    private static void encontrarYMostrarSismoMasIntenso() {
        double maxIntensidad = 0;
        int diaDelMaximo = -1;
        int horaDelMaximo = -1;
        for (int dia = 0; dia < sismos.length; dia++) {
            for (int hora = 0; hora < HORAS; hora++) {
                if (sismos[dia][hora] > maxIntensidad) {
                    maxIntensidad = sismos[dia][hora];
                    diaDelMaximo = dia;
                    horaDelMaximo = hora;
                }
            }
        }
        System.out.printf("El día %d, a las %02d:00, se registró el sismo más intenso, con una magnitud de %.2f en la escala de Richter.\n",
                diaDelMaximo + 1, horaDelMaximo, maxIntensidad);
    }

    private static void contarYMostrarSismosFrecuentes() {
        for (int dia = 0; dia < sismos.length; dia++) {
            int cuenta = 0;
            for (int hora = 0; hora < HORAS; hora++) {
                if (sismos[dia][hora] >= 4.0) {
                    cuenta++;
                }
            }
            System.out.printf("Día %d: se registraron %d sismos con intensidad igual o mayor a 4.0 grados Richter.\n", dia + 1, cuenta);
        }
    }
    private static void mostrarMenu() {
    return;
    }
    public static void main(String[] args) {
        pedirDias();
    }
}

