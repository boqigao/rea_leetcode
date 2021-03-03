package dp;

import java.util.Arrays;

public class LC416_PartitionEqualSubsetSum {
    /**
     * @param {number[]} nums
     * @return {boolean}
     * 背包问题：看数组中是否存在加起来为sum/2的数.
     * 背包容量（V） = sum/2
     * 每一个物品只能装一次,如果出现背包中重量等于sum/2则为true else false
     * dp[i]表示能否填满容量为i的背包
     * 状态转移方程为 dp[i] = dp[i-1] || nums[i]+dp[i-nums[j]]
     * 举例:v = sum/2 = 11   nums = [1,5,11,5]  1是true 0 是false
     *          0  1  2  3  4  5  6  7  8  9  10  11
     *  nums[0] 0  1  0  0  0  0  0  0  0  0   0   0
     *  nums[1] 0  1  0  0  0  1  1  0  0  0   0   0
     *  nums[2] 0  1  0  0  0  1  1  0  0  0   0   1
     *  nums[3] 0  1  0  0  0  1  1  0  0  0   0   1
     */
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }

        int capacity = sum / 2;
        boolean[][] dp = new boolean[nums.length][capacity + 1];

        for (int i = 0; i <= capacity; i++){
            dp[i][0] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i-1][j] | dp[i-1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length-1][capacity];
    }

    /**
     * 这种做法是错的
     * 比如[1,1,2,2,]就无法找出正确答案
     * @param nums
     * @return
     */
    public boolean canPartitionWrong(int[] nums) {
        if (nums.length == 1){
            return false;
        }

        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        int sum1 =0, sum2 =0;

        while (i <= j) {
            if(sum1 <= sum2) {
                sum1 += nums[i];
                i++;
            } else {
                sum2+=nums[j];
                j--;
            }
        }

        return sum1 == sum2;
    }
}
