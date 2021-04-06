package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有的可能性：考虑回溯
 *
 * 回溯的核心：
 * 1。 选择
 * 2. 限制
 * 3. goal
 *
 * 回溯的核心写法：
 *  choose
 *  explore
 *  unchoose
 */
public class LC93_RebuildAllIps {
    static int count = 4;
    List<String> ans = new ArrayList<>();
    int[] segments = new int[count];

    public List<String> restoreIpAddresses(String s) {
        segments = new int[count];
        dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s, int segId, int segStart) {
        if (segId == 4) {
            // 如果已经有四个part， 并且已经走到最后
            if (segStart == s.length()) {
                StringBuilder ipAddr = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    ipAddr.append(segments[i]);
                    if (i != 3) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            // 如果已经有4个part，但是没走到最后，直接return
            return;
        }

        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导0，如果当前数字为0， 那么这一段ip地址只能为0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并且递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 255) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}
