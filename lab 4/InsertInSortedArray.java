public class InsertInSortedArray {
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9};
        int numberToInsert = 6;        
        int[] newArray = insertIntoSortedArray(sortedArray, numberToInsert);
        for (int num : newArray) {
            System.out.print(num + " ");
        }
    }
    public static int[] insertIntoSortedArray(int[] arr, int num) {
        int length = arr.length;
        int[] newArray = new int[length + 1];
        
        int i = 0;
        while (i < length && arr[i] < num) {
            newArray[i] = arr[i];
            i++;
        }
        
        newArray[i] = num;
        
        while (i < length) {
            newArray[i + 1] = arr[i];
            i++;
        }
        
        return newArray;
    }
}
