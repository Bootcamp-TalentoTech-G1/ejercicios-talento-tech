package org.example.algritmosDeBusqueda.secuencial;

import static org.example.algritmosDeBusqueda.secuencial.BusquedaSecuencial.busquedaSecuencial;

public class Main {
    public static void main(String[] args) {
        String[] nombres = {"Juan", "María", "Pedro", "Ana", "Luis"};
        String nombreBuscado = "Pedro";
        boolean encontrado = busquedaSecuencial(nombres, nombreBuscado);
        System.out.println("¿El nombre " + nombreBuscado + " está en la lista? " + encontrado);
    }
}
