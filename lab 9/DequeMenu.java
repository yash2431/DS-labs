import java.util.Scanner;

class Deque {
    private int[] deque;
    private int front, rear, size, capacity;

    
    public Deque(int capacity) {
        this.capacity = capacity;
        this.deque = new int[capacity];
        this.front = -1;
        this.rear = 0;
        this.size = 0;
    }

    
    public boolean isFull() {
        return size == capacity;
    }

    
    public boolean isEmpty() {
        return size == 0;
    }

    
    public void insertFront(int item) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot insert at front.");
            return;
        }

        front = (front - 1 + capacity) % capacity;
        deque[front] = item;
        size++;
        System.out.println("Inserted " + item + " at front.");
    }

    
    public void insertRear(int item) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot insert at rear.");
            return;
        }

        deque[rear] = item;
        rear = (rear + 1) % capacity;
        size++;
        System.out.println("Inserted " + item + " at rear.");
    }

    
    public void deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot delete from front.");
            return;
        }

        int item = deque[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Deleted " + item + " from front.");
    }

    
    public void deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot delete from rear.");
            return;
        }

        rear = (rear - 1 + capacity) % capacity;
        int item = deque[rear];
        size--;
        System.out.println("Deleted " + item + " from rear.");
    }

    
    public void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }

        System.out.print("Deque elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(deque[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}

public class DequeMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the deque: ");
        int size = scanner.nextInt();
        Deque deque = new Deque(size);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at front end");
            System.out.println("2. Insert at rear end");
            System.out.println("3. Delete from front end");
            System.out.println("4. Delete from rear end");
            System.out.println("5. Display all elements");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter item to insert at front: ");
                    int frontItem = scanner.nextInt();
                    deque.insertFront(frontItem);
                    break;
                case 2:
                    System.out.print("Enter item to insert at rear: ");
                    int rearItem = scanner.nextInt();
                    deque.insertRear(rearItem);
                    break;
                case 3:
                    deque.deleteFront();
                    break;
                case 4:
                    deque.deleteRear();
                    break;
                case 5:
                    deque.display();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
