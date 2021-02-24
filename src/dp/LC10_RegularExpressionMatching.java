package dp;

/**
 * https://www.youtube.com/watch?v=l3hda49XcDE
 * 别问了，直接看tushar大神的视频
 */

public class LC10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        // 初始化dp
        dp[0][0] = true;

        // 继续初始化dp
        // 处理一下a*, a*b*, a*b*c*这类的情况
        // 第一行的话相当于是匹配一个空的字符串
        // 比如上述这种 a*, a*b*, a*b*c*是可以匹配空字符串的，那就要true一下
        for (int i = 1; i < dp[0].length; i++) {
            if(pArray[i-1] == '*') {
                dp[0][i] = dp [0][i-2];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                // 这个很好理解，如果p中的当前位是.或者是与s当前位相同的字符
                // 那我们就可以将双方都删去，看前面匹不匹配
                // e.g., pattern = acdb.
                // string = acdbf
                // 的时候，只要将f和.都删去，查前面的表看acdb 和 acdb是否匹配即可
                if (pArray[j - 1] == '.' || pArray[j-1] == sArray[i-1]) {
                    dp[i][j] = dp[i-1][j-1];
                }

                // 如果p的当前位是*的话，就首先先查看当前行前2位的值
                // 这是啥意思呢，比如
                // pattern = acdb*
                // string = acd
                // 这种情况
                // 查看前2位的意思是，如果 b* 代表的是空字符串的话, 即"b*代表0次b的情况"
                // ，acd和当前字符串匹配的结果
                else if (pArray[j - 1] == '*') {
                    dp[i][j] = dp[i][j-2];

                    // 这又是啥意思呢，他的意思是，如果当前位的前1位是一个.或者等于s-1
                    // 比如
                    // pattern = ac.b* 或者 acfb*
                    // string = acfb
                    // 这种情况 因为 string[4] = patter[4]，向上看一格代表 string acfb 中的b是 b*的一部分
                    // 这样我们只要看acf 是否是acfb*的一部分即可
                    if (pArray[j - 2] == '.' || pArray[j - 2] == sArray[i - 1]) {
                        dp[i][j] = dp[i][j] | dp[i-1][j];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];

    }
}
