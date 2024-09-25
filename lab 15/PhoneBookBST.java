// Class representing a Node in the BST
class PhoneBookNode {
    String name; // Name is the key
    String phoneNumber; // Phone number is the value
    PhoneBookNode left, right;

    public PhoneBookNode(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        left = right = null;
    }
}

public class PhoneBookBST {
    private PhoneBookNode root;

    // Function to add a new entry to the phone book
    public void addEntry(String name, String phoneNumber) {
        root = addRecursive(root, name, phoneNumber);
    }

    // Helper function to add entry recursively in BST
    private PhoneBookNode addRecursive(PhoneBookNode node, String name, String phoneNumber) {
        if (node == null) {
            return new PhoneBookNode(name, phoneNumber);
        }
        if (name.compareTo(node.name) < 0) {
            node.left = addRecursive(node.left, name, phoneNumber);
        } else if (name.compareTo(node.name) > 0) {
            node.right = addRecursive(node.right, name, phoneNumber);
        } else {
            // Update the phone number if the name already exists
            node.phoneNumber = phoneNumber;
        }
        return node;
    }

    // Function to remove an entry from the phone book
    public void removeEntry(String name) {
        root = removeRecursive(root, name);
    }

    // Helper function to remove entry recursively from BST
    private PhoneBookNode removeRecursive(PhoneBookNode node, String name) {
        if (node == null) {
            return null;
        }
        if (name.compareTo(node.name) < 0) {
            node.left = removeRecursive(node.left, name);
        } else if (name.compareTo(node.name) > 0) {
            node.right = removeRecursive(node.right, name);
        } else {
            // Node to be deleted found

            // Case 1: No child
            if (node.left == null && node.right == null) {
                return null;
            }

            // Case 2: One child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Case 3: Two children
            PhoneBookNode smallestNode = findSmallestNode(node.right);
            node.name = smallestNode.name;
            node.phoneNumber = smallestNode.phoneNumber;
            node.right = removeRecursive(node.right, smallestNode.name);
        }
        return node;
    }

    // Helper function to find the smallest node in a subtree (used for deletion)
    private PhoneBookNode findSmallestNode(PhoneBookNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Function to search for a phone number by name
    public String searchPhoneNumber(String name) {
        PhoneBookNode node = searchRecursive(root, name);
        return node == null ? "Not found" : node.phoneNumber;
    }

    // Helper function to search for a name in the BST
    private PhoneBookNode searchRecursive(PhoneBookNode node, String name) {
        if (node == null || name.equals(node.name)) {
            return node;
        }
        if (name.compareTo(node.name) < 0) {
            return searchRecursive(node.left, name);
        }
        return searchRecursive(node.right, name);
    }

    // Function to list all entries in ascending order of names
    public void listEntriesAscending() {
        System.out.println("Phone book entries in ascending order:");
        inorderTraversal(root);
    }

    // Function to list all entries in descending order of names
    public void listEntriesDescending() {
        System.out.println("Phone book entries in descending order:");
        reverseInorderTraversal(root);
    }

    // Inorder traversal (ascending order)
    private void inorderTraversal(PhoneBookNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.println("Name: " + node.name + ", Phone: " + node.phoneNumber);
        inorderTraversal(node.right);
    }

    // Reverse inorder traversal (descending order)
    private void reverseInorderTraversal(PhoneBookNode node) {
        if (node == null) {
            return;
        }
        reverseInorderTraversal(node.right);
        System.out.println("Name: " + node.name + ", Phone: " + node.phoneNumber);
        reverseInorderTraversal(node.left);
    }

    public static void main(String[] args) {
        PhoneBookBST phoneBook = new PhoneBookBST();

        // Adding entries to the phone book
        phoneBook.addEntry("Alice", "123-456-7890");
        phoneBook.addEntry("Bob", "234-567-8901");
        phoneBook.addEntry("Charlie", "345-678-9012");
        phoneBook.addEntry("David", "456-789-0123");
        phoneBook.addEntry("Eve", "567-890-1234");

        // Search for a phone number
        System.out.println("Searching for Bob's number: " + phoneBook.searchPhoneNumber("Bob"));

        // Remove an entry
        phoneBook.removeEntry("Charlie");

        // List entries in ascending order of names
        phoneBook.listEntriesAscending();

        // List entries in descending order of names
        phoneBook.listEntriesDescending();
    }
}
