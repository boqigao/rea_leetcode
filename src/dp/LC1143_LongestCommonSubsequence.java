package dp;

/**
 * 一遍过，参考字符串匹配
 */
public class LC1143_LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int s1Len = text1.length();
        int s2Len = text2.length();
        int[][] dp = new int[s1Len+1][s2Len+1];
        for (int i = 0; i < s1Len + 1; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j < s2Len + 1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < s1Len + 1; i++) {
            for (int j = 1; j < s2Len + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt( j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1],
                            Math.max(dp[i][j-1], dp[i-1][j]));
                }
            }
        }
        return dp[s1Len][s2Len];
    }
}
