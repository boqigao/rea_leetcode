package dp;

public class LC343_IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i-1; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i-j));
                dp[j] = Math.max(dp[i], j * (i-j));
            }
        }
        return dp[n];
    }

    public int integerBreakWrongAns(int n) {
        int max = 1;
        for (int i = 1; i <= n/2; i++) {
            int res = 1;
            int part = 0;
            for (int j = 0; j < 100; j++) {
                int mRes = res;
                int mPart = part;
                res *= i;
                part += i;

                if (part > n) {
                    res = mRes * (n - mPart);
                    break;
                }
            }
            max = Math.max(res, max);
        }
        return max;
    }
}
