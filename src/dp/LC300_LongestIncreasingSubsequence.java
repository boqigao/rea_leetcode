package dp;

import java.util.Arrays;

public class LC300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {

        int len = nums.length;
        if (len < 2) {
            return len;
        }

        int[] dp = new int[nums.length];
        /**
         * 第 1 步：状态定义。dp[i] 表示以 nums[i] 结尾的最长上升子序列的长度。
         * 即：在 [0, ..., i] 的范围内，
         * 选择以数字 nums[i] 结尾可以获得的最长上升子序列的长度。
         *
         * 说明：以 nums[i] 结尾，是子序列动态规划问题的经典设计状态思路，
         * 思想是动态规划的无后效性（定义得越具体，状态转移方程越好推导）
         */
        //初始情况都是自己作为自己的结尾，所以都是1
        Arrays.fill(dp, 1);

        /**
         * 第 2 步：推导状态转移方程：遍历到 nums[i] 的时候，
         * 我们应该把下标区间 [0, ... ,i - 1] 的 dp 值都看一遍，
         * 如果当前的数 nums[i] 大于之前的某个数，那么 nums[i]
         * 就可以接在这个数后面形成一个更长的上升子序列。
         * 把前面的数都看了， dp[i] 就是它们的最大值加 $1$。
         * 即比当前数要小的那些里头，找最大的，然后加 $1$ 。
         */
        int res = dp[0];
        for (int i = 1; i < nums.length; i++ ) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
