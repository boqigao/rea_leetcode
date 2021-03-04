package dp;

/**
 * 这道题的题意是最长回文子序列，而不是最长回文子串
 * 比如abaaaca的最长回文子序列是5，而最长回文子串是3
 * 所以我们可以定义dp[i][j] s[i...j]之间的最长回文子序列
 * 然后如果s[i] == s[j]就+2这种
 *
 *
 * 他其实是一个二维数组的右上方表格填表，
 * 从右下角填到左上角和右上角
 *
 * 为什么要从右下角填表呢？
 * 因为dp[i][j] 的更新是关系到dp[i+1][j-1]
 * 即当前位置的左下方一格
 */
public class LC516_LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        char[] chars = s.toCharArray();

        // 初始化：自己和自己的子序列当然为1
        for (int i = 0; i < len - 1; i++) {
            dp[i][i] = 1;
        }

        //因为从右下角开始填表，所以i得倒着写

        for (int i = len-1; i >=0; i++) {
            for (int j = i+1; j < len; j++) {
                if(chars[i]==chars[j]) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j],
                            dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}
