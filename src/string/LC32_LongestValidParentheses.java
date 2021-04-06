package string;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 */
public class LC32_LongestValidParentheses {

    /**
     * dp[] 的定义：
     * 以当前i结尾的字符串的最长有效括号的长度
     * 最后要求的是max dp[]
     * @param s
     * @return
     */
    public int longestValidParenthesesDp(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        dp[0] = 0;

        for (int i = 1; i < s.length(); i++) {
            // 如果是左括号，那么最大长度一定为0
            if (chars[i] == '(') {
                dp[i] = 0;
            }
            // 考虑右括号
            else  {
                //如果是形如 ....()的形状
                if(chars[i-1] == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }

                // 如果是形如 ....))的形状
                else if (i - dp[i-1] > 0 && s.charAt(i - dp[i-1] - 1)== '('){
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    /**
     * 用栈模拟一遍，将所有不能匹配的地方全都置为1
     * @param s
     * @return
     */
    public int longestValidParenthesesStack(String s) {
        Stack<Integer> stack = new Stack<>();

        int[] mark = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            // 如果是左括号，直接入栈
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            // 如果碰到右括号，碰到多余的话，就记录
            else {
                if (stack.empty()) {
                    mark[i] = 1;
                } else {
                    stack.pop();
                }
            }
        }

        // 全部扫描一遍以后，剩下的都是多余的左括号

        while (!stack.isEmpty()) {
            mark[stack.pop()] = 1;
        }

        int ans = 0, len = 0;
        for(int i = 0; i < s.length(); i++) {
            if(mark[i] == 1) {
                len = 0;
                continue;
            }
            len++;
            ans = Math.max(ans, len);
        }
        return ans;
    }
}
