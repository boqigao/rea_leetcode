package bfs;

import java.util.Arrays;

/**
 * 因为 n < 10000
 * 感觉可以通过遍历+剪枝（记忆体）来做？
 * 假设有一个数组长 memo[n], 那么
 * memo[i]代表的是在数字i的时候的完全平方数的最小数量？
 * 直觉是对的！！但是转移的方法没有思考清楚，不然可以一步到位了！
 *
 * 几乎所有的动态规划解决方案，首先会创建一个一维或多维数组 DP 来保存中间子解的值，
 * 以及通常数组最后一个值代表最终解。
 */
public class LC279_PerfectSquares {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        //初始情况
        dp[0] = 0;

        //提前计算好所有平方数
        //在square_nums存着所有平方数
        int max_square_index = (int) Math.sqrt(n) + 1;
        int square_nums[] = new int[max_square_index];
        for(int i = 1; i < max_square_index; i++) {
            square_nums[i] = i * i;
        }

        for(int i = 1; i <=n; i++) {
            for(int s = 1; s < max_square_index; s++){
                //如果当前数字i比平方数要小，那就跳出循环
                if(i < square_nums[s]){
                    break;
                }

                // 一开始是max value，所以无论如何一开始会被更新
                // 假如i本身是完全平方数，那么这个比较的后者dp[0] + 1 = 1
                // 用来应付当前问题
                // 还有一个问题，为什么后面是+1呢？？
                // 其实他的意思是！
                // dp[i- square_nums[s]] + dp[square_nums[s]]
                // 而后者一定是1！
                // 比如说7的和
                // (2+1)+(4)
                // 那他就是前面一坨已经算好的加上刨去的这个4，就是n+1
                dp[i] = Math.min(dp[i], dp[i-square_nums[s]] + 1);
            }
        }
        return dp[n];
    }
}
