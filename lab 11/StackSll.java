// Node class to represent elements of the stack
class Node {
    int data; // Data stored in the node
    Node next; // Reference to the next node in the stack
    
    // Constructor to initialize a node with given data
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
// Stack class implementing stack operations using singly linked list
class Stack {
     Node top; // Top of the stack

    // Constructor to initialize an empty stack
    Stack() {
        this.top = null;
    }
    
    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }
    
    // Method to push a new element onto the stack
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top; // Set the new node's next to current top
        top = newNode; // Update top to point to the new node
        System.out.println(data + " pushed to stack");
    }
    
    // Method to pop the top element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // Return a default value or throw an exception
        }
        int popped = top.data;
        top = top.next; // Move top to the next node
        return popped;
    }
    
    // Method to peek the top element of the stack
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // Return a default value or throw an exception
        }
        return top.data;
    }
}
public class StackSll {
    public static void main(String[] args) {
        Stack stack = new Stack();
        
        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        // Display the top element of the stack
        System.out.println("Top element of stack: " + stack.peek());
        
        // Pop elements from the stack
        System.out.println(stack.pop() + " popped from stack");
        System.out.println(stack.pop() + " popped from stack");
        
        // Display the top element of the stack again
        System.out.println("Top element of stack: " + stack.peek());
    }
}
