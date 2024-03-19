package org.example.arboles;

public class ArbolAvl {

    // Clase que representa un nodo en el árbol AVL
    static class NodoAVL {
        int valor, altura;
        NodoAVL izquierdo, derecho;

        public NodoAVL(int valor) {
            this.valor = valor;
            this.altura = 1; // La altura de un nuevo nodo es 1
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    // Clase que representa el árbol AVL
    public static class ArbolAVL {
        NodoAVL raiz;

        public ArbolAVL() {
            this.raiz = null; // Al inicio, el árbol está vacío
        }

        // Método auxiliar para obtener la altura de un nodo
        private int obtenerAltura(NodoAVL nodo) {
            if (nodo == null) {
                return 0; // La altura de un nodo nulo es 0
            }
            return nodo.altura;
        }

        // Método auxiliar para obtener el factor de equilibrio de un nodo
        private int obtenerFactorEquilibrio(NodoAVL nodo) {
            if (nodo == null) {
                return 0; // El factor de equilibrio de un nodo nulo es 0
            }
            return obtenerAltura(nodo.izquierdo) - obtenerAltura(nodo.derecho);
        }

        // Método auxiliar para realizar una rotación derecha en un nodo desequilibrado

        private NodoAVL rotarDerecha(NodoAVL y) {
            //Altura
            NodoAVL x = y.izquierdo;
            NodoAVL temp = x.derecho;

            // Realizar la rotación
            x.derecho = y;
            y.izquierdo = temp;

            // Actualizar alturas
            y.altura = Math.max(obtenerAltura(y.izquierdo), obtenerAltura(y.derecho)) + 1;
            x.altura = Math.max(obtenerAltura(x.izquierdo), obtenerAltura(x.derecho)) + 1;

            // Devolver la nueva raíz
            return x;
        }

        // Método auxiliar para realizar una rotación izquierda en un nodo desequilibrado
        private NodoAVL rotarIzquierda(NodoAVL x) {
            NodoAVL y = x.derecho;
            NodoAVL temp = y.izquierdo;

            // Realizar la rotación
            y.izquierdo = x;
            x.derecho = temp;

            // Actualizar alturas
            x.altura = Math.max(obtenerAltura(x.izquierdo), obtenerAltura(x.derecho)) + 1;
            y.altura = Math.max(obtenerAltura(y.izquierdo), obtenerAltura(y.derecho)) + 1;

            // Devolver la nueva raíz
            return y;
        }

        // Método para insertar un nuevo nodo en el árbol AVL
        public NodoAVL insertar(NodoAVL nodo, int valor) {
            // Paso 1: Inserción normal de un BST
            if (nodo == null) {
                return new NodoAVL(valor);
            }

            if (valor < nodo.valor) {
                nodo.izquierdo = insertar(nodo.izquierdo, valor);
            } else if (valor > nodo.valor) {
                nodo.derecho = insertar(nodo.derecho, valor);
            } else {
                return nodo; // No se permiten valores duplicados en un BST
            }

            // Paso 2: Actualizar la altura del nodo actual
            nodo.altura = 1 + Math.max(obtenerAltura(nodo.izquierdo), obtenerAltura(nodo.derecho));

            // Paso 3: Obtener el factor de equilibrio del nodo y verificar si se ha desequilibrado
            int factorEquilibrio = obtenerFactorEquilibrio(nodo);

            // Caso 1: Desbalanceo a la izquierda-izquierda (rotación derecha)
            if (factorEquilibrio > 1 && valor < nodo.izquierdo.valor) {
                return rotarDerecha(nodo);
            }

            // Caso 2: Desbalanceo a la derecha-derecha (rotación izquierda)
            if (factorEquilibrio < -1 && valor > nodo.derecho.valor) {
                return rotarIzquierda(nodo);
            }

            // Caso 3: Desbalanceo a la izquierda-derecha (rotación izquierda-derecha)
            if (factorEquilibrio > 1 && valor > nodo.izquierdo.valor) {
                nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
                return rotarDerecha(nodo);
            }

            // Caso 4: Desbalanceo a la derecha-izquierda (rotación derecha-izquierda)
            if (factorEquilibrio < -1 && valor < nodo.derecho.valor) {
                nodo.derecho = rotarDerecha(nodo.derecho);
                return rotarIzquierda(nodo);
            }

            return nodo;
        }

        // Método para realizar un recorrido en orden en el árbol AVL
        public void recorridoEnOrden(NodoAVL nodo) {
            if (nodo != null) {
                recorridoEnOrden(nodo.izquierdo);
                System.out.print(nodo.valor + " ");
                recorridoEnOrden(nodo.derecho);
            }
        }

        // Método principal para probar el árbol AVL
        public static void main(String[] args) {
            ArbolAVL arbol = new ArbolAVL();
            arbol.raiz = arbol.insertar(arbol.raiz, 10);
            arbol.raiz = arbol.insertar(arbol.raiz, 20);
            arbol.raiz = arbol.insertar(arbol.raiz, 30);
            arbol.recorridoEnOrden(arbol.raiz);
        }
    }


}
