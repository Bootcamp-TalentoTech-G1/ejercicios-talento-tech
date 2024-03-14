package org.example.arboles;

public class Arboles {
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    public static class BinaryTree {
        Node root;

        public BinaryTree() {
            root = null;
        }

        // Insertar un nuevo nodo en el árbol
        public void insert(int key) {
            root = insertRec(root, key);
        }

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

        // Búsqueda de un nodo con un valor específico
        public Node search(Node root, int key) {
            if (root == null || root.key == key)
                return root;

            if (root.key < key)
                return search(root.right, key);

            return search(root.left, key);
        }

        // Eliminar un nodo del árbol
        public void delete(int key) {
            root = deleteRec(root, key);
        }

        private Node deleteRec(Node root, int key) {
            if (root == null)
                return root;

            if (key < root.key)
                root.left = deleteRec(root.left, key);
            else if (key > root.key)
                root.right = deleteRec(root.right, key);
            else {
                if (root.left == null)
                    return root.right;
                else if (root.right == null)
                    return root.left;

                root.key = minValue(root.right);
                root.right = deleteRec(root.right, root.key);
            }

            return root;
        }

        private int minValue(Node root) {
            int minValue = root.key;
            while (root.left != null) {
                minValue = root.left.key;
                root = root.left;
            }
            return minValue;
        }

        // Recorridos del árbol
        public void inorder() {
            inorderRec(root);
        }

        public void preorder() {
            preorderRec(root);
        }

        public void postorder() {
            postorderRec(root);
        }

        private void inorderRec(Node root) {
            if (root != null) {
                inorderRec(root.left);
                System.out.print(root.key + " ");
                inorderRec(root.right);
            }
        }

        private void preorderRec(Node root) {
            if (root != null) {
                System.out.print(root.key + " ");
                preorderRec(root.left);
                preorderRec(root.right);
            }
        }

        private void postorderRec(Node root) {
            if (root != null) {
                postorderRec(root.left);
                postorderRec(root.right);
                System.out.print(root.key + " ");
            }
        }

        // Calcular la altura del árbol
        public int height(Node root) {
            if (root == null)
                return 0;
            else {
                int leftHeight = height(root.left);
                int rightHeight = height(root.right);

                if (leftHeight > rightHeight)
                    return (leftHeight + 1);
                else
                    return (rightHeight + 1);
            }
        }

        // Calcular la profundidad de un nodo específico
        public int depth(Node root, int key) {
            return depthRec(root, key, 1);
        }

        private int depthRec(Node root, int key, int level) {
            if (root == null)
                return -1;

            if (root.key == key)
                return level;
// llamado al recorido de profundidad en el árbol
            int downlevel = depthRec(root.left, key, level + 1);
            if (downlevel == -1)
                downlevel = depthRec(root.right, key, level + 1);

            return downlevel;
        }

        public static void main(String[] args) {
            BinaryTree tree = new BinaryTree();

            // Insertar nodos
            tree.insert(50);
            tree.insert(30);
            tree.insert(20);
            tree.insert(40);
            tree.insert(70);
            tree.insert(60);
            tree.insert(80);

            // Recorridos
            System.out.println("Inorden:");
            tree.inorder();
            System.out.println("\nPreorden:");
            tree.preorder();
            System.out.println("\nPostorden:");
            tree.postorder();

            // Búsqueda
            Node foundNode = tree.search(tree.root, 40);
            System.out.println("\nBúsqueda de nodo con valor 40: " + foundNode.key);

            // Eliminación
            tree.delete(20);
            System.out.println("Inorden después de eliminar el nodo con valor 20:");
            tree.inorder();

            // Altura y profundidad
            System.out.println("\nAltura del árbol: " + tree.height(tree.root));
            System.out.println("Profundidad del nodo con valor 40: " + tree.depth(tree.root, 40));
        }
    }
}
