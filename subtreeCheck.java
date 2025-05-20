class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class subtreeCheck {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }

        if (isSame(s, t)) {
            return true;
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }

        if (s == null || t == null) {
            return false;
        }

        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    public static void main(String[] args) {
        // binary tree
        TreeNode binaryTree = new TreeNode(3);
        binaryTree.left = new TreeNode(4);
        binaryTree.right = new TreeNode(5);
        binaryTree.left.left = new TreeNode(1);
        binaryTree.left.right = new TreeNode(2);

        //subtree
        TreeNode subtree = new TreeNode(4);
        subtree.left = new TreeNode(1);
        subtree.right = new TreeNode(2);

        subtreeCheck checker = new subtreeCheck();
        boolean isSubtree = checker.isSubtree(binaryTree, subtree);

        if (isSubtree) {
            System.out.println("Second tree is subtree of first tree");
        } else {
            System.out.println("Second tree is not a subtree of first tree");
        }
    }
}
