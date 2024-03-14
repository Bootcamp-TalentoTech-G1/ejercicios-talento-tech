package org.example.algritmosDeBusqueda.binaria;

import java.util.Arrays;

public class BusquedaBinaria {

    public static int busquedaBinaria(int[] numeros, int numeroBuscado) {
        int vueltas = 0;
        int indice = Arrays.binarySearch(numeros, numeroBuscado);
        vueltas = indice >= 0 ? indice + 1 : -indice - 1;
        System.out.println("Vueltas realizadas: " + vueltas);
        return indice;
    }

}
