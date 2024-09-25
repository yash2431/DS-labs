import java.util.*;

public class HashTable {

    static int[] arr;
    static boolean[] occupied;

    public static int hashFunc(int x) {
        return (x % 18) + 2;
    }

    public static void insert(int value) {
        int index = hashFunc(value);
        while (occupied[index]) {
            index = (index + 1) % (18 + 2);
        }
        arr[index] = value;
        occupied[index] = true;
    }

    public static void display() {
        for (int i = 0; i < arr.length; i++) {
            if (occupied[i]) {
                System.out.println("Index " + i + ": " + arr[i]);
            } else {
                System.out.println("Index " + i + ": Empty");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements to insert: ");
        int n = sc.nextInt();
        arr = new int[18 + 2]; 
        occupied = new boolean[18 + 2];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value " + (i + 1) + ": ");
            int value = sc.nextInt();
            insert(value);
        }
        display();
        sc.close();
    }
}
