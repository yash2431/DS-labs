import java.util.Stack;

public class StackSort {

    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> tmpStack = new Stack<>();

        while (!stack.isEmpty()) {
            int tmp = stack.pop();

            while (!tmpStack.isEmpty() && tmpStack.peek() > tmp) {
                stack.push(tmpStack.pop());
            }

            tmpStack.push(tmp);
        }

        // Now all elements are sorted in tmpStack, transfer them back to original stack
        while (!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(8);
        stack.push(3);
        stack.push(2);

        System.out.println("Stack before sorting: " + stack);

        sortStack(stack);

        System.out.println("Stack after sorting: " + stack);
    }
}
