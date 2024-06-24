import java.util.Scanner;
public class DeleteNumberFromArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.print("Enter the position to delete the number (0 to " + (n - 1) + "): ");
        int position = scanner.nextInt();
        if (position < 0 || position >= n) {
            System.out.println("Invalid position! Please enter a position between 0 and " + (n - 1));
        } else {
            for (int i = position; i < n - 1; i++) {
                array[i] = array[i + 1];
            }
            System.out.println("The array after deletion is:");
            for (int i = 0; i < n - 1; i++) {
                System.out.print(array[i] + " ");
            }
        }
    }
}
 