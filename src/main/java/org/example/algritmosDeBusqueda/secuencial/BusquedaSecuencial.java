package org.example.algritmosDeBusqueda.secuencial;

public class BusquedaSecuencial {
    public static boolean busquedaSecuencial(String[] nombres, String nombreBuscado) {
        int vueltas = 0;
        for (int i = 0; i < nombres.length; i++) {
            vueltas++;
            if (nombres[i].equals(nombreBuscado)) {
                System.out.println("Vueltas realizadas: " + vueltas);
                return true;
            }
        }
        System.out.println("Vueltas realizadas: " + vueltas);
        return false;
    }
}