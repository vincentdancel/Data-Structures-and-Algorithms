package budgetlists;

import javax.swing.JOptionPane;

public class Main {


    public String[] ingredients;
    public int numIngredients;

    public Main () {
        this.ingredients = new String[10];
        this.numIngredients = 0;
    }

    // Adds an ingredient to the beginning of the list
    public void insertFirst(String ingredient) {
        for (int i = numIngredients; i > 0; i--) {
            ingredients[i] = ingredients[i - 1];
        }
        ingredients[0] = ingredient;
        numIngredients++;
    }

    // Adds an ingredient at the specified index
    public void insertAt(int index, String ingredient) {
        if (index < 0 || index > numIngredients) {
            JOptionPane.showMessageDialog(null, "Invalid index.");
            return;
        }
        for (int i = numIngredients; i > index; i--) {
            ingredients[i] = ingredients[i - 1];
        }
        ingredients[index] = ingredient;
        numIngredients++;
    }

    // Adds an ingredient to the end of the list
    public void insertLast(String ingredient) {
        if (numIngredients == ingredients.length) {
            JOptionPane.showMessageDialog(null, "The list is full.");
            return;
        }
        ingredients[numIngredients] = ingredient;
        numIngredients++;
    }

    // Removes the first ingredient from the list
    public void removeFirst() {
        if (numIngredients == 0) {
            JOptionPane.showMessageDialog(null, "The list is empty.");
            return;
        }
        for (int i = 0; i < numIngredients - 1; i++) {
            ingredients[i] = ingredients[i + 1];
        }
        numIngredients--;
    }

    // Removes the ingredient at the specified index
    public void removeAt(int index) {
        if (index < 0 || index >= numIngredients) {
            JOptionPane.showMessageDialog(null, "Invalid index.");
            return;
        }
        for (int i = index; i < numIngredients - 1; i++) {
            ingredients[i] = ingredients[i + 1];
        }
        numIngredients--;
    }

    // Removes the last ingredient from the list
    public void removeLast() {
        if (numIngredients == 0) {
            JOptionPane.showMessageDialog(null, "The list is empty.");
            return;
        }
        numIngredients--;
    }

    // Checks if the list is empty
    public boolean isEmpty() {
        return numIngredients == 0;
    }

    // Checks if the list is full
    public boolean isFull() {
        return numIngredients == ingredients.length;
    }

    // Prints all the ingredients in the list
    public void printIngredients() {
        String message = "";
        for (int i = 0; i < numIngredients; i++) {
            message += ingredients[i] + "\n";
        }
        JOptionPane.showMessageDialog(null,"List of Ingredients: \n" + message);
    }
    public static void main(String[] args) {
        Main BList = new Main ();

        // Add ingredients
        BList.insertFirst("Pasta");
        BList.insertAt(1, "Spaghetti Sauce");
        BList.insertLast("Hotdog");

        // Print ingredients
        BList.printIngredients();
    }
}
    


