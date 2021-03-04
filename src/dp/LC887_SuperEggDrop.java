package dp;

public class LC887_SuperEggDrop {
    public int superEggDrop(int K, int N) {
        if (N == 1) {
            return 1;
        }

        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= K; i++) {
            dp[1][i] = 1;
        }

        int ans = -1;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                dp[i][j] = 1 + dp[i-1][j-1]
                        + dp[i-1][j];
            }
            if (dp[i][K] >= N) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}
