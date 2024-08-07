import java.util.Scanner;
import java.util.Stack;

public class EvaluatePostfix {

    public static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (Character.isDigit(c)) {
                // Push operand (numeric value) onto stack
                stack.push(c - '0');
            } else {
                // Operator encountered, pop two operands from stack and perform operation
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                
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
        String postfixExpression = sc.nextLine();
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Result of postfix expression \"" + postfixExpression + "\" is: " + result);
    }
}
