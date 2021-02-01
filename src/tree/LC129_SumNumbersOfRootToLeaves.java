package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 从上到下的遍历，基本使用回溯
 */
public class LC129_SumNumbersOfRootToLeaves {
    public int sumNumbers(TreeNode root) {
        if(root==null) {
            return 0;
        }

        StringBuilder tmpRes = new StringBuilder();
        List<String> resList = new ArrayList<>();

        backtrack(root, tmpRes, resList);

        int res = 0;
        for (String s : resList){
            res += Integer.parseInt(s);
        }
        return res;
    }

    public void backtrack (TreeNode root,
                           StringBuilder tmpRes,
                           List<String> resList) {
        if (root == null){
            return;
        }

        if (root.left == null && root.right == null){
            tmpRes.append(root.val);
            String s = tmpRes.toString();
            resList.add(s);
            tmpRes.delete(tmpRes.length()-1, tmpRes.length());
        }

        tmpRes.append(root.val);
        backtrack(root.left, tmpRes, resList);
        backtrack(root.right, tmpRes, resList);
        tmpRes.delete(tmpRes.length()-1, tmpRes.length());

    }
}
