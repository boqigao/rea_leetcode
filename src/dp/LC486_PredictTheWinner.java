package dp;

/**
 * 这道题叫做典型的区间形dp，也叫最小最大问题
 * 博弈的问题
 *
 * dp[i][j] 定义的是，
 * 甲乙比赛，甲作为先手，在区间nums[i...j]里进行选择可以
 * 获得的净胜分。
 * 最终求的就是，甲先手面对区间[0....n-1]时候，甲对乙的净胜分是否>=0
 * 也就是dp[0][n-1]>=0?
 *
 * 具体分析而言
 * 甲先手面对区间[i...j]时候
 * 1. 如果甲选择nums[i]， 那么变成乙先手面对nums[i+1...j]
 * 而此时，我们已经计算出来当某人先手选择[i+1...j]的时候的结果
 * 已经被保存在dp[i+1][j]中，所以当甲选择nums[i]的时候
 * 乙对甲的净胜分为dp[i+1][j]
 * 所以对于甲来说，先手选择nums[i]所获得的分数为
 * nums[i] - dp[i+1][j]
 *
 * 2. 如果此时甲选择nums[j]，那么变成乙先手面对nums[i..j-1]
 * 所以同样也是, nums[j] - dp[i][j-1]即可
 *
 * 这种dp表格的形状，左下半边是空的，只要计算右上半边，所以叫倒三角形
 */
public class LC486_PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        // 首先如果是偶数的长度，那么一定是获胜
        if (nums.length % 2 == 0) {
            return true;
        }

        int[][] dp = new int[nums.length][nums.length];

        for(int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++ ) {
                dp[i][j] = Math.max(nums[i] - dp[i+1][j],
                        nums[j] - dp[i][j-1]);
            }
        }
        return dp[0][nums.length-1]>=0;
    }
}
