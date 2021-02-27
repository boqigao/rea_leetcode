package dp;

import java.util.List;

/**
 * dp[i] 表示以i-1结尾的子串能否被成功拆分
 *
 * 注意注意！！：
 * 这道本质上来说，和走楼梯是一样的！！
 * @see LC746_MinCostClimbingStairs
 * 对于走楼梯来说，我们不是走到了某一阶台阶，然后回看其下面的2阶吗？
 *
 * 这道题就是走到了某一阶台阶，回看后面的LongestWordInDict 阶 台阶 而已
 * 本质上是没啥不一样的！！！
 *
 */
public class LC139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return false;
        }
        if (wordDict.size() == 0) {
            return false;
        }

        int maxWordLen = 0;
        for (int i = 0; i < wordDict.size(); i++) {
            maxWordLen = Math.max(maxWordLen, wordDict.get(i).length());
        }

        boolean[] dp = new boolean[s.length()+1];

        // 如果s中啥也没有，那么当然可以被拆分？
        dp[0] = true;

        // 这里的界很有意思 i是从(1~s.length)这个很好理解，因为要遍历整条串
        for (int i = 1; i <= s.length(); i++) {
            // j是从0到i,或者i-1，其实都一样，因为substring方法是左闭右开的，所以j<=i的时候仅仅是取到空集。。
            int tmp = Math.max((i - maxWordLen), 0);
            for (int j = tmp; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
