package simplearrayinsert;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        int[] arr= {99, 8, 5, 0, 1, 4, 9, 99};

        JOptionPane.showMessageDialog(null, "HI");

        int elementAtBeginning = Integer.parseInt(JOptionPane.showInputDialog("Put the component you want to insert at the beginning: "));
        arr = insertElement(arr, elementAtBeginning, 0);

        int index = Integer.parseInt(JOptionPane.showInputDialog("Put the component you want to insert at  index:"));
        int elementAtIndex = Integer.parseInt(JOptionPane.showInputDialog("Enter the element to insert at index " + index + ":"));
        arr = insertElement(arr, elementAtIndex, index);

        int elementAtEnd = Integer.parseInt(JOptionPane.showInputDialog("Put the component you want to insert at the end:"));
        arr = insertElement(arr, elementAtEnd, arr.length);

        String output = "ADT FUNCTION IN ARRAY: Insertion: ";
        for (int num : arr) {
            output += num + " ";
        }
        JOptionPane.showMessageDialog(null, output);
    }

    public static int[] insertElement(int[] arr, int element, int index) {

        int[] newArray = new int[arr.length + 1];

        for (int i = 0; i < index; i++) {
            newArray[i] = arr[i];
        }

        newArray[index] = element;
        for (int i = index; i < arr.length; i++) {
            newArray[i + 1] = arr[i];
        }

        return newArray;

    }
}
