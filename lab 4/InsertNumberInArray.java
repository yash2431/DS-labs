import java.util.Scanner;
public class InsertNumberInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n + 1];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.print("Enter the number to insert: ");
        int numberToInsert = scanner.nextInt();
        System.out.print("Enter the position to insert the number (0 to " + n + "): ");
        int position = scanner.nextInt();
        if (position < 0 || position > n) {
            System.out.println("Invalid position! Please enter a position between 0 and " + n);
        } else {
            for (int i = n; i > position; i--) {
                array[i] = array[i - 1];
            }
            array[position] = numberToInsert;
            System.out.println("The array after insertion is:");
            for (int i = 0; i <= n; i++) {
                System.out.print(array[i] + " ");
            }
        }
    }
}
