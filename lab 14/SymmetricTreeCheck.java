class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int item) {
        value = item;
        left = right = null;
    }
}

class BinaryTree {
    TreeNode root;

  
    boolean isSymmetric(TreeNode root) {
        if (root == null) return true; 
        return isMirror(root.left, root.right);
    }

 
    public boolean isMirror(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) return true; // Both are empty
        if (tree1 == null || tree2 == null) return false; // One is empty
        return (tree1.value == tree2.value) &&
                isMirror(tree1.left, tree2.right) &&
                isMirror(tree1.right, tree2.left);
    }
}

public class SymmetricTreeCheck {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

    
        tree.root = new TreeNode(8);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(5);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(6);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(3);

        if (tree.isSymmetric(tree.root)) {
            System.out.println("Given tree is symmetric");
        } else {
            System.out.println("Given tree is not symmetric");
        }

       
        BinaryTree tree2 = new BinaryTree();
        tree2.root = new TreeNode(8);
        tree2.root.left = new TreeNode(5);
        tree2.root.right = new TreeNode(7);
        tree2.root.left.left = new TreeNode(3);
        tree2.root.left.right = new TreeNode(6);
        tree2.root.right.left = new TreeNode(6);
        tree2.root.right.right = new TreeNode(3);

        if (tree2.isSymmetric(tree2.root)) {
            System.out.println("Given tree is symmetric");
        } else {
            System.out.println("Given tree is not symmetric");
        }
    }
}
