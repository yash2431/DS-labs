public class ArrayDatabase {
    public static int sum(int[] arr) {
        int total = 0;
        for (int num : arr) {
            total += num;
        }
        return total;
    }
    public static int min(int[] arr) {
        int minimum = arr[0];
        for (int num : arr) {
            if (num < minimum) {
                minimum = num;
            }
        }
        return minimum;
    }
    public static int max(int[] arr) {
        int maximum = arr[0];
        for (int num : arr) {
            if (num > maximum) {
                maximum = num;
            }
        }
        return maximum;
    }
    public static double avg(int[] arr) {
        int total = sum(arr);
        return (double) total / arr.length;
    }

    public static void main(String[] args) {
        int[] data = {10, 20, 30, 40, 50};

        System.out.println("Sum: " + sum(data));
        System.out.println("Min: " + min(data));
        System.out.println("Max: " + max(data));
        System.out.println("Avg: " + avg(data));
    }
}
