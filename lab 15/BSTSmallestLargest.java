// Node class representing a tree node
class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BSTSmallestLargest {
    
    // Function to insert a node in the BST
    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // Function to find the smallest element in the BST
    public int findSmallest(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("Tree is empty.");
        }
        // The smallest element is the leftmost node
        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.val;
    }

    // Function to find the largest element in the BST
    public int findLargest(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("Tree is empty.");
        }
        // The largest element is the rightmost node
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.val;
    }

    public static void main(String[] args) {
        BSTSmallestLargest bst = new BSTSmallestLargest();

        TreeNode root = null;
        // Insert nodes into the BST
        root = bst.insert(root, 20);
        root = bst.insert(root, 10);
        root = bst.insert(root, 30);
        root = bst.insert(root, 5);
        root = bst.insert(root, 15);
        root = bst.insert(root, 25);
        root = bst.insert(root, 35);

        // Find and display the smallest and largest elements
        System.out.println("Smallest element in the BST: " + bst.findSmallest(root));
        System.out.println("Largest element in the BST: " + bst.findLargest(root));
    }
}
