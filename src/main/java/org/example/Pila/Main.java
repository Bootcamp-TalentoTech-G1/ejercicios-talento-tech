package org.example.Pila;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionDocumentos gestionDocumentos = new GestionDocumentos();

        int opcion;
        do {
            System.out.println("1. Agregar Documento");
            System.out.println("2. Eliminar Último Documento");
            System.out.println("3. Mostrar Documentos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el ID del documento: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el título del documento: ");
                    String titulo = scanner.nextLine();
                    gestionDocumentos.agregarDocumento(id, titulo);
                    break;
                case 2:
                    gestionDocumentos.eliminarUltimoDocumento();
                    break;
                case 3:
                    gestionDocumentos.mostrarDocumentos();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 4);

        scanner.close();
    }

}
