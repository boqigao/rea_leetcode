package tree;

/**
 * 这道题的核心在于他是一个bst
 *             if(root.val > target) {
 *                 root = root.left;
 *             } else {
 *                 root = root.right;
 *             }
 *  可以用这种方法直接找大小，而不需要去dfs
 */
public class LC270_ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        if (root.left == null && root.right == null) {
            return root.val;
        }

        while (root != null) {
            if (Math.abs(target-root.val) < Math.abs(target-res)){
                res = root.val;
            }
            if(root.val > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }
}
