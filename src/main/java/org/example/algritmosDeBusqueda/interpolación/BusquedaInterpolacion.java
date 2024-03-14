package org.example.algritmosDeBusqueda.interpolación;

public class BusquedaInterpolacion {
    public static int busquedaInterpolacion(int[] valores, int valorBuscado) {
        int vueltas = 1;
        int inicio = 0;
        int fin = valores.length - 1;

        while (inicio <= fin && valorBuscado >= valores[inicio] && valorBuscado <= valores[fin]) {
            vueltas++;
            int pos = inicio + (((fin - inicio) /
                    (valores[fin] - valores[inicio])) * (valorBuscado - valores[inicio]));

            if (valores[pos] == valorBuscado) {
                System.out.println("Vueltas realizadas: " + vueltas);
                return pos;
            }

            if (valores[pos] < valorBuscado) {
                inicio = pos + 1;
            } else {
                fin = pos - 1;
            }
        }

        System.out.println("Vueltas realizadas: " + vueltas);
        return -1;
    }
}
