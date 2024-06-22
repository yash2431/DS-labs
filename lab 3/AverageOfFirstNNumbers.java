import java.util.Scanner;

public class AverageOfFirstNNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of terms (n): ");
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        double average = (double) sum / n;
        System.out.println("The average of the first " + n + " numbers is: " + average);
        sc.close();
    }
}
