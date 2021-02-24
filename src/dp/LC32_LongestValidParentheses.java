package dp;

import java.util.Stack;

/**
 * 这道题有两种方法去做，stack或者dp
 *
 * 1. stack
 * 用栈模拟一遍，将所有无法匹配的括号的位置全部置1
 * 例如: "()(()"的mark为[0, 0, 1, 0, 0]
 * 再例如: ")()((())"的mark为[1, 0, 0, 1, 0, 0, 0, 0]
 * 经过这样的处理后, 此题就变成了寻找最长的连续的0的长度
 */
public class LC32_LongestValidParentheses {
    public int longestValidParenthesesStack(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] mark = new boolean[s.length()];
        int left = 0, len = 0, ans = 0;

        for (int i = 0; i < s.length(); i++) {
            // 如果当前位置是一个左括号，那么将当前位置的index入栈
            if (s.charAt(i) == '(') stack.push(i);
            else {
                // 如果当前位置是一个右括号，并且stack为空，说明多了个右括号
                if (stack.isEmpty()) mark[i] = true;
                // 如果stack非空，说明这个右括号不多余
                else {
                    stack.pop();
                }
            }
        }

        // 把剩下的留在stack的左括号的index都标记为tru
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            mark[cur] = true;
        }

        // 寻找标记与标记之间的最大长度
        for (int i = 0; i < s.length(); i++) {
            if(mark[i]) {
                len = 0;
                continue;
            }
            len++;
            ans = Math.max(ans, len);
        }

        return ans;
    }

    /**
     * dp方法：
     * dp[i]: 表示以下表i字符结尾的，最长有效括号的的长度
     * 如果是左括号，那dp[i]一定为0，因为最长有效括号不可能以左括号结尾
     * 如果是右括号，就更新dp计算
     * 这里分类讨论
     * 1.如果 s[i] == ) , s[i-1] == (
     * .........()
     * 那么这里非常直观的看出 dp[i] = dp[i-2] + 2
     *
     * 2. 如果s[i] == s[i-1] == )
     * ( ( ) )
     * 0 1 2 3
     * 那么这里我们需要找刨开中间的这些已经成对的括号的之前的一个左括号
     * 此时，比如dp[0] = 0
     * dp[1] = 0, dp[2] = 2
     * 我们在计算dp[3]时候，要去查看去除掉中间已经成对的这些括号的前一个
     * 也就是查看 s的 i - dp[i-1] -1的位置
     * 如果s[i - dp[i-1] -1]是左括号，那这样就多了一对儿
     * 在最后我们还需要加上(())之前面的括号
     * 比如 ()(())这种情况
     *     01
     * 这里 0 1也是成对的，也要加上，其长度是dp[1]
     *
     * 因此最终的方程是
     * dp[i] = 2   +  dp[i-1] + dp[i-dp[i-1]-2]
     *        新增的俩  内部的串   之前的成对串
     */
    public int longestValidParenthesesDP(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i > 2?dp[i-1] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
