package javaapplication44;

import javax.swing.JOptionPane;

class Node {

    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {

    Node front, rear;
    int maxSize;
    int size;

    public Main(int maxSize) {
        this.front = null;
        this.rear = null;
        this.maxSize = maxSize;
        this.size = 0;
    }

    public void enqueue(String item) {
        if (isFull()) {
            JOptionPane.showMessageDialog(null, "Queue is full. Cannot enqueue item.");
            return;
        }

        Node mymain = new Node(item);
        if (isEmpty()) {
            front = rear = mymain;
        } else {
            rear.next = mymain;
            rear = mymain;
        }
        size++;
    }

    public String dequeue() {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "Queue is empty. Cannot dequeue item.");
            return null;
        }

        String item = front.data;
        front = front.next;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public String peek() {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "Queue is empty. No item to peek.");
            return null;
        }

        return front.data;
    }

    public static void main(String[] args) {
        int maxSize = Integer.parseInt(JOptionPane.showInputDialog("Enter the maximum size of the queue:"));
        Main queue = new Main(maxSize);

        JOptionPane.showMessageDialog(null, "Queue created with maximum size: " + maxSize);

        boolean running = true;
        while (running) {
            String choice = JOptionPane.showInputDialog(
                    "Choose operation:\n1. Enqueue\n2. Dequeue\n3. Peek\n4. Check if empty\n5. Check if full\n6. Exit");

            if (choice.equals("1")) {
                String item = JOptionPane.showInputDialog("Enter the item to enqueue:");
                queue.enqueue(item);
            } else if (choice.equals("2")) {
                String dequeuedItem = queue.dequeue();
                if (dequeuedItem != null) {
                    JOptionPane.showMessageDialog(null, "Dequeued item: " + dequeuedItem);
                }
            } else if (choice.equals("3")) {
                String peekedItem = queue.peek();
                if (peekedItem != null) {
                    JOptionPane.showMessageDialog(null, "Peeked item: " + peekedItem);
                }
            } else if (choice.equals("4")) {
                boolean empty = queue.isEmpty();
                JOptionPane.showMessageDialog(null, "Queue empty: " + empty);
            } else if (choice.equals("5")) {
                boolean full = queue.isFull();
                JOptionPane.showMessageDialog(null, "Queue full: " + full);
            } else if (choice.equals("6")) {
                running = false;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        }
    }
}
