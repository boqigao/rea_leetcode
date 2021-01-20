package tree;

import java.util.ArrayList;
import java.util.List;

// 这道题非常难，有空需要再深入理解
public class LC95_UniqueBinarySearchTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return helper(1, n);
    }

    private List<TreeNode> helper(int lo, int hi) {
        List<TreeNode> result = new ArrayList<>();
        // base case
        if(lo > hi) {
            result.add(null);
            return result;
        }

        for (int i = lo; i <= hi; i++){
            List<TreeNode> left = helper(lo, i-1);
            List<TreeNode> right = helper(i+1, hi);

            // 把左右接在根上
            for(TreeNode l : left){
                for(TreeNode r: right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }
        return result;

    }
}
