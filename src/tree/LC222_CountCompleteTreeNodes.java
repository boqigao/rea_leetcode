package tree;

/**
 * 这道题两种解法，一种是层次遍历
 * 用队列做
 *
 * 另一种就是取到树的高度用递归
 * 这道题主要就是取到树的高度这个问题，其实他是比较简单的双层递归
 * 每次递归countNode的时候，也要再次递归左右子树的高度。
 *
 * 取到高度以后，即可以计算节点数
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
            // 根节点，左子树的数量，右子树的数量
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    public int leftDepth(TreeNode root){
        int depth = 0;
        while (root!=null){
            root = root.left;
            depth++;
        }
        return depth;
    }

    public int rightDepth(TreeNode root) {
        int depth = 0;
        while (root!=null){
            root = root.right;
            depth++;
        }
        return depth;
    }
}
