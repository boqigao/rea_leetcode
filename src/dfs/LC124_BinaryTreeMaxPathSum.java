package dfs;

/**
 * 这道题核心有点类似于LC543：找到二叉树的直径那道题
 *
 * 我们所需要的答案虽然参与到dfs当中去，但是我们并不会把这个答案作为一种参数传递
 * 而是单纯的更新答案
 */
public class LC124_BinaryTreeMaxPathSum {
    int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        if (root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        // 这里res并不真正的参与这个dfs，只是作为一个记录
        res = Math.max(res, root.val+left+right);

        // 这里非常关键！
        // 这里的意思是，“如果”当前节点不作为最终结果的一个根节点的话，我们应该return什么呢？
        // 那肯定是当前节点的值+最大子树的值作为一个分支return回去
        // 但是如果这个返回的值比0都小的话，我们还不如不选择这个分支，所以我们不如返回一个0
        // 记住，这里0代表的意思是：我们不选择这个分支
        return Math.max(root.val + Math.max(left, right),0);

    }

}
