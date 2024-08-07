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
// SinglyLinkedList class represents a singly linked list
class SinglyLinkedList {
    private Node head; // Head of the singly linked list

    // Constructor to initialize an empty singly linked list
    SinglyLinkedList() {
        this.head = null;
    }
    
    // Function to insert a node at the end of the singly linked list
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
    
    // Function to check if two singly linked lists are the same
    boolean isEqual(SinglyLinkedList list2) {
        Node current1 = this.head;
        Node current2 = list2.head;
        
        // Traverse both lists and compare nodes
        while (current1 != null && current2 != null) {
            if (current1.data != current2.data) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        
        // If both lists are of different lengths
        if (current1 != null || current2 != null) {
            return false;
        }
        
        return true;
    }
}
public class TwoNodes {
    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();
        
        // Insert nodes into the first singly linked list
        list1.insertEnd(1);
        list1.insertEnd(2);
        list1.insertEnd(3);
        
        // Insert nodes into the second singly linked list
        list2.insertEnd(1);
        list2.insertEnd(2);
        list2.insertEnd(3);
        
        // Compare both lists
        boolean isEqual = list1.isEqual(list2);
        
        if (isEqual) {
            System.out.println("The two singly linked lists are the same.");
        } else {
            System.out.println("The two singly linked lists are different.");
        }
    }
}
