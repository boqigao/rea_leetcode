package tree;

/**
 * 这道题我们先不要考虑morris，先不要考虑那么复杂的解法，我们首先要知道
 * BST的中序遍历结果是一个递增数组！
 * 然后我们经过中序遍历，把违反递增的两个节点找出
 * 然后将其交换（儿子和父亲也都交换）即可
 *
 * 特例：
 * 如果两个相连的话，需要做特殊处理
 */
public class LC99_RecoverBST {
    TreeNode t1, t2, pre;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }
    public void inorder(TreeNode root){
        if (root == null) return ;
        inorder(root.left);
        // 记录一下两个错掉的值
        if (pre != null && pre.val > root.val) {
            if (t1 == null) t1 = pre;
            t2 = root;
        }
        pre = root;
        inorder(root.right);
    }
}
