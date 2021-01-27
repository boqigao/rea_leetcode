package tree;

import java.util.ArrayList;
import java.util.List;

public class Sword54_KthLargestNodeOfBST {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();

        inorderTraverse(root, list);
        return list.get(list.size()-k);

        // 中序遍历的结果就是递增数列
    }

    private void inorderTraverse(TreeNode root,
                                          List<Integer> list){

        if (root == null) return;;
        if (root.left!=null) inorderTraverse(root.left, list);
        list.add(root.val);
        if (root.right!=null) inorderTraverse(root.right, list);
    }
}
