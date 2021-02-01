package tree;

/**
 * 其实这道题蕴含了一个很深刻的问题，记得有个题是要求双重递归的
 * 只有在循环主函数里面才能做到双重递归，否则容易一条路走到偏
 */
public class LC100_Same_tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null) return true;
        if (p.val != q.val) return false;
        return isSameTree(q.right, p.right)
                && isSameTree(q.left, p.left);
    }
}


