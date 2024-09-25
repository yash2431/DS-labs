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

   
    boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return (root1.value == root2.value) &&
                isSameTree(root1.left, root2.left) &&
                isSameTree(root1.right, root2.right);
    }


    boolean isSameTree(BinaryTree other) {
        return isSameTree(this.root, other.root);
    }
}

public class SameTreesCheck {
    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree();
        BinaryTree tree2 = new BinaryTree();

        
        tree1.root = new TreeNode(1);
        tree1.root.left = new TreeNode(2);
        tree1.root.right = new TreeNode(3);
        tree1.root.left.left = new TreeNode(4);
        tree1.root.left.right = new TreeNode(5);

        
        tree2.root = new TreeNode(1);
        tree2.root.left = new TreeNode(2);
        tree2.root.right = new TreeNode(3);
        tree2.root.left.left = new TreeNode(4);
        tree2.root.left.right = new TreeNode(5);

        if (tree1.isSameTree(tree2)) {
            System.out.println("Given trees are the same");
        } else {
            System.out.println("Given trees are not the same");
        }
    }
}
