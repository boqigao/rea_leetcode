package dp;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 这道题的dp[i]的设计，自己本来的确是想对了的，但是思路没做对
 */
public class LC354_RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        /**
         * naive的方法，先按长排序，在按照O(N^2)的递增子序列来做
         */
        int n = envelopes.length;
        if (n < 1) return 0;
        int max = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(envelopes, Comparator.comparingInt(a -> a[0]));

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0]
                && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }

        return max;
    }
}
