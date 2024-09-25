// Node class representing a tree node
class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinaryTreeFromPrePost {
    int preIndex = 0;  // index for preorder traversal
    int postIndex = 0; // index for postorder traversal

    // Function to build the tree from preorder and postorder arrays
    public TreeNode constructTree(int[] preorder, int[] postorder) {
        return build(preorder, postorder, preorder.length);
    }

    // Recursive function to construct the tree
    private TreeNode build(int[] preorder, int[] postorder, int size) {
        // Base case
        if (preIndex >= size || postIndex >= size) {
            return null;
        }

        // Create a root node with the current element of preorder
        TreeNode root = new TreeNode(preorder[preIndex++]);

        // If root's value matches the postorder current index element, return it
        if (root.val == postorder[postIndex]) {
            postIndex++;
            return root;
        }

        // Otherwise, build left and right subtrees recursively
        root.left = build(preorder, postorder, size);
        root.right = build(preorder, postorder, size);

        // Move postIndex for the root node (it will always match eventually)
        postIndex++;
        return root;
    }

    // Utility function to perform an inorder traversal of the tree
    public void inorderTraversal(TreeNode node) {
        if (node == null)
            return;

        inorderTraversal(node.left);
        System.out.print(node.val + " ");
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeFromPrePost treeBuilder = new BinaryTreeFromPrePost();

        // Example preorder and postorder arrays for a full binary tree
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        // Construct the tree
        TreeNode root = treeBuilder.constructTree(preorder, postorder);

        // Display the tree's inorder traversal to verify the structure
        System.out.println("Inorder traversal of the constructed tree:");
        treeBuilder.inorderTraversal(root);
    }
}
