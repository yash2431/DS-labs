import java.util.HashSet;
// Node class to represent elements of the singly linked list
class Node {
    int data; // Data stored in the node
    Node next; // Reference to the next node in the list
    
    // Constructor to initialize a node with given data
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}


// SinglyLinkedList class to manage operations on singly linked list
class SinglyLinkedList {
    private Node head; // Head of the singly linked list
    
    // Constructor to initialize an empty singly linked list
    SinglyLinkedList() {
        this.head = null;
    }
    
    // Method to insert a new node at the end of the singly linked list
    void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    // Method to remove duplicates from the singly linked list
    void removeDuplicates() {
        if (head == null || head.next == null) {
            return; // No duplicates to remove if list is empty or has only one element
        }
        
        HashSet<Integer> set = new HashSet<>();
        Node current = head;
        Node previous = null;
        
        while (current != null) {
            int currentData = current.data;
            
            // If current node's data is already in the set, skip it (remove duplicate)
            if (set.contains(currentData)) {
                previous.next = current.next; // Skip current node
            } else {
                set.add(currentData); // Add current node's data to set
                previous = current; // Update previous pointer
            }
            
            current = current.next; // Move to next node
        }
    }
    
    // Method to print all elements of the singly linked list
    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
public class Sll {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        
        // Insert elements into the singly linked list
        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(10);
        list.insertEnd(30);
        list.insertEnd(20);
        
        System.out.println("Original list:");
        list.display();
        
        // Remove duplicates
        list.removeDuplicates();
        
        System.out.println("List after removing duplicates:");
        list.display();
    }
}
