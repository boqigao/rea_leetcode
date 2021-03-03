package dp;

/**
 * dp[i][j]在第i个交易日，持股1或者不持股0的最大收益
 * 只有在买入的时候计算手续费
 */
public class LC714_Stock_with_fee {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -fee-prices[0];
        dp[0][0] = 0;

        for (int i = 1; i < prices.length; i++){
            // 如果第i天不持股，要么卖了，要么还是持昨天的股票
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);

            // 如果第i天持股，那么要么是从不持股-》持股，新买股票
            // 要么是一直就持有
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - fee -prices[i]);
        }

        return dp[prices.length-1][0];
    }
}
