package tree;

import java.util.ArrayList;
import java.util.List;

// 这道题不是单纯的dfs，应该用回溯的方法做
public class LC113_PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmpAns = new ArrayList<>();

        dfs(root, targetSum, res, tmpAns);
        return res;
    }

    private void dfs(TreeNode root,
                     int sum,
                     List<List<Integer>> res,
                     List<Integer> tmpAns){
        // 如果root已经是null了，就说明走过头，直接返回就好
        if(root == null){
            return;
        }
        // 如果没有左右儿子，并且node不是null，说明他是一个叶子节点
        // 并且此时root的值等于sum的话，说明我们找到一个解
        if(root.right == null && root.left== null && sum == root.val) {
            tmpAns.add(root.val);
            res.add(new ArrayList<>(tmpAns));
            // 这里注意我们一定要回溯到上一层，具体解释看45行
            // 就算找到一个正确结果，在别的枝上还可能有正确结果，所以不删掉不可能
            tmpAns.remove(tmpAns.size()-1);
            return;
        }
        // 在这一层分析完之后，如果不满足上述条件
        // 说明这并不是一个叶子节点，也不是一个空节点，说明我们要继续往下走

        //在走之前，加入当前节点的值
        tmpAns.add(root.val);

        dfs(root.left, sum-root.val, res, tmpAns);
        dfs(root.right, sum-root.val, res, tmpAns);

        //如果走完也不对，我们要把当前节点的值再删除掉，返回上层节点
        // 这里可能比较难理解
        /*
        比如当前树我们要求的结果是11
                 1
               2   3
              4 5  6 7
         加入我们现在走到2的时候，左右都不对，如果我们不删除这个不对的2节点
         那返回到3的时候，结果始终是带着2的，这肯定不正确
         所以走完2这边之后，要把2删掉
         */

        tmpAns.remove(tmpAns.size()-1);
    }
}
