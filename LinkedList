package animallist;

public class AnimalList {

    Node head;

    AnimalList() {
        head = null;
    }

    AnimalList(Node n) {
        head = n;
    }

    static class Node {

        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;

        }
    }

    public static void main(String[] args) {

        Node animal1Node = new Node("Bruno");
        Node animal2Node = new Node("Tom");
        Node animal3Node = new Node("Jerry");

        AnimalList list = new AnimalList(animal1Node);

        System.out.println(list.head.data);
        animal1Node.next = animal2Node;
        System.out.println(list.head.next.data);
        animal2Node.next = animal3Node;
        System.out.println(list.head.next.next.data);

        System.out.println(list.head.data + "->" + list.head.next.data+ "->" + list.head.next.next.data);

    }
}
