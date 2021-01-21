package tree;

// 这道题核心是理解了，上层的左右换过了以后，下层就和上层没关系了
// 因此可以用自顶向下的方法，很直观的来做
public class LC226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return root;
        }

        TreeNode tmp = new TreeNode();

        tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
