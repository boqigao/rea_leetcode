package dp;

/**
 * 虽然知道思路了，但是让自己写肯定还是写不来
 */
public class LC123_BestStockIII {
    /**
     * 比较时间消费比较大，但是比较好理解
     * ** 注意，LeetCode会超时 **
     *
     * dp[i][j] = 在第i次交易时候，在第j价格天的时候能获得的最大收益
     * 纵坐标是交易次数
     * 横坐标是当前价格
     *
     *   1 5 9 3 4 1 4 5 2
     * 1 0
     * 2 0
     * 3 0
     *
     * @param prices
     * @return
     */
    public int maxProfitTL(int[] prices) {
        int k = 2;
        int[][] dp = new int[k + 1][prices.length];
        for(int i = 0; i < k+1; i++){
            dp[i][0] = 0;
        }

        for(int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                int maxVal = 0;
                for (int m = 0; m < j; m++) {
                    // 这话的意思是，在m买入，j卖出的时候 + m时候的前一次的最大收益
                    maxVal = Math.max(maxVal, prices[j]
                    -prices[m] + dp[i-1][m]);
                }
                dp[i][j] = Math.max(dp[i][j-1], maxVal);
            }
        }

        return dp[k][prices.length - 1];

    }

    public int maxProfit(int[] prices) {
        int k = 2;
        int[][] dp = new int[k+1][prices.length];

        for (int i = 1; i < dp.length; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < dp[0].length; j ++) {
                dp[i][j] = Math.max(dp[i][j-1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i-1][j] - prices[j]);
            }
        }
        return dp[k][prices.length-1];
    }


}
