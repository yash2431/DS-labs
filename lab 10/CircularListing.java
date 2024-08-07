// Node class represents a node in a singly circular linked list
class Node {
    int data; // Data stored in the node
    Node next; // Reference to the next node in the list
    
    // Constructor to initialize a node with given data
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
// CircularLinkedList class represents a singly circular linked list
class CircularLinkedList {
    private Node head; // Head of the circular linked list

    // Constructor to initialize an empty circular linked list
    CircularLinkedList() {
        this.head = null;
    }
    
    // Function to insert a node at the end of the circular linked list
    void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head; // Circular link
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head; // Circular link
        }
    }
    
    // Function to count the number of nodes in the circular linked list
    int countNodes() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        Node current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }
}
public class CircularListing {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        
        // Insert nodes into the circular linked list
        list.insertEnd(1);
        list.insertEnd(2);
        list.insertEnd(3);
        list.insertEnd(4);
        list.insertEnd(5);
        
        // Count and print the number of nodes
        int nodeCount = list.countNodes();
        System.out.println("Number of nodes in the circular linked list: " + nodeCount);
    }
}
