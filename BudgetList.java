package budgetslist;

import javax.swing.JOptionPane;

class Ingredient {
    String name;
    Ingredient next;

    public Ingredient(String name) {
        this.name = name;
        this.next = null;
    }
}

class BudgetList {
    Ingredient head;
    int size;
    final int MAX_SIZE = 10;
    String dishTitle;

    public BudgetList(String dishTitle) {
        head = null;
        size = 0;
        this.dishTitle = dishTitle;
    }

    public void insertFirst(String name) {
        Ingredient newIngredient = new Ingredient(name);
        newIngredient.next = head;
        head = newIngredient;
        size++;
    }

    public void insertLast(String name) {
        Ingredient newIngredient = new Ingredient(name);
        if (head == null) {
            head = newIngredient;
        } else {
            Ingredient current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newIngredient;
        }
        size++;
    }

    public void insertAt(int index, String name) {
        if (index < 0 || index > size) {
            JOptionPane.showMessageDialog(null, "Invalid index!");
            return;
        }
        if (index == 0) {
            insertFirst(name);
        } else if (index == size) {
            insertLast(name);
        } else {
            Ingredient newIngredient = new Ingredient(name);
            Ingredient current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newIngredient.next = current.next;
            current.next = newIngredient;
            size++;
        }
    }

    public void removeFirst() {
        if (head == null) {
            JOptionPane.showMessageDialog(null, "List is empty!");
            return;
        }
        head = head.next;
        size--;
    }

    public void removeLast() {
        if (head == null) {
            JOptionPane.showMessageDialog(null, "List is empty!");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            Ingredient current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            JOptionPane.showMessageDialog(null, "Invalid index!");
            return;
        }
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Ingredient current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public void displayList() {
        if (head == null) {
            JOptionPane.showMessageDialog(null, "List is empty!");
            return;
        }
        Ingredient current = head;
        StringBuilder list = new StringBuilder();
        while (current != null) {
            list.append("- ").append(current.name).append("\n");
            current = current.next;
        }
        JOptionPane.showMessageDialog(null, "Dish/Food: " + dishTitle + "\nList of Ingredients:\n" + list.toString());
    }
}

public class Main {


    public static void main(String[] args) {
        String dishTitle = JOptionPane.showInputDialog("Enter the name of the Dish/Food:");

        BudgetList budgetList = new BudgetList(dishTitle);

        while (true) {
            String choice = JOptionPane.showInputDialog("1. Insert Ingredient\n2. Remove Ingredient\n3. Check if Full\n4. Check if Empty\n5. Display List\n6. Exit\nEnter your choice:");

            int choice2 = Integer.parseInt(choice);
            switch (choice2) {
                case 1:
                    String ingredientName = JOptionPane.showInputDialog("Enter ingredient name:");
                    int position = Integer.parseInt(JOptionPane.showInputDialog("Enter position (1: first, 2: last, 3: at index):"));
                    switch (position) {
                        case 1:
                            budgetList.insertFirst(ingredientName);
                            break;
                        case 2:
                            budgetList.insertLast(ingredientName);
                            break;
                        case 3:
                            int index = Integer.parseInt(JOptionPane.showInputDialog("Enter index:"));
                            budgetList.insertAt(index, ingredientName);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Invalid position!");
                    }
                    break;
                case 2:
                    position = Integer.parseInt(JOptionPane.showInputDialog("Enter position (1: first, 2: last, 3: at index):"));
                    switch (position) {
                        case 1:
                            budgetList.removeFirst();
                            break;
                        case 2:
                            budgetList.removeLast();
                            break;
                        case 3:
                            int index = Integer.parseInt(JOptionPane.showInputDialog("Enter index:"));
                            budgetList.removeAt(index);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Invalid position!");
                    }
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Is Full: " + budgetList.isFull());
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Is Empty: " + budgetList.isEmpty());
                    break;
                case 5:
                    budgetList.displayList();
                    break;
                case 6:
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice!");
            }
        }
    }
    }


    

    


