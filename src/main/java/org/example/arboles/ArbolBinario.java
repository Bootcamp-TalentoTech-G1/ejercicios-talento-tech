package org.example.arboles;

public class ArbolBinario {

    // Clase para representar un nodo en el árbol
    static class Node {
        int key;
        Node left, right;

        //Constructor
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Clase para representar un árbol binario
    public static class BinaryTree {
        Node root; // Nodo raíz del árbol

        public BinaryTree() {
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
            BinaryTree tree = new BinaryTree();

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
        }
    }

}
