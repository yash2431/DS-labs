import java.util.Scanner; 
public class ReplaceNumberInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.print("Enter the number to be replaced: ");
        int numToReplace = scanner.nextInt();
        System.out.print("Enter the new number: ");
        int newNum = scanner.nextInt();
        int index = -1; // To store the index of the replaced number
        for (int i = 0; i < n; i++) {
            if (array[i] == numToReplace) {
                array[i] = newNum;
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.out.println("The number " + numToReplace + " was replaced with " + newNum + " at index " + index + ".");
        } else {
            System.out.println("The number " + numToReplace + " was not found in the array.");
        }

        System.out.println("The final array is:");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
