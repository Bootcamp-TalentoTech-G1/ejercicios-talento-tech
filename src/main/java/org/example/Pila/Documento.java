package org.example.Pila;

public class Documento {

        private int id;
        private String titulo;

        public Documento(int id, String titulo) {
            this.id = id;
            this.titulo = titulo;
        }

        public int getId() {
            return id;
        }

        public String getTitulo() {
            return titulo;
        }

        @Override
        public String toString() {
            return "Documento{" +
                    "id=" + id +
                    ", titulo='" + titulo + '\'' +
                    '}';
        }
    }


