
import javax.swing.JOptionPane;

class Queue {

    int maxSize;
    String[] queueArray;
    int front;
    int rear;
    int nItems;

    public Queue(int size) {
        maxSize = size;
        queueArray = new String[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void enqueue(String name) {
        if (nItems < maxSize) {
            if (rear == maxSize - 1) {
                rear = -1;
            }
            rear++;
            queueArray[rear] = name;
            nItems++;
        } else {
            JOptionPane.showMessageDialog(null, "Queue is full.");
        }
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public String dequeue() {
        if (nItems > 0) {
            String temp = queueArray[front];
            front++;
            if (front == maxSize) {
                front = 0;
            }
            nItems--;
            return temp;
        } else {
            JOptionPane.showMessageDialog(null, "Queue is empty.");
            return null;
        }
    }

    public String peek() {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "Queue is empty.");
            return null;
        } else {
            return queueArray[front];
        }
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }
}

public class Main {

    public static void main(String[] args) {
        String maxSizeInput = JOptionPane.showInputDialog("Enter the maximum size of the queue:");
        int maxSize = Integer.parseInt(maxSizeInput);
        Queue queue = new Queue(maxSize);

        while (true) {
            String option = JOptionPane.showInputDialog("Choose an option:\n1."
                    + " Enqueue Customer\n2. "
                    + "Dequeue Customer\n3. "
                    + "Peek Next Customer\n4."
                    + " Exit");

            int choice = Integer.parseInt(option);
            switch (choice) {
                case 1:
                    String name = JOptionPane.showInputDialog("Enter customer name:");
                    queue.enqueue(name);
                    break;
                case 2:
                    String dequeuedName = queue.dequeue();
                    if (dequeuedName != null) {
                        JOptionPane.showMessageDialog(null, "Dequeued: " + dequeuedName);
                    }
                    break;
                case 3:
                    String peekedName = queue.peek();
                    if (peekedName != null) {
                        JOptionPane.showMessageDialog(null, "Peeked: " + peekedName);
                    }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Exiting...");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please choose again.");
            }
        }
    }
