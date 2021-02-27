package dp;

import java.util.Arrays;

/**
 * dp[i]到i为止的最大连续子数组的乘积
 * 上述想法是错的，因为这个数组是有负数的
 * 没办法用最常规的dp去做
 *
 * 方法，维护一个最大值，还有一个最小值
 * 每次最小值 更新时候要从 最大*当前值，当前值，还有最小乘当前值来算，
 * 因为可能是负的
 *
 */
public class LC152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        // 他维护一个mn，就是因为碰到下一个负数的话会反转
        for (int i = 1; i < length; i++) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }
}
