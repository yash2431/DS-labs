import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class AnagramGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Enter the number of words (N): ");
        int N = sc.nextInt();
        sc.nextLine();

        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            System.out.print("Enter word " + (i + 1) + ": ");
            words[i] = sc.nextLine();
        }
        int randomIndex = random.nextInt(N);
        String originalWord = words[randomIndex];
        System.out.println("Your word to anagram: " + originalWord);
        System.out.print("Enter an anagram of the word: ");
        String userAnagram = sc.nextLine();

        if (isAnagram(originalWord, userAnagram)) {
            System.out.println("Correct! The word is an anagram.");
        } else {
            System.out.println("Incorrect! The word is not an anagram.");
        }

        sc.close();
    }
    public static boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();
        Arrays.sort(word1Array);
        Arrays.sort(word2Array);
        return Arrays.equals(word1Array, word2Array);
    }
}
