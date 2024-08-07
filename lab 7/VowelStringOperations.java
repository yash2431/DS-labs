import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class VowelStringOperations {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine().trim()); // Number of test cases
        
        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim()); // Length of the string (not used directly)
            String S = br.readLine().trim(); // The string itself
            
            // Process the string S
            String result = processString(S);
            
            sb.append(result).append("\n");
        }
        
        // Print all results for each test case
        System.out.println(sb.toString());
    }
    
    public static String processString(String S) {
        StringBuilder result = new StringBuilder();
        int len = S.length();
        
        for (int i = 0; i < len; ) {
            char currentChar = S.charAt(i);
            
            if (isVowel(currentChar)) {
                // Reverse the substring before this vowel
                StringBuilder beforeVowel = new StringBuilder();
                for (int j = i - 1; j >= 0; j--) {
                    beforeVowel.append(S.charAt(j));
                }
                result.append(beforeVowel);
            } else {
                // Append the current character as is
                result.append(currentChar);
                i++;
            }
        }
        
        return result.toString();
    }
    
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
