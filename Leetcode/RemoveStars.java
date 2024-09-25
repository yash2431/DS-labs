import java.util.Stack;

public class RemoveStars {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '*') {
               
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                
                stack.push(c);
            }
        }

        
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

       
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        RemoveStars removeStars = new RemoveStars();
        
        
        String input1 = "leet**cod*e";
        String output1 = removeStars.removeStars(input1);
        System.out.println(output1); 

    
        String input2 = "erase*****";
        String output2 = removeStars.removeStars(input2);
        System.out.println(output2); 
    }
}
