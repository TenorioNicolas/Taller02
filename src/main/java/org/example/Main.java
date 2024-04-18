import java.util.Random;
import java.util.Scanner;

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
        generarDatosSismicos();
        mostrarMenu();
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


    private static void reiniciarArregloConNuevosValores() {
        pedirDias();
    }

    private static void mostrarMenu() {

        int opcion;
        do {
            System.out.println("===== Menú =====");
            System.out.println("[1] Mostrar sismo más intenso");
            System.out.println("[2] Mostrar sismos ≥ 4.0 grados Richter");
            System.out.println("[3] Reiniciar el arreglo con nuevos valores");
            System.out.println("[4] Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    encontrarYMostrarSismoMasIntenso();
                    break;
                case 2:
                    contarYMostrarSismosFrecuentes();
                    break;
                case 3:
                    reiniciarArregloConNuevosValores();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 4);
    }

    public static void main(String[] args) {
        pedirDias();
    }
}
