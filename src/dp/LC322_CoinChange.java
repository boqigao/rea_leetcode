package dp;

import java.util.Arrays;

/**
 * 这道题绝对是经典题目了
 * dp[i]代表总金额为i的时候的最小硬币数
 */
public class LC322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int size = coins.length;
        // dp 0~amount
        int[] dp = new int[amount + 1];
        if (amount == 0) {
            return 0;
        }
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                // 如果coins[j] <= i的意思是，i可以刨开coins[j]来计算子问题
                // 比如 [2] , 3作为输入的情况
                // dp的变化是初始：[0,4,4,4]
                // i = 1, j = 0 [0,4,4,4]
                // i = 2, j = 0 [0,4,1,4]
                // i = 3, j = 0 [0,4,1,Math.min(4, 5)]
                // [0, 4, 1, 5]
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }

        // 如果dp[amount] 比 amount大，说明凑不成
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
