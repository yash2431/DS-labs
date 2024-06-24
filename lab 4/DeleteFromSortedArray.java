public class DeleteFromSortedArray {
    public static int[] deleteNumber(int[] arr, int number) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Number not found in the array.");
            return arr;
        }
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            newArr[j++] = arr[i];
        }

        return newArr;
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int numberToDelete = 5;
        System.out.println("Original array:");
        printArray(sortedArray);
        int[] newArray = deleteNumber(sortedArray, numberToDelete);
        System.out.println("Array after deleting " + numberToDelete + ":");
        printArray(newArray);
    }
}
