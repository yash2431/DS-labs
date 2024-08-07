// Node class to represent elements of the queue
class Node {
    int data; // Data stored in the node
    Node next; // Reference to the next node in the queue
    
    // Constructor to initialize a node with given data
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
// Queue class implementing queue operations using singly linked list
class Queue {
    private Node front; // Front of the queue
    private Node rear; // Rear of the queue
    
    // Constructor to initialize an empty queue
    Queue() {
        this.front = null;
        this.rear = null;
    }
    
    // Method to check if the queue is empty
    boolean isEmpty() {
        return front == null;
    }
    
    // Method to add an element to the rear of the queue (enqueue)
    void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(data + " enqueued to queue");
    }
    
    // Method to remove the element from the front of the queue (dequeue)
    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // Return a default value or throw an exception
        }
        int dequeued = front.data;
        front = front.next;
        if (front == null) {
            rear = null; // Reset rear if queue becomes empty
        }
        return dequeued;
    }
    
    // Method to peek the element at the front of the queue
    int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // Return a default value or throw an exception
        }
        return front.data;
    }
}
public class QueueSll {
    public static void main(String[] args) {
        Queue queue = new Queue();
        
        // Enqueue elements into the queue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        
        // Display the front element of the queue
        System.out.println("Front element of queue: " + queue.peek());
        
        // Dequeue elements from the queue
        System.out.println(queue.dequeue() + " dequeued from queue");
        System.out.println(queue.dequeue() + " dequeued from queue");
        
        // Display the front element of the queue again
        System.out.println("Front element of queue: " + queue.peek());
    }
}
