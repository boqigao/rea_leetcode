package dp;

/**
 * 这道题算是最基本的dp了
 * dp的根本就是数学归纳法
 *
 * 1. 设定初始值: dp[0] = xx, dp[1] = xx
 *
 * 2. 推导方程 dp[x] = ? dp[x-1]? dp[x-2]
 * 即：dp【x】和前面的关系是什么
 *
 * 3. 返回n
 *
 */
public class LC70_ClimbingStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 0; i <= n; i++) {
            //第n个台阶只能从第n-1或者n-2个上来。
            // 到第n-1个台阶的走法 + 第n-2个台阶的走法 = 到第n个台阶的走法
            dp[i] = dp[n-1] + dp[n-2];
        }

        return dp[n];
    }
}
