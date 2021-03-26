package twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @see LC76_MinimumWindowSubstring
 * 感觉这类题都是拿一个hashmap去记录
 */
public class LC30_SubStringWithConcatenation {
    public static void main(String[] args) {
        LC30_SubStringWithConcatenation test = new LC30_SubStringWithConcatenation();
        String s = "bfoobartefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(test.findSubstring("bfoobartefoobarman", words));
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();
        if (s.length() == 0 || words.length == 0) {
            return res;
        }

        for (String word: words) {
            // 记住这个方法，能够直接求string中的substring
            // 如果s中根本没有这个word，那么肯定gg
            if (!s.contains(word)) {
                return res;
            }
            // map 中保存每个word和他的频率
            // 记住这个方法
            // map的getordefault！
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }


        // 获得每个单词的长度，和我们需要的总长度
        int oneLen = words[0].length(), wordsLen = oneLen * words.length;

        // 如果主串s小于单词总和，则返回空
        if (wordsLen > s.length()) return res;


        // 只讨论从 0, 1, .... oneLen - 1开始的子串情况
        // 每次进行匹配的窗口大小为wordsLen，
        // 在窗口内部，每次后移一个单词长度
        // 用左右指针维持当前窗口位置
        for(int i = 0; i < oneLen; i++) {
            int left = i, right = i, count = 0;
            // 记录当前窗口内的word的map
            Map<String, Integer> subMap = new HashMap<>();

            // 他这里这个while 是啥意思呢，意思是 他比较了 i - > s.len() - oneLen 之间的所有字符串，在一个循环内，right和left是原来越大的
            while (right + oneLen <= s.length()) {
                // 得到一个新单词
                String word = s.substring(right, right + oneLen);

                // 窗口右移
                right += oneLen;

                // words[] 中如果没有这个单词，那么当前窗口一定匹配失败
                if (!wordMap.containsKey(word)) {
                    left = right;
                    // 窗口内单词统计map清空，重新统计
                    subMap.clear();
                    // 符合要求的单词清零
                    count = 0;
                } else {
                    // 统计当前窗口中这个单词出现的次数
                    subMap.put(word, subMap.getOrDefault(word, 0) + 1);
                    count++;

                    while (subMap.getOrDefault(word, 0) > wordMap.getOrDefault(word, 0)) {
                        String w = s.substring(left, left + oneLen);
                        subMap.put(w, subMap.getOrDefault(w, 0) - 1);
                        count--;
                        left+=oneLen;
                    }
                    if (count == words.length) res.add(left);
                }
            }
        }
        return res;
    }
}
