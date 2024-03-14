package org.example.algritmosDeBusqueda.interpolación;

import static org.example.algritmosDeBusqueda.interpolación.BusquedaInterpolacion.busquedaInterpolacion;

public class Main {
    public static void main(String[] args) {
        int[] valores = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20,30,56};
        int valorBuscado = 30;
        int indice = busquedaInterpolacion(valores, valorBuscado);
        System.out.println("El valor " + valorBuscado + " está en el índice: " + indice);
    }
}
