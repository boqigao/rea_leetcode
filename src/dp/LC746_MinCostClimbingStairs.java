package dp;

/**
 * dp[i] 到达第i阶台阶时候所需要的最小步数
 * 所以如果按照错误的想法的话dp[cost.length-1]
 * 只能到达这届台阶，但是不能上去
 * 所以要dp[cost.length]
 */
public class LC746_MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }
        if (cost.length == 2) {
            return Math.min(cost[0],cost[1]);
        }

        int[] dp = new int[cost.length];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1],
                    dp[i-2] + cost[i-2]);
        }

        return dp[cost.length];

    }
}
