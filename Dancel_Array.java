package deckofcards;

import javax.swing.JOptionPane;

class CardDeck {
    public int maxSize;
    public String[] cards;
    public int top; //

    public CardDeck(int maxSize) {
        this.maxSize = maxSize;
        cards = new String[maxSize];
        top = -1;
    }

    public String peek() {
        if (!isEmpty()) {
            return cards[top];
        } else {
            return null;
        }
    }

    public void push(String card) {
        if (!isFull()) {
            top++;
            cards[top] = card;
        } else {
            JOptionPane.showMessageDialog(null, "Deck is full!");
        }
    }

    public String pop() {
        if (!isEmpty()) {
            String topCard = cards[top];
            cards[top] = null; // Clearing the reference
            top--;
            return topCard;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public String displayDeck() {
        String deckString = "";
        for (int i = top; i >= 0; i--) {
            deckString += cards[i] + "\n";
        }
        return deckString;
    }
}

public class Main {
    public static void main(String[] args) {

        CardDeck deck = new CardDeck(52);
        
        deck.push("Four of Spades");
        deck.push("Ace of Spade");

        JOptionPane.showMessageDialog(null, "Peek: " + deck.peek());
        JOptionPane.showMessageDialog(null, "Pop: " + deck.pop());
        JOptionPane.showMessageDialog(null, "Is Empty: " + deck.isEmpty());
        JOptionPane.showMessageDialog(null, "Is Full: " + deck.isFull());
        JOptionPane.showMessageDialog(null, "Display Deck:\n" + deck.displayDeck());
    }
}
    


