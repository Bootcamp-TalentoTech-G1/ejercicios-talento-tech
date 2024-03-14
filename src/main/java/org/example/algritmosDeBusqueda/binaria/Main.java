package org.example.algritmosDeBusqueda.binaria;

import static org.example.algritmosDeBusqueda.binaria.BusquedaBinaria.busquedaBinaria;

public class Main {
    public static void main(String[] args) {
        int[] numeros = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int numeroBuscado = 23;
        int indice = busquedaBinaria(numeros, numeroBuscado);
        System.out.println("El número " + numeroBuscado + " está en el índice: " + indice);
    }
}
