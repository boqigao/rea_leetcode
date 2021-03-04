package dp;

/**
 * @see LC516_LongestPalindromicSubsequence
 */
public class LC647_PalindromicSubstrings {
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();

        //dp[i][j]表示s的i到j的字符是否为回文子串
        boolean[][] dp = new boolean[n][n];

        for (int i = n-1; i>=0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j-i <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }

        return res;
    }
}
