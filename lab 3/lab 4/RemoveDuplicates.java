import java.util.Arrays;
import java.util.HashSet;
public class RemoveDuplicates {
    public static int[] removeDuplicates(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int[] uniqueArray = new int[set.size()];
        int index = 0;
        for (int num : set) {
            uniqueArray[index++] = num;
        }
        Arrays.sort(uniqueArray);
        return uniqueArray;
    }
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arrayWithDuplicates = {1, 2, 3, 4, 5, 3, 2, 1, 6, 7, 8, 9, 6};
        System.out.println("Original array:");
        printArray(arrayWithDuplicates);
        int[] uniqueArray = removeDuplicates(arrayWithDuplicates);
        System.out.println("Array after removing duplicates:");
        printArray(uniqueArray);
    }
}
