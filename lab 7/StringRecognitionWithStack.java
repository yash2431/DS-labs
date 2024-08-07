import java.util.Scanner;
import java.util.Stack;

public class StringRecognitionWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to recognize (aca, bcb, abcba, abbcbba): ");
        String input = scanner.nextLine().trim();
        
        if (isRecognizedPattern(input)) {
            System.out.println("The string \"" + input + "\" matches one of the recognized patterns.");
        } else {
            System.out.println("The string \"" + input + "\" does not match any recognized pattern.");
        }
        
        scanner.close();
    }
    
    public static boolean isRecognizedPattern(String str) {
        Stack<Character> stack = new Stack<>();
        int length = str.length();
        int mid = length / 2;
        
        // Push first half of the string onto the stack
        for (int i = 0; i < mid; i++) {
            stack.push(str.charAt(i));
        }
        
        // Compare second half of the string with the stack
        int index = (length % 2 == 0) ? mid : mid + 1;
        while (index < length) {
            char top = stack.pop();
            if (top != str.charAt(index)) {
                return false;
            }
            index++;
        }
        
        return true;
    }
}
