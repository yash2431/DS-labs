import java.util.HashSet;
import java.util.Random;
import java.util.Arrays;

public class HashingWithLinearProbing {
    // Function to generate the hash key
    public static int hashFunction(int x) {
        return (x % 18) + 2; // H(x) = (x mod 18) + 2
    }

    public static void main(String[] args) {
        int[] hashTable = new int[20]; // Array of size 20
        Arrays.fill(hashTable, -1); // Initialize all values to -1 (indicating empty slots)
        
        HashSet<Integer> generatedNumbers = new HashSet<>(); // To avoid duplicate numbers
        Random random = new Random();
        
        // Generate 15 unique random numbers between 100,000 and 999,999
        while (generatedNumbers.size() < 15) {
            int num = 100000 + random.nextInt(900000); // Generate a random number between 100000 and 999999
            generatedNumbers.add(num); // Add it to the set (duplicates will be automatically handled)
        }

        // Insert values into the hash table using linear probing
        for (int num : generatedNumbers) {
            int index = hashFunction(num); // Compute the hash index
            int originalIndex = index; // Store the original index for debugging

            // Linear probing in case of a collision
            while (hashTable[index] != -1) {
                index = (index + 1) % 20; // Move to the next index (with wrap-around)
            }
            // Insert the number into the found index
            hashTable[index] = num;
        }

        // Display the final values in the array
        System.out.println("Final values in the array:");
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != -1) {
                System.out.println("Index " + i + ": " + hashTable[i]);
            } else {
                System.out.println("Index " + i + ": " + "Empty");
            }
        }
    }
}
