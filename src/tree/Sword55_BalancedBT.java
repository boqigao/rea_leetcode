package tree;

import java.util.Map;

public class Sword55_BalancedBT {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int rightHeight = getHeight(root.right);
        int leftHeight = getHeight(root.right);

        if (leftHeight == -1 ||
            rightHeight == -1 ||
                Math.abs(leftHeight-rightHeight)>1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight);
     }
}
