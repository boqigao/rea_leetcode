package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 参考
 * https://leetcode-cn.com/problems/increasing-subsequences/solution/491-di-zeng-zi-xu-lie-shen-sou-hui-su-xiang-jie-by/
 */
public class LC491_IncreasingSubsequences {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums,0);
        return res;
    }

    private void dfs(int[] nums, int startIndex) {
        // 如果path的长度是2以及以上，那我们就将其加入结果
        if (path.size() > 1){
            res.add(new ArrayList<>(path));
        }

        // 对于每一层，每一个分支
        // 我们都需要新建一个集合set来记录重复
        HashSet<Integer> hashSet = new HashSet<>();

        // 这里是为了去重
        for (int i = startIndex; i < nums.length; i++){
            if (//如果是非空path
                !path.isEmpty()&&
                //并且，下一个值比当前path的最后的值要小
                nums[i] < path.get(path.size()-1)||
                // 或者当前层中已经使用过了这个值
                hashSet.contains(nums[i])) {
                // 那么跳过这个值
                continue;
            }
            //以上条件都不满足的话，说明这个值比当前值大，
            // 并且这个值尚未被使用过

            // 加入到使用过的集合里
            hashSet.add(nums[i]);
            // 加入到结果中
            path.add(nums[i]);
            //
            dfs(nums, i + 1);

            // 去掉当前使用过的节点，进行回溯
            // 因为是包含在for循环里的！
            path.remove(path.size()-1);
        }

    }
}
