import java.util.Arrays;
import java.util.Scanner;

public class ChefAndHammingDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int n = sc.nextInt();
        sc.nextLine();
        int[] arrA = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
        }
        int[] arrB = maximizeHammingDistance(arrA);

        System.out.println("Original array (A): " + Arrays.toString(arrA));
        System.out.println("Maximized Hamming distance array (B): " + Arrays.toString(arrB));

        sc.close();
    }

    public static int[] maximizeHammingDistance(int[] arrA) {
        int n = arrA.length;
        int[] arrB = arrA.clone();
        Arrays.sort(arrB);
        boolean hasDuplicates = false;
        for (int i = 1; i < n; i++) {
            if (arrB[i] == arrB[i - 1]) {
                hasDuplicates = true;
                break;
            }
        }
        if (hasDuplicates) {
            for (int i = 0; i < n; i++) {
                if (arrA[i] == arrB[i]) {
                    for (int j = i + 1; j < n; j++) {
                        if (arrA[j] != arrB[i] && arrA[i] != arrB[j]) {
                            int temp = arrB[i];
                            arrB[i] = arrB[j];
                            arrB[j] = temp;
                            break;
                        }
                    }
                }
            }
        } else {
            int first = arrB[0];
            System.arraycopy(arrB, 1, arrB, 0, n - 1);
            arrB[n - 1] = first;
        }

        return arrB;
    }
}
