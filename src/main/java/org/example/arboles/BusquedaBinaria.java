package org.example.arboles;

public class BusquedaBinaria {
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    public static class BinarySearchTree {
        Node root;

        public BinarySearchTree() {
            root = null;
        }

        // Método para insertar un nuevo nodo en el árbol
        private Node insertRec(Node root, int key) {
            if (root == null) {
                root = new Node(key);
                return root;
            }

            if (key < root.key)
                root.left = insertRec(root.left, key);
            else if (key > root.key)
                root.right = insertRec(root.right, key);

            return root;
        }

        public void insert(int key) {
            root = insertRec(root, key);
        }

        // Método privado para buscar un nodo con un valor específico en el árbol
        private Node searchRec(Node root, int key) {
            // Si el árbol está vacío o el valor está en la raíz, devuelve el nodo raíz
            if (root == null || root.key == key)
                return root;

            // Si el valor es menor que el valor de la raíz, buscar en el subárbol izquierdo
            if (key < root.key)
                return searchRec(root.left, key);

            // Si el valor es mayor que el valor de la raíz, buscar en el subárbol derecho
            return searchRec(root.right, key);
        }

        // Método público para iniciar la búsqueda desde la raíz
        public Node search(int key) {
            return searchRec(root, key);
        }

        // Método para realizar un recorrido inorden del árbol
        private void inorderRec(Node root) {
            if (root != null) {
                inorderRec(root.left);
                System.out.print(root.key + " ");
                inorderRec(root.right);
            }
        }

        public void inorder() {
            inorderRec(root);
        }

        public static void main(String[] args) {
            BinarySearchTree tree = new BinarySearchTree();

            // Insertar nodos en el árbol
            tree.insert(50);
            tree.insert(30);
            tree.insert(20);
            tree.insert(40);
            tree.insert(70);
            tree.insert(60);
            tree.insert(80);

            // Realizar un recorrido inorden para imprimir los nodos
            System.out.println("Recorrido Inorden:");
            tree.inorder();

            // Buscar un nodo con valor 40
            int keyToSearch = 40;
            Node result = tree.search(keyToSearch);
            if (result != null) {
                System.out.println("\nSe encontró el nodo con valor " + keyToSearch);
            } else {
                System.out.println("\nNo se encontró el nodo con valor " + keyToSearch);
            }
        }
    }

}
