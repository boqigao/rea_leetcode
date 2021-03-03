package dp;

/**
 * 0-1背包问题，记住几个点，遍历物品要从前往后，遍历背包要从后往前
 */
public class LC474_OnesAndZeros {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (String s : strs){
            int[] zeroAndOne = calZeroAndOne(s);
            int zeros = zeroAndOne[0];
            int ones = zeroAndOne[1];

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] calZeroAndOne(String str) {
        int[] res = new int[2];
        for (char c : str.toCharArray()) {
            res[c-'0']++;
        }
        return res;
    }
}
