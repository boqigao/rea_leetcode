package tree;

public class LC101_Symmetric_tree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return true;
        }

        // only 1 of the tree is null
        if (t1 == null || t2 ==null) {
            return false;
        }

        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
}

