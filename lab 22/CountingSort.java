import java.util.Scanner;
import java.util.Arrays;

public class CountingSort {

    public static void countingSort(int[] array) {
        if (array.length == 0) {
            return;
        }
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int range = max - min + 1;
        int[] count = new int[range];
        for (int num : array) {
            count[num - min]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                array[index++] = i + min;
                count[i]--;
            }
        }
    }
    
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the no.of elements:");
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        System.out.println("Original array:");
        printArray(array);
        countingSort(array);
        System.out.println("Sorted array:");
        printArray(array);
    }
}
