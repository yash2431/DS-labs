import java.util.Scanner;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int item) {
        value = item;
        left = right = null;
    }
}

class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRecursive(root, key);
    }

    public TreeNode insertRecursive(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }
        if (key < root.value) {
            root.left = insertRecursive(root.left, key);
        } else if (key > root.value) {
            root.right = insertRecursive(root.right, key);
        }
        return root;
    }

    void delete(int key) {
        root = deleteRecursive(root, key);
    }

    public TreeNode deleteRecursive(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.value) {
            root.left = deleteRecursive(root.left, key);
        } else if (key > root.value) {
            root.right = deleteRecursive(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.value = findMin(root.right).value;
            root.right = deleteRecursive(root.right, root.value);
        }
        return root;
    }

    public TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    boolean search(int key) {
        return searchRecursive(root, key) != null;
    }

    public TreeNode searchRecursive(TreeNode root, int key) {
        if (root == null || root.value == key) {
            return root;
        }
        if (key < root.value) {
            return searchRecursive(root.left, key);
        }
        return searchRecursive(root.right, key);
    }

    void inorderTraversal() {
        inorderRecursive(root);
        System.out.println();
    }

    public void inorderRecursive(TreeNode root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.value + " ");
            inorderRecursive(root.right);
        }
    }
}

public class BSTMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        while (true) {
            printMenu();
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to insert: ");
                    int insertValue = scanner.nextInt();
                    bst.insert(insertValue);
                    System.out.println("Inserted " + insertValue);
                    break;
                case 2:
                    System.out.print("Enter the value to delete: ");
                    int deleteValue = scanner.nextInt();
                    bst.delete(deleteValue);
                    System.out.println("Deleted " + deleteValue);
                    break;
                case 3:
                    System.out.print("Enter the value to search: ");
                    int searchValue = scanner.nextInt();
                    if (bst.search(searchValue)) {
                        System.out.println("Node " + searchValue + " found");
                    } else {
                        System.out.println("Node " + searchValue + " not found");
                    }
                    break;
                case 4:
                    System.out.println("Inorder Traversal of the BST:");
                    bst.inorderTraversal();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("\nBinary Search Tree Menu");
        System.out.println("1. Insert a node");
        System.out.println("2. Delete a node");
        System.out.println("3. Search a node");
        System.out.println("4. Display Inorder Traversal");
        System.out.println("5. Exit");
    }
}
