import java.util.Scanner;
import java.util.Stack;

public class EvaluatePrefix {

    public static int evaluatePrefix(String prefix) {
        Stack<Integer> stack = new Stack<>();

        // Iterate through the prefix expression in reverse order
        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            if (Character.isDigit(c)) {
                // Convert character to numeric value and push onto stack
                stack.push(c - '0');
            } else if (c == ' ') {
                // Skip whitespace characters
                continue;
            } else {
                // Operator encountered, pop two operands from stack and perform operation
                int operand1 = stack.pop();
                int operand2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        // The final result will be left on the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println("Enter a expression:");
        Scanner sc = new Scanner(System.in);
        String prefixExpression = sc.nextLine();
        int result = evaluatePrefix(prefixExpression);
        System.out.println("Result of prefix expression \"" + prefixExpression + "\" is: " + result);
    }
}
