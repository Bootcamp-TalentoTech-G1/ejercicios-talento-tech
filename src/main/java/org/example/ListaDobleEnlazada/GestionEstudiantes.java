package org.example.ListaDobleEnlazada;

public class GestionEstudiantes {

    private Nodo head;
    private Nodo tail;

    public GestionEstudiantes() {
        this.head = null;
        this.tail = null;
    }

    public void agregarEstudiante(String nombre, int edad, double promedio) {
        Estudiante nuevoEstudiante = new Estudiante(nombre, edad, promedio);
        Nodo nuevoNodo = new Nodo(nuevoEstudiante);
        if (head == null) {
            head = nuevoNodo;
            tail = nuevoNodo;

        } else {
            tail.next = nuevoNodo;
            nuevoNodo.prev = tail;
            tail = nuevoNodo;
        }
    }

    public void buscarEstudiante(String nombre) {
        Nodo current = head;
        while (current != null) {
            if (current.estudiante.getNombre().equals(nombre)) {
                System.out.println(current.estudiante);
                return;
            }
            current = current.next;
        }
        System.out.println("Estudiante no encontrado.");
    }
    public void eliminarEstudiante(String nombre) {
        Nodo current = head;
        while (current != null) {
            if (current.estudiante.getNombre().equals(nombre)) {
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                } else if (current == head) {

                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        }
        System.out.println("Estudiante no encontrado.");
    }

    public void mostrarEstudiantes() {
        Nodo current = head;
        while (current != null) {
            System.out.println(current.estudiante);
            current = current.next;
        }
    }
}