package org.example.Pila;

import java.util.Stack;

public class GestionDocumentos {

    private Stack<Documento> pilaDocumentos;

    public GestionDocumentos() {
        this.pilaDocumentos = new Stack<>();
    }

    public void agregarDocumento(int id, String titulo) {
        Documento documento = new Documento(id, titulo);
        pilaDocumentos.push(documento);
        mostrarDocumentos();
    }

    public void eliminarUltimoDocumento() {
        if (!pilaDocumentos.isEmpty()) {
            Documento documentoEliminado = pilaDocumentos.pop();
            System.out.println("Documento eliminado: " + documentoEliminado);
        } else {
            System.out.println("No hay documentos en la pila.");
        }
        mostrarDocumentos();
    }

    public void mostrarDocumentos() {
        if (!pilaDocumentos.isEmpty()) {
            System.out.println("Documentos en la pila:");
            for (Documento documento : pilaDocumentos) {
                System.out.println(documento);
            }
        } else {
            System.out.println("La pila está vacía.");
        }
        System.out.println();
    }
}
