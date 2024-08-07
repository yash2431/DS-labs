//63. Write a program to copy a linked list

class Node{
    int info;
    Node link;

    public  Node(int info){
        this.info = info;
        this.link = null;
    }
}


public class CopyLinkedList {

    static void printList(Node first) {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.link;
        }
        System.out.println();
    }

    static Node copyLinkedList(Node first) {
        if (first == null) {
            return null;
        }

        Node originalCurr = first;
        Node copyCurr = null;
        Node copyfirst = null;

        copyCurr = new Node(originalCurr.info);
        copyfirst = copyCurr;
        originalCurr = originalCurr.link;

        while (originalCurr != null) {
            copyCurr.link = new Node(originalCurr.info);
            copyCurr = copyCurr.link;
            originalCurr = originalCurr.link;
        }

        return copyfirst;
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

        Node copiedfirst = copyLinkedList(n1);

        System.out.println("Copied linked list:");
        printList(copiedfirst);
    }
}
