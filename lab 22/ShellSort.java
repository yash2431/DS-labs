import java.util.Scanner;
public class ShellSort {

    
    public static void shellSort(int[] array) {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
          
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
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
        shellSort(array);
        System.out.println("Sorted array:");
        printArray(array);
    }
}
