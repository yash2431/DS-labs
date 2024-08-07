import java.util.Scanner;

// Node class for the Linked List
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Function to append a node at the end
    void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Function to print the Linked List
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Function to calculate GCD
    int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to add GCD nodes between every pair of adjacent nodes
    void addGCDNodes() {
        if (head == null || head.next == null) return;

        Node current = head;
        while (current != null && current.next != null) {
            // Calculate the GCD of the current node and the next node
            int gcdValue = gcd(current.data, current.next.data);

            // Create a new node with the GCD value
            Node gcdNode = new Node(gcdValue);

            // Insert the GCD node between current and next
            gcdNode.next = current.next;
            current.next = gcdNode;

            // Move to the next pair of nodes
            current = gcdNode.next;
        }
    }
}

public class GCDLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers for the Linked List (end with -1):");

        // Input for linked list creation
        while (true) {
            int data = scanner.nextInt();
            if (data == -1) break;
            list.append(data);
        }

        System.out.println("Original Linked List:");
        list.printList();

        // Add GCD nodes
        list.addGCDNodes();

        System.out.println("Linked List after adding GCD nodes:");
        list.printList();

        scanner.close();
    }
}
