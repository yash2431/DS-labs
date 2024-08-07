import java.util.Scanner;

public class LinearSearch {
    
    
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.print("Enter the element to search for: ");
        int target = scanner.nextInt();
        int result = linearSearch(array, target);
        if (result != -1) {
            System.out.println("Element " + target + " found at index " + result + ".");
        } else {
            System.out.println("Element " + target + " not found in the array.");
        }
        scanner.close();
    }
}
