import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {

    public static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n]; 
        int[] count = new int[10];  
        Arrays.fill(count, 0);
        for (int i = 0; i < n; i++) {
            int digit = (array[i] / exp) % 10;
            count[digit]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int digit = (array[i] / exp) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;
        }
        System.arraycopy(output, 0, array, 0, n);
    }

    public static void radixSort(int[] array) {
        int max = getMax(array);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
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
        radixSort(array);
        System.out.println("Sorted array:");
        printArray(array);
    }
}
