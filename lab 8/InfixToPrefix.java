import java.util.Scanner;
import java.util.Stack;

public class InfixToPrefix {

    // Function to check if a character is an operator
    public boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    // Function to get the precedence of operators
    static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Function to convert infix expression to postfix expression
    public static String infixToPrefix(String infix) {
        StringBuilder pre = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        // Reverse the input string for easier handling
        StringBuilder reversed = new StringBuilder(infix).reverse();

        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                pre.append(c);
            } else if (c == ')') {
                stack.push(c);
            } else if (c == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    pre.append(stack.pop());
                }
                stack.pop(); // Remove '(' from stack
            } else { // Operator
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    pre.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            pre.append(stack.pop());
        }

        // Reverse the postfix expression to get the prefix notation
        return pre.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("Enter a string ");
        Scanner sc = new Scanner(System.in);
        String infix = sc.nextLine();
        System.out.println("Infix: " + infix);
        System.out.println("Prefix: " + infixToPrefix(infix));
    }
}
