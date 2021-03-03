package dp;

/**
 * dp[i] (o-i)的最大表示方法
 */
public class LC91_DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0:1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i-1) == '1' || s.charAt(i-1)=='2'
            && s.charAt(i) < '7') {
                if (s.charAt(i) =='0') dp[i+1] = dp[i-1];
                else dp[i+1] = dp[i] + dp[i-1];
            } else if (s.charAt(i) == '0') {
                return 0;
            } else {
                dp[i+1] = dp[i];
            }
        }
        return dp[n];
    }
}
