package tree;

public class LC110_Balanced_binary_tree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return getHeight(root) != -1;
    }
    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 这里注意，左边如果有
        int left = getHeight(node.left);
        int right = getHeight(node.right);

        // 如果左树和右树有一个不是平衡的，那整棵树就是不平衡的
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }

        //在这里增加高度
        //这里的意思是，在左右儿子已知高度差不大于1的情况下
        // 就可以返回上一层计算更高的高度
        // 返回上一层之前，需要加一层高度
        return Math.max(left, right) + 1;
    }
}
