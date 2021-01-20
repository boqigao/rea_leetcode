package tree;

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
