package twopointers;

import com.sun.jdi.IntegerValue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] mapS = new int[128];
        int[] mapT = new int[128];

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (Character c : tChars) {
            mapT[c]++;
        }

        int count = 0;
        String res = "";
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(mapT[c] > 0) {
                mapS[c]++;
                // 这里计算笑的意思是，因为我们后面对比的是count和t的长度，如果有出现一次重复的字符
                // 就要加一个count，直到s的数量够了，就不用了，这样
                if (mapS[c] <= mapT[c]) {
                    count++;
                }
            }


            if (count == t.length()) {
                // 如果T在start的频率比s在start的频率低
                while (mapT[s.charAt(start)] < mapS[s.charAt(start)]
                || mapT[s.charAt(start)] == 0) {
                    if (mapT[s.charAt(start)] < mapS[s.charAt(start)]) {
                        mapS[s.charAt(start)]--;
                    }
                    start++;
                }

                if (res.equals("") || i - start + 1 < res.length()) {
                    res = s.substring(start, i+1);
                }
            }
        }
        return res;
    }

    public String minWindowWrong(String s, String t) {

        char[] sChar = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        char[] tChar = t.toCharArray();
        for (char c : tChar) {
            map.put(c, -1);
            set.add(c);
        }

        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(sChar[i])) {
                left = i;
                map.put(sChar[i], i);
                break;
            }
        }
        int resLen = s.length();
        String res = "";

        for (int right = 0; right < s.length(); right++) {
            if (set.contains(sChar[right])) {
                set.remove(sChar[right]);
                map.put(sChar[right], right);
            }
            // 如果size 第一次 为0， 那么
            if (set.size() == 0) {
                String tmp = s.substring(left, right+1);
                if (tmp.length() < resLen) {
                    res = tmp;
                    resLen = tmp.length();
                }
                int nextLeft = s.length()-1;
                char nextChar = 0;
                for (Map.Entry<Character, Integer> e : map.entrySet()) {
                    if (e.getValue() < nextLeft) {
                        nextLeft = e.getValue();
                        nextChar = e.getKey();
                    }
                }
                left = nextLeft;
                set.add(nextChar);
            }
        }
        return res;
    }
}
