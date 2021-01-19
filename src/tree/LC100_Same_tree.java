package tree;

public class LC100_Same_tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null) return true;
        if (p.val != q.val) return false;
        return isSameTree(q.right, p.right)
                && isSameTree(q.left, p.left);
    }
}


