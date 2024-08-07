import java.util.Scanner;

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

// LinkedList class represents a singly linked list
class LinkedList {
     Node head; // Head of the linked list
    
    // Constructor to initialize an empty linked list
    LinkedList() {
        this.head = null;
    }
    
    // Function to insert a node at the front of the linked list
    void insertFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Inserted node with data " + data + " at the front.");
    }
    
    // Function to display all nodes in the linked list
    void displayList() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }
        Node current = head;
        System.out.print("Linked list nodes: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    // Function to delete the first node of the linked list
    void deleteFirst() {
        if (head == null) {
            System.out.println("Linked list is empty. Cannot delete.");
            return;
        }
        Node temp = head;
        head = head.next;
        temp.next = null; // Remove reference to the next node
        System.out.println("Deleted first node.");
    }
    
    // Function to insert a node at the end of the linked list
    void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            System.out.println("Inserted node with data " + data + " at the end.");
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        System.out.println("Inserted node with data " + data + " at the end.");
    }
    
    // Function to delete the last node of the linked list
    void deleteLast() {
        if (head == null) {
            System.out.println("Linked list is empty. Cannot delete.");
            return;
        }
        if (head.next == null) {
            head = null;
            System.out.println("Deleted last node.");
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        System.out.println("Deleted last node.");
    }
    
    // Function to delete a node from specified position in the linked list
    void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("Linked list is empty. Cannot delete.");
            return;
        }
        if (position <= 0) {
            System.out.println("Invalid position. Position should be greater than 0.");
            return;
        }
        if (position == 1) {
            deleteFirst();
            return;
        }
        
        Node current = head;
        int count = 1;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        
        if (current == null || current.next == null) {
            System.out.println("Position is out of range. Cannot delete.");
            return;
        }
        
        Node temp = current.next;
        current.next = temp.next;
        temp.next = null;
        System.out.println("Deleted node at position " + position + ".");
    }
}

// Main class to execute the menu-driven program
public class LinkedListOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();
        
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at front");
            System.out.println("2. Display all nodes");
            System.out.println("3. Delete first node");
            System.out.println("4. Insert at end");
            System.out.println("5. Delete last node");
            System.out.println("6. Delete node at position");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert at front: ");
                    int data = scanner.nextInt();
                    list.insertFront(data);
                    break;
                case 2:
                    list.displayList();
                    break;
                case 3:
                    list.deleteFirst();
                    break;
                case 4:
                    System.out.print("Enter data to insert at end: ");
                    int endData = scanner.nextInt();
                    list.insertEnd(endData);
                    break;
                case 5:
                    list.deleteLast();
                    break;
                case 6:
                    System.out.print("Enter position to delete node: ");
                    int position = scanner.nextInt();
                    list.deleteAtPosition(position);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
            
        } while (choice != 7);
        
        scanner.close();
    }
}
