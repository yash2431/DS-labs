import java.util.Scanner;

class Stack {
    int maxSize;
    int[] stackArray;
    int top;

    // Constructor to initialize the stack
    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1; // Initialize top to -1 indicating empty stack
    }

    // Method to push element onto the stack
    public void push(int value) {
        if (top < maxSize - 1) {
            stackArray[++top] = value;
            System.out.println("Pushed " + value + " onto the stack.");
        } else {
            System.out.println("Stack Overflow! Cannot push more elements.");
        }
    }

    // Method to pop element from the stack
    public void pop() {
        if (top >= 0) {
            int poppedValue = stackArray[top--];
            System.out.println("Popped " + poppedValue + " from the stack.");
        } else {
            System.out.println("Stack Underflow! Cannot pop from an empty stack.");
        }
    }

    // Method to display elements of the stack
    public void display() {
        if (top >= 0) {
            System.out.println("Current stack:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stackArray[i]);
            }
        } else {
            System.out.println("Stack is empty.");
        }
    }

    // Method to peek at the top element of the stack
    public void peek() {
        if (top >= 0) {
            System.out.println("Top element of the stack: " + stackArray[top]);
        } else {
            System.out.println("Stack is empty.");
        }
    }

    // Method to change value at a specific index of the stack
    public void change(int index, int newValue) {
        if (index >= 0 && index <= top) {
            stackArray[index] = newValue;
            System.out.println("Changed value at index " + index + " to " + newValue + ".");
        } else {
            System.out.println("Invalid index! Index out of range.");
        }
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }
}

public class StackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter maximum size of the stack: ");
        int maxSize = scanner.nextInt();
        Stack stack = new Stack(maxSize);

        while (true) {
            System.out.println("\nSTACK OPERATIONS");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Peek (View top element)");
            System.out.println("5. Change (Modify element at index)");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int element = scanner.nextInt();
                    stack.push(element);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    stack.peek();
                    break;
                case 5:
                    System.out.print("Enter index to change (0-based): ");
                    int index = scanner.nextInt();
                    System.out.print("Enter new value: ");
                    int newValue = scanner.nextInt();
                    stack.change(index, newValue);
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}
