package dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * 这道题竟然要用三指针法
 */
public class LC264_UglyNumberII {

    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        Arrays.fill(ugly, 1);
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < n; i++) {
            int a = ugly[index2] * 2;
            int b = ugly[index3] * 3;
            int c = ugly[index5] * 5;
            int next = Math.min(a, Math.min(b, c));

            if (next == a) {
                index2++;
            }
            if (next == b) {
                index3++;
            }
            if (next == c) {
                index5++;
            }
            ugly[i] = next;
        }
        return ugly[n-1];
    }

    public int nthUglyNumberTLE2(int n) {
        int[] dp = new int[Integer.MAX_VALUE];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 1;
        dp[5] = 1;
        int cnt = 5, ans = 0;
        for (int i = 1; i < Integer.MAX_VALUE-1; i++) {
            if ((i%2!=0) || (i % 5!=0) || (i % 3!=0)){
                dp[i] = 0;
            }
            if (i%2 == 0) {
                dp[i] = dp[i/2];
            }
            if (i%3 == 0) {
                dp[i] = dp[i/3];
            }
            if (i%5 == 0) {
                dp[i] = dp[i/5];
            }
            if (dp[i] == 1){
                cnt++;
            }
            if (cnt == n) {
                ans = i;
                break;
            }
        }
        return ans;
    }


    private boolean isUgly (int n, HashSet<Integer> memoNormal,
                            HashSet<Integer> memoUgly){
        if (n == 1) {
            return true;
        }
        if (n % 2 == 0){
            if (memoUgly.contains(n/2) || memoUgly.contains(n)){
                memoUgly.add(n);
                return true;
            } else if (memoNormal.contains(n/2) || memoNormal.contains(n)){
                return false;
            } else {
                return isUgly(n/2,memoNormal, memoUgly);
            }
        }
        if (n % 3 == 0){
            if (memoUgly.contains(n/3) || memoUgly.contains(n)){
                memoUgly.add(n);
                return true;
            } else if (memoNormal.contains(n/3) || memoNormal.contains(n)){
                return false;
            } else {
                return isUgly(n/3, memoNormal, memoUgly);
            }
        }
        if (n % 5 == 0){
            if (memoUgly.contains(n/5) || memoUgly.contains(n)){
                memoUgly.add(n);
                return true;
            } else if (memoNormal.contains(n/5) || memoNormal.contains(n)){
                return false;
            } else {
                return isUgly(n/5, memoNormal, memoUgly);
            }
        }

        memoNormal.add(n);
        return false;
    }

    public int nthUglyNumberTLE(int n) {
        HashSet<Integer> memoUgly = new HashSet<>();
        memoUgly.add(1);
        int k = 0;
        for (int i = 0; i < n; i++){
            k = Collections.min(memoUgly);

            memoUgly.add(k * 2);
            memoUgly.add(k * 3);
            memoUgly.add(k * 5);
        }
        
        return k;

    }
}
