package twopointers;

import java.util.HashSet;
import java.util.Set;

public class LC125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        // if (s.length() == 0 || s.length() == 1) return true;
        Set<Character> set = new HashSet<>();
        for (char c = 'a'; c <= 'z'; c++) {
            set.add(c);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            set.add(c);
        }

        for (char c = '0'; c<='9'; c++) {
            set.add(c);
        }

        int i = 0, j = s.length()-1;
        while (i < j) {
            if(!set.contains(s.charAt(i))) {
                i++;
            }else if (!set.contains(s.charAt(j))) {
                j--;
            }else {
                if (Character.toLowerCase(s.charAt(i)) ==
                        Character.toLowerCase(s.charAt(j))) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
        }
        return true;

    }
}
