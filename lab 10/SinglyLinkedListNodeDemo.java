// Node class represents a node in a singly linked list
class Node {
    int data; // Data stored in the node
    Node next; // Reference to the next node in the list
    
    // Constructor to initialize a node with given data
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedListNodeDemo {

    // Function to print the contents of a node
    static void printNode(Node node) {
        if (node == null) {
            System.out.println("Node is null");
        } else {
            System.out.println("Node data: " + node.data);
        }
    }

    public static void main(String[] args) {
        // Creating a sample node with data 10
        Node node = new Node(10);

        // Printing the contents of the node
        System.out.println("Printing node:");
        printNode(node);
    }
}
