import java.util.Scanner;
public class SwapCase {
    public static String swapCase(String str) {
        StringBuilder swapped = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                swapped.append(Character.toUpperCase(c));
            } else if (Character.isUpperCase(c)) {
                swapped.append(Character.toLowerCase(c));
            } else {
                swapped.append(c);
            }
        }
        return swapped.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = sc.nextLine();
        String result = swapCase(input);
        System.out.println("String after swapping case:");
        System.out.println(result);
        sc.close();
    }
}
