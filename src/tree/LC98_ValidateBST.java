package tree;

/**
 * 这道题首先，有一个坑
 * 就是哪怕每个节点的左右儿子都符合左<根<右，那么这个树也可能不是二叉搜索树
 *
 *     10
 *    0  25
 *  -1 21 16 32
 * 上图中，21》16，所以他不是一颗二叉搜索树
 *
 * 这道题正确的想法是，给每一个节点设定他应该在的区间
 * 比如上图中，最初的根是在服务穷到正无穷，
 * 然后左子树就是负无穷到10，右子树就是10到正无穷这种感觉
 */
public class LC98_ValidateBST {
    public boolean isValidBST(TreeNode root) {
        // 这里用long，因为测试例的intergermax会越界，很蠢
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 这里就判定 root的值是否在允许的区间里面
     * @param root
     * @param min
     * @param max
     * @return
     */
    boolean isBST (TreeNode root, long min, long max ) {
        if(root == null) {
            return true;
        }

        if (root.val<=min || root.val >= max) {
            return false;
        }
        return isBST(root.left, min, root.val)
                && isBST(root.right, root.val, max);
    }
}
