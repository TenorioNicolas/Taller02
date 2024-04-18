package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private double[][] sismos;

    @BeforeEach
    public void setUp() {
        sismos = new double[3][24];
    }

    @Test
    public void testPedirDias_Fallo() {
        assertDoesNotThrow(() -> Main.pedirDias());
    }

    @Test
    public void testGenerarDatosSismicos_Fallo() {
        Main.generarDatosSismicos();
        assertNull(sismos[0][0]);
    }

    @Test
    public void testEncontrarYMostrarSismoMasIntenso_Fallo() {
        assertDoesNotThrow(() -> Main.encontrarYMostrarSismoMasIntenso());
    }

    @Test
    public void testContarYMostrarSismosFrecuentes_Fallo() {
        assertDoesNotThrow(() -> Main.encontrarYMostrarSismoMasIntenso());
    }

    @Test
    public void testReiniciarArregloConNuevosValores_Fallo() {
        Main.reiniciarArregloConNuevosValores();
        assertNull(sismos[0][0]);
    }
}
