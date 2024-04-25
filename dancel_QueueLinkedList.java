package javaapplication43;

import javax.swing.JOptionPane;

import javax.swing.*;

class Customer {
    private String name;
    private int numPeople;

    public Customer(String name, int numPeople) {
        this.name = name;
        this.numPeople = numPeople;
    }

    public String getName() {
        return name;
    }

    public int getNumPeople() {
        return numPeople;
    }

    @Override
    public String toString() {
        return "Customer: " + name + " (Party of " + numPeople + ")";
    }
}

class RestaurantQueue {
    private static final int MAX_SIZE = 10;
    private Customer[] queue;
    private int front, rear, count;

    public RestaurantQueue() {
        queue = new Customer[MAX_SIZE];
        front = rear = count = 0;
    }

    public void enqueue() {
        if (isFull()) {
            JOptionPane.showMessageDialog(null, "Queue is full. Please wait for a table to become available.");
            return;
        }

        String name = JOptionPane.showInputDialog(null, "Enter customer name:");
        int numPeople = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of people:"));
        Customer customer = new Customer(name, numPeople);

        queue[rear] = customer;
        rear = (rear + 1) % MAX_SIZE;
        count++;
        JOptionPane.showMessageDialog(null, "Customer " + customer.getName() + " enqueued.");
    }

    public Customer dequeue() {
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "Queue is empty.");
            return null;
        }

        Customer dequeuedCustomer = queue[front];
        front = (front + 1) % MAX_SIZE;
        count--;
        JOptionPane.showMessageDialog(null, "Customer " + dequeuedCustomer.getName() + " dequeued and seated.");
        return dequeuedCustomer;
    }

    public Customer peek() {

        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "Queue is empty.");
            return null;
        }

        return queue[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == MAX_SIZE;
    }
}

public class Main {
    public static void main(String[] args) {
        RestaurantQueue queue = new RestaurantQueue();

        while (true) {
            String input = JOptionPane.showInputDialog(null, "Restaurant Queueing System\n1. Enqueue Customer\n2. Dequeue Customer\n3. Peek at Next Customer\n4. Exit");
            int choice = Integer.parseInt(input);
            switch (choice) {
                case 1:
                    queue.enqueue();
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    Customer nextCustomer = queue.peek();
                    if (nextCustomer != null) {
                        JOptionPane.showMessageDialog(null, "Next customer: " + nextCustomer);
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Try again.");
            }
        }
    }
}
