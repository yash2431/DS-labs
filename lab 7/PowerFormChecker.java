import java.util.Scanner;
import java.util.Stack;

public class PowerFormChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check if it's in the form 'a^ib^i': ");
        String input = scanner.nextLine().trim();
        
        if (isPowerForm(input)) {
            System.out.println("The string \"" + input + "\" is in the form 'a^ib^i'.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT in the form 'a^ib^i'.");
        }
        
        scanner.close();
    }
    
    public static boolean isPowerForm(String str) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : str.toCharArray()) {
            if (c == 'a') {
                stack.push(c);
            } else if (c == 'b') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false; // More 'b's than 'a's
                }
            } else {
                return false; // Invalid character
            }
        }
        
        // After processing all characters, stack should be empty if valid
        return stack.isEmpty();
    }
}
