package tree;

import java.util.ArrayList;
import java.util.List;

public class Sword34_PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmpRes = new ArrayList<>();
        backtrack(root, sum, res, tmpRes);
        return res;

    }

    private void backtrack(TreeNode root,
                           int sum,
                           List<List<Integer>> res,
                           List<Integer> tmpRes){
        if (root == null){
            return;
        }

        if(root.right == null && root.left == null
        && root.val == sum) {
            tmpRes.add(root.val);
            res.add(new ArrayList<>(tmpRes));
            tmpRes.remove(tmpRes.size()-1);
        }

        tmpRes.add(root.val);
        backtrack(root.left, sum - root.val, res, tmpRes);
        backtrack(root.right, sum - root.val, res, tmpRes);
        tmpRes.remove(tmpRes.size()-1);
    }
}
