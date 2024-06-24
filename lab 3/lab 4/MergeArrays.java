import java.util.Arrays;
public class MergeArrays {
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, mergedArray, 0, arr1.length);
        System.arraycopy(arr2, 0, mergedArray, arr1.length, arr2.length);
        Arrays.sort(mergedArray);
        return mergedArray;
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array1 = {3, 1, 7, 9};
        int[] array2 = {8, 2, 6, 4, 5};
        System.out.println("First array:");
        printArray(array1);
        System.out.println("Second array:");
        printArray(array2);
        int[] mergedArray = mergeArrays(array1, array2);
        System.out.println("Merged and sorted array:");
        printArray(mergedArray);
    }
}
