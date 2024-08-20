package preorder;

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

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Preorder traversal:");
        tree.preorder();
    }
}