package dp;

/**
 * 这道题其实就是一个朴素思想，唯一要注意的地方是他要做奇偶判定
 */
public class LC5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String sOdd = isPalindrome(s, i, i);
            String sEven = isPalindrome(s, i, i+1);

            if (res.length() < sOdd.length()) {
                res = sOdd;
            }

            if (res.length() < sEven.length()) {
                res = sEven;
            }
        }
        return res;

    }

    private static String isPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }

        //在新一轮时候崩了，所以结果返回上一轮，记得substring方法是左闭右开
        return s.substring(left+1, right);
    }
}
