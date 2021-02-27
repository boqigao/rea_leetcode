package dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/javayi-ge-si-lu-da-bao-suo-you-gu-piao-t-pd1p/
 * 其实这个更好理解，但是细节不好理解
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-iv-by-8xtkp/
 * 还是官方的解答比较好理解
 */
public class LC188_BestStockIV {
    public int maxProfit(int k, int[] prices) {
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

    /**
     * hold[i][j]表示在第i天，经过j次交易后锁得到的最大收益
     * @param k
     * @param prices
     * @return
     */
    public int maxProfitEasyUnderstand(int k, int[] prices) {
        if(prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n/2);
        int[][] hold = new int[n][k+1];
        int[][] notHold = new int[n][k+1];
        hold[0][0] = -prices[0];
        notHold[0][0] = 0;

        for(int i = 1; i <= k; i++) {
            hold[0][i] = notHold[0][i] = Integer.MIN_VALUE/2;
        }

        /**
         * 这道题的核心是买卖算一次交易，所以只要买进或者卖出计算一次交易就好
         */
        for (int i = 1; i < n; i++) {
            hold[i][0] = Math.max(hold[i-1][0], notHold[i - 1][0] -prices[i]);
            for (int j = 1; j <= k; j++) {
                hold[i][j] = Math.max(hold[i-1][j], notHold[i-1][j] -prices[i]);
                notHold[i][j] = Math.max(notHold[i-1][j], hold[i-1][j-1] + prices[i]);
             }
        }
        return Arrays.stream(notHold[n-1]).max().getAsInt();
    }
}
