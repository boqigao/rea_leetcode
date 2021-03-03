package dp;

import java.util.Arrays;

/**
 * 494
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * sum(P) 前面符号为+的集合；sum(N) 前面符号为减号的集合
 * 所以题目可以转化为
 * sum(P) - sum(N) = target
 * => sum(nums) + sum(P) - sum(N) = target + sum(nums)
 * => 2 * sum(P) = target + sum(nums)
 * => sum(P) = (target + sum(nums)) / 2
 * 因此题目转化为01背包，也就是能组合成容量为sum(P)的方式有多少种
 */
public class LC494_TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;

        sum = Arrays.stream(nums).sum();

        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }

        //背包大小
        int w = (sum + S) / 2;
        int[] dp = new int[w + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = w; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[w];
    }
}
