package tree;

public class LC538_ConvertBSTToGreaterTree {
    int curNum;
    public TreeNode convertBST(TreeNode root) {
        curNum = 0;

        return createGreaterTree(root);

    }

    private TreeNode createGreaterTree (TreeNode root) {
        if(root == null) {
            return null;
        }
        // 先遍历最右边
        root.right = createGreaterTree(root.right);

        curNum += root.val;
        root.val = curNum;

        //最后处理左边
        root.left = createGreaterTree(root.left);

        return root;
    }
}
