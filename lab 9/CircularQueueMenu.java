import java.util.Scanner;

class CircularQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = this.rear = -1;
        this.size = 0;
    }

    
    public boolean isFull() {
        return size == capacity;
    }

    
    public boolean isEmpty() {
        return size == 0;
    }

    
    public void insert(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot insert.");
            return;
        }

        if (isEmpty()) {
            front = 0;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
        System.out.println("Inserted: " + item);
    }

    
    public void delete() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot delete.");
            return;
        }

        int item = queue[front];
        front = (front + 1) % capacity;
        size--;
        if (isEmpty()) {
            front = rear = -1;
        }
        System.out.println("Deleted: " + item);
    }

    
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}

public class CircularQueueMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the queue: ");
        int size = scanner.nextInt();
        CircularQueue queue = new CircularQueue(size);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display all elements");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter item to insert: ");
                    int item = scanner.nextInt();
                    queue.insert(item);
                    break;
                case 2:
                    queue.delete();
                    break;
                case 3:
                    queue.display();
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
