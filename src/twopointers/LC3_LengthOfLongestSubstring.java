package twopointers;

import java.util.HashSet;
import java.util.Set;

public class LC3_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }

        int len = s.length();

        int res = 0;
        int start = 0;
        for (int i = 0; i < len; i++) {
            int curChar = s.charAt(i);
            // last记录，当前元素上一次出现的地方，
            // 比如 abcdab
            // 在扫描到第二个a的时候
            // start 会发生变动，变成 start = start, 1
            // 相当于start从第一个b开始重新记录
            start = Math.max(start, last[curChar] + 1);
            res = Math.max(res, i - start + 1);

            last[curChar] = i;
        }

        return res;
    }


    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();

        int len = s.length();
        int res = 0;
        // 又指针是不会被清空的！！
        int j = 0;
        for (int i = 0; i < len; i++) {
            while (j < len && !set.contains(s.charAt(j)))  {
                set.add(s.charAt(j));
                res = Math.max (j-i+1, res);
                j++;
            }
            set.remove(s.charAt(i));
        }
        return res;
    }
}
