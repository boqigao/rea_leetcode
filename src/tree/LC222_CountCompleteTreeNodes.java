package tree;

/**
 * 这道题两种解法，一种是层次遍历
 * 用队列做
 *
 * 另一种就是取到树的高度用递归
 */
public class LC222_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);

        //这里总会返回相等的时候，比如深度为0的时候返回0，那就return（1-1）
        // 然后最后上面再+1，就正好是一个节点
        if(leftDepth == rightDepth) {
            return (1<<leftDepth) -1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    public int leftDepth(TreeNode root){
        int depth = 0;
        while (root.left!=null){
            root = root.left;
            depth++;
        }
        return depth;
    }

    public int rightDepth(TreeNode root) {
        int depth = 0;
        while (root.right!=null){
            root = root.right;
            depth++;
        }
        return depth;
    }
}
