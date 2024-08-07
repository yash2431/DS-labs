import java.util.Scanner;

class PriorityQueue {
    private int[] queue;
    private int[] priority;
    private int size;
    private int capacity;

    // Constructor to initialize the priority queue
    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.priority = new int[capacity];
        this.size = 0;
    }

    // Check if the priority queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if the priority queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Insert an element with a given priority
    public void insert(int element, int priorityValue) {
        if (isFull()) {
            System.out.println("Priority Queue is full. Cannot insert.");
            return;
        }

        int i;
        for (i = size - 1; i >= 0; i--) {
            if (priorityValue > priority[i]) {
                queue[i + 1] = queue[i];
                priority[i + 1] = priority[i];
            } else {
                break;
            }
        }
        
        queue[i + 1] = element;
        priority[i + 1] = priorityValue;
        size++;
        System.out.println("Inserted element " + element + " with priority " + priorityValue);
    }

    // Delete the element with the highest priority
    public void delete() {
        if (isEmpty()) {
            System.out.println("Priority Queue is empty. Cannot delete.");
            return;
        }

        System.out.println("Deleted element with highest priority: " + queue[0]);
        
        for (int i = 0; i < size - 1; i++) {
            queue[i] = queue[i + 1];
            priority[i] = priority[i + 1];
        }
        
        size--;
    }

    // Display all elements of the priority queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Priority Queue is empty.");
            return;
        }

        System.out.println("Priority Queue elements:");
        for (int i = 0; i < size; i++) {
            System.out.println("Element: " + queue[i] + ", Priority: " + priority[i]);
        }
    }
}

public class PriorityQueueMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the capacity of the priority queue: ");
        int capacity = scanner.nextInt();
        PriorityQueue pq = new PriorityQueue(capacity);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. INSERT");
            System.out.println("2. DELETE");
            System.out.println("3. DISPLAY");
            System.out.println("4. EXIT");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert: ");
                    int element = scanner.nextInt();
                    System.out.print("Enter priority of the element: ");
                    int priorityValue = scanner.nextInt();
                    pq.insert(element, priorityValue);
                    break;
                case 2:
                    pq.delete();
                    break;
                case 3:
                    pq.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
