//64. Write a program to reverse a linked list.

class Node {
    int info;
    Node link;

    Node(int info) {
        this.info = info;
        this.link = null;
    }
}

public class ReverseLinkedList {

    static void printList(Node first) {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.info+" ");
            temp = temp.link;
        }
        System.out.println();
    }

    static Node reverseLinkedList(Node first) {
        Node prev = null;
        Node current = first;
        Node link = null;

        while (current != null) {
            link = current.link;
            current.link = prev;

            prev = current;
            current = link;
        }
        return prev;
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.link = n2;
        Node n3 = new Node(3);
        n2.link = n3;
        Node n4 = new Node(4);
        n3.link = n4;
        Node n5 = new Node(5);
        n4.link = n5;
        

        System.out.println("Original linked list:");
        printList(n1);

        Node reversedfirst = reverseLinkedList(n1);

        System.out.println("Reversed linked list:");
        printList(reversedfirst);
    }
}
