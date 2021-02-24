package dp;

/**
 * 动态规划 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
 * 这道题狡猾在你要自己记录一个最小值
 */
public class LC121_MaxProfitOfStock {
    public int maxProfit(int[] prices) {
        if (prices.length<=1) {
            return 0;
        }

        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        int res = 0;

        for (int i = 0; i < prices.length; i++) {
            res = Math.max(prices[i] - min, res);
            min = Math.min(prices[i], min);
        }

        return res;
    }
    public int maxProfitTimeOut(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i+1; j < prices.length; j++){
                res= Math.max(res, prices[j]- prices[i]);
            }
        }
        return res;
    }
}
