package dp;

/**
 * 这种题一般dp[i][j]表示
 * s1的0-i-1和s2的0-j-1能否交错成s3
 */
public class LC97_InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];

        // 如果是s1s2s3为空，那肯定是true
        dp[0][0] = true;
        // 如果没有s2的情况下，那就只看s1了
        // 如果s1==s3，那么就全为true，否则，从哪一位开始不等，那就从哪一位开始全是false
        for (int i = 1; i < s1.length(); i++){
            dp[i][0] = dp[i-1][0] && (s1.charAt(i - 1) == s3.charAt(i-1));
        }

        for (int j = 1; j < s2.length(); j++) {
            dp[0][j] = dp[0][j-1] && (s2.charAt(j-1) == s3.charAt(j-1));
        }

        for(int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                // 在看s1的i-1位置和s2的j-2位置能否拼成的时候
                // 如果看s1是否能拼成的时候
                // 首先前面得拼成，然后再看s1和s3的当前位置是否相同
                // s2同理
                dp[i][j] = dp[i][j-1] && (s2.charAt(j-1)== s3.charAt(i+j-1)) ||
                        dp[i-1][j]  && (s1.charAt(i-1)==s3.charAt(i+j-1));
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
