import java.util.LinkedList;

// HashTable class implementing a dictionary using separate chaining for collision handling
public class HashTable<K, V> {
    // Entry class represents a key-value pair
    class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 16; // Initial size of the hash table
    private LinkedList<Entry<K, V>>[] table; // Array of linked lists for collision handling

    // Constructor to initialize the hash table
    @SuppressWarnings("unchecked") // Suppress unchecked cast warning
    public HashTable() {
        table = (LinkedList<Entry<K, V>>[]) new LinkedList[SIZE]; // Use generics
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>(); // Initialize each linked list
        }
    }

    // Hash function to compute the index for a given key
    private int getHash(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    // Insert or update a key-value pair
    public void put(K key, V value) {
        int hashIndex = getHash(key);
        LinkedList<Entry<K, V>> bucket = table[hashIndex];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                // Key already exists, update the value
                entry.value = value;
                return;
            }
        }

        // Key does not exist, insert a new entry
        bucket.add(new Entry<>(key, value));
    }

    // Retrieve the value for a given key
    public V get(K key) {
        int hashIndex = getHash(key);
        LinkedList<Entry<K, V>> bucket = table[hashIndex];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value; // Return the found value
            }
        }

        // Key not found
        return null;
    }

    // Remove a key-value pair
    public void remove(K key) {
        int hashIndex = getHash(key);
        LinkedList<Entry<K, V>> bucket = table[hashIndex];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry); // Remove the entry
                return;
            }
        }
    }

    // Print all key-value pairs in the hash table
    public void printHashTable() {
        for (int i = 0; i < SIZE; i++) {
            if (!table[i].isEmpty()) {
                System.out.print("Index " + i + ": ");
                for (Entry<K, V> entry : table[i]) {
                    System.out.print("{" + entry.key + ": " + entry.value + "} ");
                }
                System.out.println();
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        HashTable<String, String> phoneBook = new HashTable<>();

        // Adding entries to the phone book
        phoneBook.put("John", "555-1234");
        phoneBook.put("Jane", "555-5678");
        phoneBook.put("Alice", "555-8765");
        phoneBook.put("Bob", "555-4321");

        // Display the entire hash table
        System.out.println("Phone Book Entries:");
        phoneBook.printHashTable();

        // Retrieve a value by key
        System.out.println("\nPhone number for John: " + phoneBook.get("John"));
        System.out.println("Phone number for Alice: " + phoneBook.get("Alice"));

        // Remove an entry from the phone book
        phoneBook.remove("Bob");

        // Display the updated hash table
        System.out.println("\nUpdated Phone Book Entries:");
        phoneBook.printHashTable();
    }
}
