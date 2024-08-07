import java.util.Scanner;
import java.util.Stack;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter No of Test Cases: ");
        int T = scanner.nextInt();
        scanner.nextLine(); // Consume the newline after reading T
        
        for (int t = 0; t < T; t++) {
            String input = scanner.nextLine().trim();
            if (isBalanced(input)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
        
        scanner.close();
    }
    
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
