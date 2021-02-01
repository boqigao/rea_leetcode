package tree;

// 这道题为什么不会出现只找左边或者只找右边的问题呢，因为他在主函数里面递归了！这样每个节点都可以保证跑到自己
// 的左儿子和右儿子
// 这种不用写新函数的，就能自发的保证找到所有的节点，所以不需要回溯
public class LC112_Path_sum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 如果到了最底层的null节点，说明这个节点不存在
        if (root == null) {
            return false;
        }

        // 如果到了叶子节点，同时根节点的值正好等于上层的余下来的数字
        // 那就是存在
        if(targetSum == root.val && root.left == null
        && root.right == null) {
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }
}
