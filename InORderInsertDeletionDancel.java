package inorderinsertdeletion;

import java.util.Scanner;

public class Main {

    class Node {

        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    Node root;

    Main() {
        root = null;
    }

    Main(int value) {
        root = new Node(value);
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        } else if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    void delete(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        } else if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        Main tree = new Main();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of nodes to insert:");
        int n = scanner.nextInt();
        System.out.println("Enter the values of the nodes:");
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            tree.insert(value);
        }

        System.out.println("Inorder traversal:");
        tree.inorder();

        System.out.println("\nEnter the number of nodes to delete:");
        int m = scanner.nextInt();
        System.out.println("Enter the values of the nodes to delete:");
        for (int i = 0; i < m; i++) {
            int value = scanner.nextInt();
            tree.delete(value);
        }

        System.out.println("Inorder traversal after deletion:");
        tree.inorder();
    }
}