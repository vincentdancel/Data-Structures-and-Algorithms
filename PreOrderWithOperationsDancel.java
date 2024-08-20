package javaapplication48;

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
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    void preorder() {
        preorderRec(root);
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        Main tree = new Main();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements to insert: ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int key = scanner.nextInt();
            tree.insert(key);
        }

        System.out.println("Preorder traversal:");
        tree.preorder();

        System.out.print("\nEnter the number of elements to delete: ");
        int m = scanner.nextInt();

        System.out.println("Enter the elements to delete:");
        for (int i = 0; i < m; i++) {
            int key = scanner.nextInt();
            tree.delete(key);
        }

        System.out.println("Preorder traversal after deletion:");
        tree.preorder();

        scanner.close();
    }
}
