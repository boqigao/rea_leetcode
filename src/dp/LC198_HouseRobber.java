package dp;

import java.util.Arrays;

/**
 * dp[i] 在到达房间i时候能偷窃的最大值
 */
public class LC198_HouseRobber {
    public int rob(int[] nums){
        int length = nums.length;
        int[] dp = new int[length];
        if (length == 0) {
            return 0;
        }
        Arrays.fill(dp, 0);
        dp[0] = nums[0];
        if (length > 1) {
            dp[1] = Math.max(dp[0], dp[1]);
        }
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[length - 1];
    }
}
