package tree;

public class LC617_MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 这一部分保证了肯定会有返回值
        if (t1==null) return t2;
        if (t2==null) return t1;

        // 因为上一部分保证肯定会有返回值，所以可以相加
        TreeNode root = new TreeNode(t1.val+t2.val);
        root.left = mergeTrees(t1.left, t1.right);
        root.right = mergeTrees(t1.right, t2.right);

        return root;
    }
}
