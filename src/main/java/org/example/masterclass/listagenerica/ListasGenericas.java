package org.example.masterclass.listagenerica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListasGenericas {
   /*
  Merge de dos listas:
  Escribe un método genérico en Java que reciba dos listas genéricas y las combine en una nueva lista. La nueva lista debe contener todos los elementos de ambas listas, manteniendo el orden original de cada una.

Eliminar duplicados:
Escribe un método genérico en Java que reciba una lista genérica y elimine los elementos duplicados, dejando solo una ocurrencia de cada elemento en la lista.
    */

    public class EjerciciosListas {

        // Ejercicio 1: Merge de dos listas
        public static <T> List<T> mergeListas(List<T> lista1, List<T> lista2) {
            List<T> resultado = new ArrayList<>();
            resultado.addAll(lista1);
            resultado.addAll(lista2);
            return resultado;
        }

        // Ejercicio 2: Eliminar duplicados
        public static <T> List<T> eliminarDuplicados(List<T> lista) {
            Set<T> conjunto = new HashSet<>(lista);
            return new ArrayList<>(conjunto);
        }

        public static void main(String[] args) {
            // Ejercicio 1: Merge de dos listas
            List<Integer> lista1 = new ArrayList<>();
            lista1.add(1);
            lista1.add(2);
            lista1.add(3);

            List<Integer> lista2 = new ArrayList<>();
            lista2.add(4);
            lista2.add(5);

            List<Integer> resultadoMerge = mergeListas(lista1, lista2);
            System.out.println("Resultado del merge de listas: " + resultadoMerge);

            // Ejercicio 2: Eliminar duplicados
            List<String> listaConDuplicados = new ArrayList<>();
            listaConDuplicados.add("a");
            listaConDuplicados.add("b");
            listaConDuplicados.add("a");
            listaConDuplicados.add("c");
            listaConDuplicados.add("b");

            List<String> listaSinDuplicados = eliminarDuplicados(listaConDuplicados);
            System.out.println("Lista sin duplicados: " + listaSinDuplicados);
        }
    }

}
